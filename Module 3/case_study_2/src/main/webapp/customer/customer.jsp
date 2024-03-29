<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/9/2023
  Time: 8:25 PM
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
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employee-servlet">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/customer-servlet">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service-servlet">Service</a>
                </li>
                <li class="nav-item">
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                            Contract
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="nav-link" href="contract-servlet?action=contract">Contract</a></li>
                            <li><a class="nav-link" href="contract-servlet?action=contractDetail">Contract detail</a>
                            </li>
                        </ul>
                    </div>
                </li>
            </ul>

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Họ và tên</th>
        <th scope="col">Ngày sinh</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Số điện thoại</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Mã loại khách</th>
        <th scope="col">Ten loại khách</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer" varStatus="">
        <tr>
            <th scope="row">${customer.id}</th>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <td>${customer.customerGender}</td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerAddress}</td>
            <td>${customer.customerTypeId}</td>
            <td>${customer.customer.nameCategory}</td>
                <%--            <td><a href="customer-servlet?action=delete&id=${customer.id}">Delete</a></td>--%>
            <td>

                <!-- Button trigger modal -->
                <button type="button" class="btn btn-outline-danger"
                        onclick="sendInf('${customer.customerName}','${customer.id}')" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                    Remove
                </button>

            </td>
            <td><a href="customer-servlet?action=view&id=${customer.id}">View</a></td>
            <td><a href="customer-servlet?action=update&id=${customer.id}">Update</a></td>

        </tr>
    </c:forEach>
    </tbody>
    <tr>

        <th colspan="9">
            <button class="btn btn-dark" style="width: 200px">
                <a style="text-decoration: none;color: white"
                   href="customer-servlet?action=create">Create</a>
            </button>
        </th>
    </tr>
    <tr>
        <th colspan="9">
            <button class="btn btn-dark" style="width: 200px">
                <a style="text-decoration: none;color: white"
                   href="customer-servlet?action=customer">Khách hàng sử dụng dịch vụ</a>
            </button>
        </th>
    </tr>

</table>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="?action=delete&id=${customer.id}" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Remove product</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="idDel" id="idDel">
                    Are you sure to remove <span id="nameDel" class="text-danger"></span> ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Remove</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script>
    function sendInf(name, id) {
        document.getElementById("nameDel").innerText = name;
        document.getElementById("idDel").value = id;
    }
</script>
</body>
</html>
