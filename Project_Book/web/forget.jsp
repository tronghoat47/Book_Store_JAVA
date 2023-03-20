<%-- 
    Document   : forget
    Created on : Oct 20, 2022, 11:33:54 PM
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
        <link rel="stylesheet" href="CSS/auth-form.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="form-background">
            <div class="form">
                <div class="form-content">
                    <div class="form-element">
                        <p class="form-name">Khôi phục mật khẩu</p>
                    </div>
                    <c:if test="${requestScope.forgetFail != null}">
                        <div class="form-fail">
                            <p>${requestScope.forgetFail}</p>
                        </div>
                    </c:if>
                    <c:if test="${requestScope.forgetSuccess != null}">
                        <div style="background-color: rgba(12, 143, 69, 0.7);" class="form-fail">
                            <p>${requestScope.forgetSuccess}</p>
                        </div>
                    </c:if>
                    <form action="forget" class="form-input" method="post">
                        <input type="text" placeholder="Tên đăng nhập" name="username"/><br />
                        <input type="password" placeholder="Mật khẩu mới" name="password"/><br />
                        <input type="password" placeholder="Nhập lại mật khẩu" name="repassword"/><br />
                        <input class="form-submit" type="submit" value="Cập nhật" />
                    </form>
                    <div class="form-end">
                        <a href="login">Đăng nhập</a>
                        <a href="home">Trở về</a>
                    </div>
                </div>

            </div>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
