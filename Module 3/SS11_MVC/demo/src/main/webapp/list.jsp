<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student-servlet?action=showCreateForm">Thêm mới học viên</a>
<h1>Danh sách học viên</h1>
<table border="1px">
    <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giới tính</th>
            <th>Điểm</th>
            <th>Xếp loại</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="student" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${student.name}</td>

            <c:if test="${student.gender == false}">
                <td>Nữ</td>
            </c:if>
            <c:if test="${student.gender == true}">
                <td>Nam</td>
            </c:if>
            <td>${student.point}</td>

            <c:choose>
                <c:when test="${student.point >= 8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point > 6}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point > 3}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
