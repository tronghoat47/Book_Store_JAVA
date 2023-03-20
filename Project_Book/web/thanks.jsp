<%-- 
    Document   : thanks
    Created on : Oct 28, 2022, 8:51:18 AM
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
        <link rel="stylesheet" href="CSS/admin.css">
        <link rel="stylesheet" href="CSS/product.css">
        <link rel="stylesheet" href="CSS/cart.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/ckeditor/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="thanks">
            <h1>Cảm ơn ${sessionScope.account.username} đã mua hàng của Thạch Sanh</h1>
            <a href="home">Tiếp tục mua hàng</a>
        </div>

        <%@include file="footer.jsp" %>
        <%@include file="click.jsp" %>
    </body>
</html>
