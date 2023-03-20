<%-- 
    Document   : login
    Created on : Oct 20, 2022, 8:59:22 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="CSS/auth-form.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
    </head>

    <body>
        <%@include file="navbar.jsp" %>
        <div class="form-background">
            <div class="form">
                <div class="form-content">
                    <div class="form-element">
                        <p class="form-name">Đăng Nhập</p>
                    </div>
                    <c:if test="${requestScope.loginFail != null}">
                        <div class="form-fail">
                            <p>${requestScope.loginFail}</p>
                        </div>
                    </c:if>

                    <form action="login" method="post" class="form-input" >
                        <c:set var="cookie" value="${pageContext.request.cookies}"/>
                        <input value="${username}" type="text" name="username" placeholder="Tên đăng nhập" value="${cookie.cuser.value}" /><br />
                        <input type="password" name="password" placeholder="Mật khẩu" value="${cookie.cpass.value}"/><br />
                        <input class="form-submit" type="submit" value="Đăng Nhập" />
                        <div class="rem">
                            <p>Nhớ mật khẩu</p><input type="checkbox" ${(cookie.crem!=null)?"check":""} name="rem" value="on" /><br />
                        </div>
                    </form>
                    <div class="form-end">
                        <a href="home">Trở lại</a>
                        <a href="register">Đăng ký nếu chưa có tài khoản</a>
                        <a href="forget">Quên mật khẩu</a>

                    </div>
                </div>

            </div>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
