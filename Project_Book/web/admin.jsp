<%-- 
    Document   : admin
    Created on : Oct 22, 2022, 8:51:26 PM
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
        <script type="text/javascript">
            function deleteBook(bookID) {
                if (confirm("Bạn có muốn xóa sản phẩm này?")) {
                    window.location = "delete?id=" + bookID;
                }
            }
        </script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <%@include file="nav-admin.jsp" %>
            <c:if test="${requestScope.crud!=null}">
                <div class="table">
                    <form method="post" action="crud">
                        <input type="text" name="content" placeholder="Tìm kiếm theo tên hoặc tác tác giả"/>
                        <select name="nxb" style="background-color: white">
                            <c:forEach items="${requestScope.listNXB}" var="nxb">
                                <option value="${nxb.title}">${nxb.title}</option>
                            </c:forEach>
                        </select>
                        <select name="cate" style="background-color: white">
                            <c:forEach items="${requestScope.listCate}" var="cate">
                                <option value="${cate.categoryID}">${cate.name}</option>
                            </c:forEach>
                        </select><br/>
                        Ngày: Từ <input type="text" name="fromdate" placeholder="yyyy-MM-dd" value="${requestScope.from}" /> 
                        Đến <input type="text" name="todate" placeholder="yyyy-MM-dd" value="${requestScope.to}"/>
                        <br/>
                        <input type="submit" value="Search"/>
                    </form><br/>
                    <a style="color: var(--primary-color); font-size: 2rem; padding: 15px 0px;" href="add">Thêm sản phẩm mới</a>
                    <c:if test="${requestScope.addSuccsess!=null}">
                        <p class="success">${addSuccsess}</p>
                    </c:if>
                    <c:if test="${requestScope.deleteSuccess!=null}">
                        <p class="success">${deleteSuccess}</p>
                    </c:if>
                    <table style="margin-top: 10px; border-collapse: collapse" border="1">
                        <thead style="font-size: 1.6rem">
                            <tr>
                                <th class="id">ID</th>
                                <th class="name">Tên</th>
                                <th class="author">Tác giả</th>
                                <th class="describe">Miêu tả</th>
                                <th class="nxb">Nhà xuất bản</th>
                                <th class="nxb"></th>
                            </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.listBook}" var="listBook">
                                <tr >
                                    <td style="text-align: center;">${listBook.bookID}</td>
                                    <td  style="text-align: center;">${listBook.name}</td>
                                    <td style="text-align: center;">${listBook.author}</td>
                                    <td style="text-align: justify; padding: 10px 10px 0px 10px; " class="hidden-header2">${listBook.describe}</td>
                                    <td style="text-align: center;">${listBook.title}</td>
                                    <td class="set-item">
                                        <a style="color: green;" href="detail?bookId=${listBook.bookID}">Chi tiết</a>                           
                                        <a style="color: blue;"  href="update?bookId=${listBook.bookID}">Cập nhật</a>
                                        <a style="color: red;" href="#" onclick="deleteBook('${listBook.bookID}')"">Xóa</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>

        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
