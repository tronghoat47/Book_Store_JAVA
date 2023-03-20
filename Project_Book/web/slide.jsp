<%-- 
    Document   : slide
    Created on : Oct 19, 2022, 10:27:01 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <div class="contain">
        <div class="bar1">
            <a href="home">
                <img src="images/logoDone.png" alt="" class="logo">
                <h3>Thạch Sanh</h3>
            </a>

            <form action="search" class="search">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input  type="text" value="${requestScope.content}" placeholder="Tên sản phẩm, tác giả..." name="content">
                <select name="cate" id="select-cate">
                    <option value="${0}">ALL Categories</option>
                    <c:forEach items="${requestScope.listCate}" var="listCate">
                        <option ${listCate.categoryID==cateId?'selected':''} value="${listCate.categoryID}">${listCate.name}</option>
                    </c:forEach>                              
                </select>
            </form>
            <div class="cart">
                <a href="mycart" class="cart_text">Giỏ hàng (${sessionScope.size})</a>
                <i class="fa-solid fa-cart-shopping"></i>
            </div>
        </div>
    </div>
</div>
