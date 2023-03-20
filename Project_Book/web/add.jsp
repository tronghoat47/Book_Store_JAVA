<%-- 
    Document   : add
    Created on : Oct 23, 2022, 11:58:17 PM
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
            <form class="detail" action="add" method="post">
                <div class="detail-text">
                    <span>Tên: </span><input placeholder="Nhập tên sách" required class="input" type="text" name="name"/><br/>
                    <span>Tác giả: </span><input placeholder="Nhập tên tác giả" required class="input" type="text" name="author"/><br/>
                    <span>Thể loại: </span>
                    <select class="search-admin" name="cate">
                        <c:forEach items="${requestScope.listCate}" var="listCate">
                            <option value="${listCate.categoryID}">${listCate.name}</option>
                        </c:forEach>                              
                    </select><br/>
                    <span>Nhà xuất bản: </span>
                    <select class="search-admin" name="title">
                        <c:forEach items="${requestScope.listNXB}" var="listNXB">
                            <option value="${listNXB.title}">${listNXB.title}</option>
                        </c:forEach>                              
                    </select><br/>
                    <span>Giá: </span><input required placeholder="Nhập giá. Yêu cầu nhập số!" class="input" type="text" name="price"/><br/>
                    <span>Chiết khấu: </span><input required placeholder="Nhập chiết khấu. Yêu cầu nhập số!" class="input" type="text" name="discount"/><br/>
                    <span>Ngày ra mắt: </span><input required type="date" name="releaseDate"/><br/>
                    <span>Miêu tả: </span>
                    <textarea placeholder="Nhập miêu tả" required rows="20" cols="20" id="editor" name="describe""></textarea><br/>

                    <input class="submit" type="submit" value="Lưu"/>
                </div>
                <div class="detail-img">
                    <img src="" id="image" alt="">
                    <input class="submit" type="file" name="image" onchange="chooseFile(this)"
                           accept="image/gif, image/jpeg, image/jpg"/>
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
