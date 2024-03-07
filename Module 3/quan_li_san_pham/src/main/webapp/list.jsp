<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/25/2023
  Time: 4:17 PM
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
    <div>
        <form action="/san-pham-servlet?action=search" class="d-flex" role="search" method="post">
            <input name="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">
                    Search
            </button>
        </form>
    </div>
</nav>
<table class="table">
    <thead>
    <tr>

        <th scope="col">ID</th>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Giá</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Màu sắc</th>
        <th scope="col">Phân loại</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="sanPham" varStatus="">
        <tr>
            <th scope="row">${sanPham.id}</th>
            <td>${sanPham.ten}</td>
            <td>${sanPham.gia}</td>
            <td>${sanPham.soLuong}</td>
            <td>${sanPham.mauSac}</td>
            <td>${sanPham.category.name}</td>
            <td>${sanPham.moTa}</td>


            <td>
                <button class="btn btn-outline-warning" data-bs-toggle="modal">
                    <a style="text-decoration: none;color: orange"
                       href="/san-pham-servlet?action=delete&id=${sanPham.id}">
                        Delete
                    </a>
                </button>
            </td>
            <td>
                <button class="btn btn-outline-warning" data-bs-toggle="modal">
                    <a style="text-decoration: none;color: orange"
                       href="/san-pham-servlet?action=update&id=${sanPham.id}">
                        Update
                    </a>
                </button>
            </td>
        </tr>

    </c:forEach>
    <tr>
        <th colspan="9">
            <button class="btn btn-dark" style="width: 200px">
                <a style="text-decoration: none;color: white"
                   href="/san-pham-servlet?action=create">
                    Thêm mới </a>
            </button>
        </th>
    </tr>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</body>

</html>
