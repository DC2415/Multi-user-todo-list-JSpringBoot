<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>My Awesome Spring Boot App</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f2f2f2;
    }
    .container {
      text-align: center;
      margin-top: 100px;
      background-color: #ffffff;
      padding: 20px;
    }
  </style>
</head>
<body>
  <%@include file="common/header.jspf" %>
  <%@include file="common/navigation.jspf" %>

  <div class="container">
    <h1>Welcome ${username}</h1>
    <a href="list-todos" class="btn btn-primary">Manage your todos</a>
  </div>

  <%@include file="common/footer.jspf" %>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

