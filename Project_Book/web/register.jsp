<%-- 
    Document   : register
    Created on : Oct 20, 2022, 11:28:11 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <p class="form-name">Đăng Ký</p>
                    </div>
                    <c:if test="${requestScope.registerFail != null}">
                        <div class="form-fail">
                            <p>${requestScope.registerFail}</p>
                        </div>
                    </c:if>
                    <form action="register" method="post" class="form-input">
                        <div class="form-select">
                            <span>Đăng ký với tư cách:</span>
                            <select name="role" id="">
                                <option ${requestScope.role==0?'selected':''} value="${0}">Khách hàng</option>
                                <option ${requestScope.role==1?'selected':''} value="${1}">Người bán</option>
                            </select>
                        </div>
                        <input value="${username}" type="text" placeholder="Tên đăng nhập" name="username" /><br />
                        <input value="${password}" type="password" placeholder="Mật khẩu" name="password"/><br />
                        <input  type="password" placeholder="Nhập lại mật khẩu" name="repassword"/><br />
                        <input class="form-submit" type="submit" value="Đăng Ký" />
                    </form>
                    <div class="form-end">
                        <a href="home">Trở lại</a>
                        <a href="login.jsp">Đăng nhập nếu bạn đã có tài khoản</a>
                    </div>
                </div>

            </div>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
