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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<form action="/tro-servlet?action=create" method="post">
    <div class="col-md-6">
        <label class="form-label">Tên người thuê trọ</label>
        <input name="ten_nguoi_thue_tro" type="text" class="form-control" >
    </div>
    <div class="col-md-6">
        <label class="form-label">Số điện thoại</label>
        <input name="so_dien_thoai" type="text" class="form-control">
    </div>
    <div class="col-md-6">
        <label class="form-label">Ngày bắt đầu thuê</label>
        <input name="ngay_bat_dau_thue" type="text" class="form-control" >
    </div>
    <div class="col-md-6">
        <label class="form-label">Mã hình thức thanh toán</label>
        <select class="form-select" name="ma_hinh_thuc_thanh_toan" >
                <c:forEach var="t" items="${list}" >
                    <option value="${t.maThanhToan}">${t.tenThanhToan}</option>
                </c:forEach>
        </select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Ghi chú</label>
        <input name="ghi_chu" type="text" class="form-control" >
    </div>
    <div class="col-md-6">
        <button type="submit" class="btn btn-primary">Tạo mới</button>
    </div>
</form>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>
