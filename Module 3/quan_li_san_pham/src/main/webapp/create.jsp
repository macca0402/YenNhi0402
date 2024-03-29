<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/10/2023
  Time: 2:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<nav style="margin-top: 0" class="navbar navbar-expand-lg bg-light">
    <div>
        <button type="button" class="btn btn-outline-success">
            <a style="text-decoration: none;color: forestgreen" href="/san-pham-servlet">
                Danh sách sản phẩm
            </a>
        </button>
    </div>
</nav>

<form action="/san-pham-servlet?action=create" method="post">

    <div class="col-md-6">
        <label class="form-label">Tên sản phẩm</label>
        <input name="ten" type="text" class="form-control">
        <span style="color: red">${message}</span>
    </div>
    <div class="col-md-6">
        <label class="form-label">Giá</label>
        <input name="gia" type="text" class="form-control" required>
        <span style="color: red">${message1}</span>
<%--        required pattern="[1-9]{1}\d{7}"--%>
    </div>
    <div class="col-md-6">
        <label class="form-label">Số lượng</label>
        <input name="so_luong" type="text" class="form-control" required>
        <span style="color: red">${message2}</span>
<%--        required pattern="^\d+$" title="Phải là số nguyên dương"--%>
    </div>
    <div class="col-md-6">
        <label class="form-label">Màu sắc</label>
        <select class="form-select" name="mau">
            <option value="Đỏ">Đỏ</option>
            <option value="Xanh">Xanh</option>
            <option value="Đen">Đen</option>
            <option value="Trắng">Trắng</option>
            <option value="Vàng">Vàng</option>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Phân loại</label>
        <select class="form-select" name="id_danh_muc">
            <c:forEach var="t" items="${list}">
                <option value="${t.id}">${t.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Mô tả</label>
        <input name="mo_ta" type="text" class="form-control">
    </div>
    <div class="col-md-6">
        <button type="submit" class="btn btn-primary">Tạo mới</button>
    </div>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
