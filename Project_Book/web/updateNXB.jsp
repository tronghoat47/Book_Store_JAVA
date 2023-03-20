<%-- 
    Document   : updateNXB
    Created on : Nov 3, 2022, 1:38:35 PM
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
        <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/ckeditor/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <%@include file="nav-admin.jsp" %>
            <c:set value="${requestScope.getNXB}" var="nxb"/>
            <form class="detail" action="updateNXB" method="post">
                <div class="detail-text">
                    <c:if test="${requestScope.updateSuccsess!=null}">
                        <p class="success">${updateSuccsess}</p>
                    </c:if>

                    <input type="hidden" name="title" value="${nxb.title}"/><br/>
                    <span>Nhà xuất bản: </span><input class="input" type="text" value="${nxb.title}" name="title1"/><br/>
                    <input class="submit" type="submit" value="Lưu"/>
                </div>

            </form>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
