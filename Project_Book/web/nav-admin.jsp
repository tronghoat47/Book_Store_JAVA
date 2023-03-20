<%-- 
    Document   : nav-admin
    Created on : Oct 23, 2022, 8:16:05 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="admin-option">
    <ul>
        <div class="admin-head">
            <i class="fa-solid fa-bars"></i>
            <p>Admin</p>
        </div>
        <a href="crud" ><li class="${requestScope.crud!=null?"active":""}">Quản lí sản phẩm</li></a>
        <a href="category"><li class="${requestScope.category!=null?"active":""}">Thể loại sách</li></a>
        <a href="nxb"><li class="${requestScope.nxb!=null?"active":""}">Nhà xuất bản</li></a>
        <a href="manager"><li class="${requestScope.manager!=null?"active":""}">Quản lí đơn hàng</li></a>
        <a href="total"><li class="${requestScope.total!=null?"active":""}">Tình hình kinh doanh</li></a>
        <a href="profile_admin"><li class="${requestScope.profile!=null?"active":""}">Thông tin cá nhân</li></a>
    </ul>
</div>
