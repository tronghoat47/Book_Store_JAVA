<%-- 
    Document   : order_detail
    Created on : Oct 28, 2022, 10:49:14 AM
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
            <div class="detail-order">
                <c:forEach items="${requestScope.list}" var="i">
                    <div class="mycart-detail">
                        <div class="mycart-detail-img">
                            <img src="${i.book.image}" alt="">
                        </div>
                        <div class="mycart-detail-name">
                            ${i.book.name}
                        </div>
                        <div class="mycart-detail-quantity">
                            <span>${i.quantity}</span>
                        </div>
                        <c:if test="${requestScope.cus != null && i.re==false}">
                            <form class="mycart-detail-form" action="review">
                                <input type="hidden" name="id" value="${i.book.bookID}"/>
                                <input type="submit" value="Đánh giá"/>
                            </form>
                        </c:if>
                        <c:if test="${requestScope.ad != null || i.re}">
                            <form class="mycart-detail-form" action="product">
                                <input type="hidden" name="bookId" value="${i.book.bookID}"/>
                                <input type="submit" value="Xem chi tiết"/>
                            </form>
                        </c:if>
                    </div>
                </c:forEach>
            </div>

        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
