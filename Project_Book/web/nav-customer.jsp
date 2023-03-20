<%-- 
    Document   : nav-customer
    Created on : Oct 24, 2022, 6:42:05 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="admin-option">
    <ul>
        <div class="admin-head">
            <i class="fa-solid fa-bars"></i>
            <p>Customer</p>
        </div>
        <a href="history_buy"><li class="${requestScope.history!=null?"active":""}">Lịch sử mua hàng</li></a>
        <a href="profile_customer"><li class="${requestScope.profile!=null?"active":""}">Thông tin cá nhân</li></a>
    </ul>
</div>
