# JavaBank Step 02: Servlet API & JSP

## Goal

Upgrade your app to a web app using the Jakarta Servlet API, with request 
handling and dynamic page rendering, while applying the MVC architectural 
design pattern.

## Skills

By doing this assignment, you will:

- Apply the MVC architectural design pattern.
- Understand the basics of Tomcat.
- Get comfortable using the Servlet API, handling HTTP GET and POST requests.
- Understand how servlets and JSPs can relate to each other.
- Practice your front-end development skills by creating new interactive pages.
- Practice using Maven plugins.
- Practice implementing unit tests.

## Instructions

For this assignment, you will apply the concept of separation of concerns with 
MVC and upgrade the project's infrastructure to use the Tomcat servlet container 
and handle requests using the Jakarta Servlet API and JSPs.

Your Jakarta Server Pages(JSP) will display the following:

- A list of customers (`index.jsp`).
- Details of a specific customer (`profile.jsp`).
- A form to add a customer (`add.jsp`).

### Starting Point

The `skeleton` folder, located in week 16 of your class repository, contains the 
proposed implementation for JavaBank Step 01, a preview of the pages, and the assets 
you will need to complete this exercise.
In `views/preview/desktop`, you will find screenshots of `index.jsp`, `profile.jsp`, 
and `add.jsp` pages.


> This assignment will be the first without a `main()` method. So, what is  now happening in the `main()` method (the setup of the customers and accounts), should be moved elsewhere to a place that makes more sense to you according to the new design pattern applied. The absence of the `main()` method happens because the application's entry point is no longer in a standalone Java program. Instead, the servlet container itself manages the web application's lifecycle.


### Configuration

#### Integrate Tomcat

1. Ensure you have Tomcat installed.

> NOTE: If you don't, you can find the instructions in the [OS Setup](https://whiteboard.fullstackonline.codeforall.io/tutorials/os-setup/os-setup.html) you did at the beginning of the course.

2. Properly configure Tomcat on your local machine.

Consult our [tutorial on configuring Tomcat](https://whiteboard.fullstackonline.codeforall.io/tutorials/tomcat/configure.html)
and [another one](https://whiteboard.fullstackonline.codeforall.io/tutorials/tomcat/deploy.html)
with an example of how to create a web app with Tomcat. 

Follow both steps to configure Tomcat properly and understand how it works.

#### Create the `webapp` directory.

To create this directory using IntelliJ, right-click on `src/main`, choose `New` > `Directory` in the dropdown, and name it `webapp`.

Inside it, create yet another directory called `WEB-INF`, and place a `web.xml` file inside of it. Use the following code to create this file, changing the name and path of the servlet class according to your configuration:


```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!--defines the servlet-->
    <servlet>
        <!--defines the name of the servlet-->
        <servlet-name>MyServlet</servlet-name>
        <!--specifies the path to the servlet class-->
        <servlet-class>com.codeforall.online.javabank.controllers.MyServlet</servlet-class>
    </servlet>

    <!--maps the servlet to a URL-->
    <servlet-mapping>
        <!--specifies the name of the servlet-->
        <servlet-name>MyServlet</servlet-name>
        <!--the string in this tag defines
        the path that will be added to the URL-->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
```

#### Integrate Maven.

Ensure your source code is in the `src/main/java` directory and that your
web (JSP) pages are in the `src/main/webapp/templates` directory.

Your `webapp/templates` folder should have the following:

- A `styles` folder with the `style.css` file.
- An `assets` folder with the images you need.

The final structure of the `webapp` folder should appear as follows:

[`webapp folder`](https://whiteboard.fullstackonline.codeforall.io/assignments-learners/_images/webapp.png)

#### Add dependencies and package.

You will use the Jakarta Servlet API library, so you'll need to add the corresponding dependency to your `pom.xml`
file. You will also create your very first WAR file.

> NOTE: A WAR (Web Application Archive) file is a type of archive file used to package Java web applications. It is similar to a JAR file, but it contains all the necessary components of a web application, including servlets, JSPs, CSS, configuration files, libraries, and other resources required for the application to run.

Your `pom.xml` should be similar to this example:

```xml
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.codeforall.online</groupId>
    <artifactId>javabank</artifactId>
    <version>1.0-SNAPSHOT</version>

    <name>JavaBank</name>
    <packaging>war</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>

        <!-- test dependencies -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>pl.pragmatists</groupId>
            <artifactId>JUnitParams</artifactId>
            <version>1.1.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.10.0</version>
            <scope>test</scope>
        </dependency>


        <!-- dependency which allows access to the Jakarta Servlet API -->
        <dependency>
            <groupId>jakarta.servlet</groupId>
            <artifactId>jakarta.servlet-api</artifactId>
            <version>6.0.0</version>
            <scope>provided</scope>
        </dependency>

    </dependencies>

    <build>
        <finalName>JavaBank</finalName>
        <!-- a compiler plugin which indicates the version of Java used -->
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.3</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>

            <!-- a war plugin that might be necessary for some versions of the archetype -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.3.1</version>
            </plugin>

            <!-- Tomcat plugin -->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <url>http://localhost:8080/manager/text</url>
                    <server>tomcat</server>
                    <path>/javabank</path>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### Applying Servlet API and JSP

You need to modify your Java application to work with Jakarta Servlets and handle requests and responses. For
instance, you might create a Servlet that receives a customer ID,
performs necessary logic (e.g., finding the customer with said ID), and
generates dynamic content to be displayed.

Integrate JakartaServer Pages (JSP) into the web app to simplify dynamic
content creation. For example, you will create JSP files containing
the HTML structure and embed Java code within to generate content 
dynamically.

In essence, update your web app’s code to leverage Jakarta Servlets and JSP
to handle requests and generate dynamic pages.

Also, remember that there will be no persistent storage — text files or
databases — for now. Customer and account data will exist _in memory_,
meaning that data will remain stored only while the application that
created it is still running.

#### Jakarta Server Pages (JSP).

To import Java Classes into your JSP, don't forget to add their imports:

```jsp
<%@ page import="com.codeforall.online.javabank.model.Account" %>
```

Add the imports to the top of the JSP page:

```jsp
<%@ page import="com.codeforall.online.javabank.model.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>JavaBank: Home</title>
</head>

<!-- [...] -->
```

To get the attribute currently set on `ServletContext`, use the following line in the JSP file:

```jsp
<% Account account = (Account) request.getAttribute("account"); %>
```

This will allow you to get the values sent from the Servlet you've created to answer this request.

>NOTE: You don’t need to implement the “Upload photo“ functionality on the "Add Customer" page.

### Deployment

The end result should be: 

- You should see the customer list page at the web app’s root URL — from now on, it’s `localhost:8080/javabank`.
- You should see a customer page for a specific customer at the URL — on
`localhost:8080/javabank/?customerId=1`.
- You should see the add customer form page - on `localhost:8080/javabank/add`.

### Tests

Don't forget to add tests to the new functionality you have created.
