<%-- 
    Document   : history_buy
    Created on : Oct 28, 2022, 9:34:12 AM
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
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/ckeditor/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <c:if test="${requestScope.cus != null}">
                <%@include file="nav-customer.jsp" %>
            </c:if>
            <c:if test="${requestScope.ad != null}">
                <%@include file="nav-admin.jsp" %>
            </c:if>
            <div class="history_buy">
                <c:forEach var="list" items="${requestScope.list}">
                    <a class="buy_info" href="order_detail?orderId=${list.orderId}">
                        <div class="buy_info-detail">
                            <p><span>Tên người nhận: </span>${list.recipientName}</p>
                            <p><span>Ngày đặt hàng: </span>${list.orderDate}</p>
                            <p><span>Địa chỉ nhận hàng: </span>${list.shippingAddress}</p>
                            <p> <span>Số điện thoại người nhận: </span>${list.recipientPhone}</p>
                            <p><span>Tổng tiền: </span><fmt:formatNumber value = "${list.totalMoney}" type = "currency"/></p>
                        </div>
                    </a>
                </c:forEach>
            </div>

        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
