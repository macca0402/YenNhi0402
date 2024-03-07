<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27/9/2023
  Time: 8:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--private int id;--%>
<%--private String name;--%>
<%--private boolean gender;--%>
<%--private double point;--%>
<form action="/student-servlet?action=create" method="post">
    <label>Mã: <input type="number" name="id"></label><br>
    <label>Tên: <input type="text" name="name"></label><br>
    <label>
        Giới tính: <input type="radio" name="gender" value="male"> Nam
        <input type="radio" name="gender" value="female"> Nữ
    </label><br>
    <label>
        Điểm <input type="number" name="point">
    </label>
    <input type="submit" value="Thêm mới">
</form>
</body>
</html>
