<%-- 
    Document   : detail
    Created on : Oct 23, 2022, 8:18:17 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/base.css">
        <link rel="stylesheet" href="CSS/main.css">
        <link rel="stylesheet" href="CSS/admin.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <%@include file="nav-admin.jsp" %>
            <div class="detail">
                <div class="detail-text">
                    <div class="detail-name"><span>Tên: </span>${requestScope.book.name}</div>
                    <div class="detail-author"><span>Tác giả: </span>${requestScope.book.author}</div>
                    <div class="detail-cate"><span>Thể loại: </span>${requestScope.book.categoryName}</div>
                    <div class="detail-nxb"><span>Nhà xuất bản: </span>${requestScope.book.title}</div>
                    <div class="detail-price"><span>Giá: </span>$${requestScope.book.price}</div>
                    <div class="detail-discount"><span>Chiết khấu: </span>${requestScope.book.discount}%</div>
                    <div class="detail-date"><span>Ngày ra mắt: </span>${requestScope.book.releaseDate}</div>
                    <div class="detail-describe"><span>Miêu tả: </span>${requestScope.book.describe}</div>
                </div>
                <div class="detail-img">
                    <img src="${requestScope.book.image}" alt="">
                </div>
            </div>
                   
        </div>
                 <%@include file="click.jsp" %>
                    <%@include file="footer.jsp" %>
    </body>
</html>
