<%-- 
    Document   : total
    Created on : Nov 7, 2022, 4:45:26 PM
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
        <link rel="stylesheet" href="CSS/chart.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <script src="https://code.highcharts.com/highcharts.js"></script>
        <script src="https://code.highcharts.com/modules/exporting.js"></script>
        <script src="https://code.highcharts.com/modules/export-data.js"></script>
        <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="admin">
            <%@include file="nav-admin.jsp" %>
            <form method="post" action="total">
                <%@include file="chart.jsp" %>
                <div class="table">
                    <h2>Top 3 khách hàng chi tiêu nhiều nhất</h2>
<!--                    <input type="date" name="date1" value="${date1}"/>
                    <input type="submit" value="Search"/>-->
                    <table style="margin-top: 10px; border-collapse: collapse" border="1">
                        <thead style="font-size: 1.6rem">
                            <tr>
                                <th class="nxb">Khách Hàng</th>
                                <th class="nxb">Tổng chi tiêu</th>
                            </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.listCus}" var="list">
                                <tr >
                                    <td style="text-align: center;">${list.usernameCu}</td>
                                    <td style="text-align: center;">$ ${list.totalMoney}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <h2>Top 3 khách hàng mua hàng nhiều nhất</h2>
<!--                    <input type="date" name="date2" value="${date2}"/>
                    <input type="submit" value="Search"/>-->
                    <table style="margin-top: 10px; border-collapse: collapse" border="1">
                        <thead style="font-size: 1.6rem">
                            <tr>
                                <th class="nxb">Khách Hàng</th>
                                <th class="nxb">Số lần mua</th>
                            </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.listCus2}" var="list">
                                <tr >
                                    <td style="text-align: center;">${list.usernameCu}</td>
                                    <td style="text-align: center;">${list.quantity}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <h2>Top 5 cuốn sách bán nhiều nhất</h2>
<!--                    <input type="date" name="date3" value="${date3}"/>
                    <input type="submit" value="Search"/>-->
                    <table style="margin-top: 10px; border-collapse: collapse" border="1">
                        <thead style="font-size: 1.6rem">
                            <tr>
                                <th class="nxb">Ảnh</th>
                                <th class="nxb">Tên</th>
                                <th class="nxb">Số lượng</th>
                            </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.listBook}" var="list">
                                <tr >
                                    <td style="text-align: center;"><img src="${list.image}" alt="alt"/></td>
                                    <td style="text-align: center; width: 300px;">${list.name}</td>
                                    <td style="text-align: center;">${list.quantity}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <h2>Doanh thu từng nhóm sản phẩm</h2>
<!--                    <input type="date" name="date4" value="${date4}"/>
                    <input type="submit" value="Search"/>-->
                    <table style="margin-top: 10px; border-collapse: collapse" border="1">
                        <thead style="font-size: 1.6rem">
                            <tr>
                                <th class="nxb">Ảnh</th>
                                <th class="nxb">Nhóm sản phẩm</th>
                                <th class="nxb">Doanh thu</th>
                            </tr>
                        </thead>
                        <tbody >
                            <c:forEach items="${requestScope.listCate}" var="list">
                                <tr >
                                    <td style="text-align: center;"><img src="${list.image}" alt="alt"/></td>
                                    <td style="text-align: center; width: 300px;">${list.name}</td>
                                    <td style="text-align: center;">${list.totalMoney}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                </div>
            </form>


        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
