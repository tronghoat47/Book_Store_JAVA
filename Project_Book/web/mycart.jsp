<%-- 
    Document   : mycart
    Created on : Oct 26, 2022, 7:51:46 PM
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
        <c:set var="o" value="${requestScope.cart}"/>
        <div class="mycart">
            <div class="mycart-head">
                <h1><i class="fa-solid fa-cart-shopping"></i> Giỏ hàng</h1>
                <h1><a href="home">Tiếp tục mua sắm</a></h1>
            </div>

            <c:if test="${cookie.cart==null}">
                <div class="mycart-none">
                    <p>Chưa có sản phẩm</p>
                    <i class="fa-solid fa-cart-plus"></i>
                </div>
            </c:if>
            <c:forEach items="${o.items}" var="i">
                <div class="mycart-detail">
                    <div class="mycart-detail-img">
                        <img src="${i.book.image}" alt="">
                    </div>
                    <div class="mycart-detail-name">
                        ${i.book.name}
                    </div>
                    <div class="mycart-detail-old">
                        <p><fmt:formatNumber value = "${i.book.price}" type = "currency"/></p>
                    </div>
                    <div class="mycart-detail-new">
                        <p><fmt:formatNumber value = "${i.price}" type = "currency"/></p>
                    </div>
                    <div class="mycart-detail-quantity">
                        <button><a href="process?num=-1&id=${i.book.bookID}">-</a></button>
                        <span>${i.quantity}</span>
                        <button><a href="process?num=1&id=${i.book.bookID}">+</a></button>
                    </div>
                    <div class="mycart-detail-price">
                        <fmt:formatNumber value = "${i.price*i.quantity}" type = "currency"/>
                    </div>
                    <form class="mycart-detail-form" action="process" method="post">
                        <input type="hidden" name="id" value="${i.book.bookID}"/>
                        <input type="submit" value="Xóa"/>
                    </form>
                </div>
            </c:forEach>

            <div class="check-ao"></div>

            <div class="mycart-checkout">
                <div class="free">
                    Miễn phí vận chuyển với đơn hàng từ <span>$500</span>
                </div>
                <div class="checkout-price">
                    Tổng thanh toán: <span><fmt:formatNumber value = "${o.totalMoney}" type = "currency"/></span>
                </div>
                <form action="checkout">
                    <input type="submit" value="Thanh toán"/>
                </form>
            </div>
        </div>

        <%@include file="click.jsp" %>
    </body>
</html>
