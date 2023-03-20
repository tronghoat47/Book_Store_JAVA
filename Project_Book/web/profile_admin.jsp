<%-- 
    Document   : profile_admin
    Created on : Oct 24, 2022, 4:34:17 PM
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
        <script>
            function chooseFile(fileInput) {
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#image').attr('src', e.target.result);
                    }
                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        </script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <%@include file="nav-admin.jsp" %>
            <c:set value="${requestScope.admin}" var="admin"/>
            <form class="detail" action="profile_admin" method="post">
                <div class="detail-text">
                    <c:if test="${requestScope.updateSuccsess!=null}">
                        <p class="success">${updateSuccsess}</p>
                    </c:if>
                    <input style="display: none" type="number" name="adminId" value="${admin.adminId}"/>
                    <span>Tên đăng nhập: </span><input readonly class="input" type="text" name="username" value="${admin.username}"/><br/>
                    <span>Tên: </span><input class="input" type="text" name="firstname" value="${admin.firstname}"/><br/>
                    <span>Họ: </span><input class="input" type="text" name="lastname" value="${admin.lastname}"/><br/>
                    <span>Email: </span><input class="input" type="text" name="email" value="${admin.email}"/><br/>
                    <span>Điện thoại: </span><input class="input" type="number" name="phone" value="${admin.phone}"/><br/>
                    <span>Địa chỉ: </span>
                    <textarea rows="20" cols="20" id="editor" name="address"">${admin.address}</textarea><br/>

                    <input class="submit" type="submit" value="Lưu"/>
                </div>
                <div class="detail-img">
                    <span style="color: var(--primary-color);">Ảnh đại diện: </span>
                    <img src="${admin.image}" id="image" alt="">
                    <input class="submit" type="file" name="image" onchange="chooseFile(this)"
                           value="${admin.image}"
                           accept="image/gif, image/jpeg, image/jpg, image/png"/>
                </div>

            </form>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
        <script>
            CKEDITOR.replace('editor');
        </script>
    </body>
</html>
