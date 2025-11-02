<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title> Bank App</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    </head>

    <body>
      <nav>
        <a href="http://localhost:8080/ListController">← Go Back</a> //falta a imagem da seta para trás
      </nav>
        <h1>Bank App</h1>

<form>
  <div class="mb-3">
    <label for="customerId" class="form-label">Customer Id:</label>
    <input type="text" class="form-control" id="customerId" email="ID">
  </div>

    <div class="mb-3">
    <label for="exampleInputFirstName1" class="form-label">First Name</label>
    <input type="name" class="form-control" id="exampleInputFirstName1">
  </div>

  <div class="mb-3">
    <label for="exampleInputLastName1" class="form-label">Last Name</label>
    <input type="name" class="form-control" id="exampleInputLastName1">
  </div>
    
  <div class="mb-3">
    <label for="exampleInputPhone1" class="form-label">Phone Number</label>
    <input type="phone" class="form-control" id="exampleInputPhone1">
    <div id="phoneHelp" class="form-text">We'll never share your phone with anyone else.</div>
  </div>

  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>

  <button type="save" class="btn btn-primary">Save</button>
  <button type="cancel" class="btn btn-primary">Cancel</button>
</form>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>

</html>

