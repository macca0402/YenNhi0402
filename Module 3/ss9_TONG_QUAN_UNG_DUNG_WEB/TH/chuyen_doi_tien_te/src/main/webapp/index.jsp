<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Currency Converter</a>
<form action="" method="post">
    <p>Rate: </p><br>
    <input type="text" name="rate">
    <p>USD: </p><br>
    <input type="text" name="USD">
</form>
</body>
</html>