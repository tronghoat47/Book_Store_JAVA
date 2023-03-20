<%-- 
    Document   : click
    Created on : Oct 19, 2022, 11:49:52 AM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="backtop1" class="click-next">
    <a href="${sessionScope.account==null?'login':'crud'}"><i class="far fa-user"></i></a>
    <a href="mycart"><i class="fas fa-shopping-cart"></i></a>
    <a href="search?cate=0"><i class="fa-solid fa-magnifying-glass"></i></a>
    <a href="home"><i class="fas fa-home"></i></a>
</div>  
<div id="backtop">
    <i class="fa-solid fa-chevron-up"></i>
</div>
