<%-- 
    Document   : navbar
    Created on : Oct 19, 2022, 11:48:13 AM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="first">
    <div class="grid">
        <nav class="header__navbar">
            <ul class="header__navbar-list">
                <li class="header__navbar-item header__navbar-item--ship header__navbar-item--separate">
                    <i class="fa-sharp fa-solid fa-truck-fast"></i>
                    Miễn phí giao hàng
                </li>
                <li class="header__navbar-item header__navbar-item--separate">
                    <a href="" class="header__navbar-item-link">
                        <i class="fa-sharp fa-solid fa-address-book"></i>
                        Liên hệ
                    </a>
                </li>
                <li class="header__navbar-item">
                    <a href="" class="header__navbar-item-link">
                        <i class="fa-solid fa-circle-info"></i>
                        Trợ giúp
                    </a>
                </li>
            </ul>

            <ul class="header__navbar-list">
                <li class="header__navbar-item header__navbar-item-link header__navbar-item--separate">
                    
                    <c:if test="${sessionScope.account == null}">
                        <a href="login">Đăng Nhập</a>
                    </c:if>
                    <c:if test="${sessionScope.account != null}">
                        <a href="crud">${account.username}</a>
                    </c:if>
                        <i class="fa-solid fa-user-tie"></i> 
                </li>
                <li class="header__navbar-item header__navbar-item-link">
                    <c:if test="${sessionScope.account == null}">
                        <a href="register">Đăng Ký</a>
                        <i class="fa-solid fa-users"></i>
                    </c:if>
                    <c:if test="${sessionScope.account != null}">
                        <a href="logout">Đăng xuất</a>
                        <i class="fa-solid fa-right-from-bracket"></i>
                    </c:if>

                </li>
            </ul>
        </nav>
    </div>
</div>

<div class="navao"></div>
