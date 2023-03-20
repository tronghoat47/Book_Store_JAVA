<%-- 
    Document   : receive
    Created on : Oct 28, 2022, 8:08:08 AM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>
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
        <link rel="stylesheet" href="CSS/product.css">
        <link rel="stylesheet" href="CSS/cart.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/ckeditor/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <c:set var="customer" value="${requestScope.cus}"/>
        <div class="mycart">
            <div class="mycart-head">
                <h1>Thông tin nhận hàng</h1>
            </div>
            <form class="detail" action="checkout" method="post">
                <div class="detail-text">
                    <span>Tên người nhận: </span><input class="input" type="text" name="firstname" value="${customer.firstname}"/><br/>
                    <span>Số điện thoại: </span><input class="input" type="number" name="phone" value="${customer.phone}"/><br/>
                    <span>Ghi chú: </span><input class="input" type="text" name="note"/><br/>
                    <span>Địa chỉ nhận hàng: </span>
                    <input class="input" name="address" value="${customer.address}"><br/>
                </div>
                <div class="check-ao"></div>

                <div class="mycart-checkout">
                    <a href="mycart">Quay lại</a>

                    <input type="submit" value="Thanh toán"/>
            </form>
        </div>
    </div>

    <%@include file="click.jsp" %>
    <script>
        CKEDITOR.replace('editor');
    </script>
</body>
</html>
