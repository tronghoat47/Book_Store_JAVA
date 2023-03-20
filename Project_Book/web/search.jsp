<%-- 
    Document   : search
    Created on : Oct 19, 2022, 9:41:27 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <link rel="stylesheet" href="CSS/search.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <%@include file="slide.jsp" %>

        <div class="web-search">
            <div class="search-classify">


                <form class="search-classify-form" action="search">
                    <div class="search-sort">
                        Sắp xếp theo
                        <select name="sort" id="" >
                            <option ${requestScope.sort=='new'?'selected':''} value="new">Mới nhất</option>
                            <option ${requestScope.sort=='price'?'selected':''} value="price">Giá thấp - cao</option>
                            <option ${requestScope.sort=='discount'?'selected':''} value="discount">Giảm giá nhiều</option>
                            <option ${requestScope.sort=='love'?'selected':''} value="love">Được yêu thích</option>
                            <option ${requestScope.sort=='sold'?'selected':''} value="sold">Bán chạy nhất</option>
                        </select>
                    </div>
                    <div class="search-price">
                        Giá: Từ<input type="number" name="fromprice" placeholder="$" value="${requestScope.price1}"/> 
                        Đến <input type="number" name="toprice" value="${requestScope.price2}"placeholder="$" />
                    </div>
                    <div class="search-date">
                        Ngày: Từ <input type="text" name="fromdate" placeholder="yyyy-MM-dd" value="${requestScope.from}" /> 
                        Đến <input type="text" name="todate" placeholder="yyyy-MM-dd" value="${requestScope.to}"/>
                    </div>
                    <input style="display: none" type="text" name="content" value="${requestScope.content}"/>
                    <input style="display: none" type="text" name="cate" value="${cateId}"/>
                    <input class="search-submit" type="submit" value="Search">
                </form>

                <p class="search-value">Kết quả tìm kiếm cho:
                <c:if test="${cateId==0}">
                    <span style="font-weight: bold">Tất cả sản phẩm</span> -
                </c:if> 
                <c:if test="${cateId!=0 && cateId < 7}">
                    <span style="font-weight: bold">${requestScope.listCate.get(cateId-1).name}</span> - 
                </c:if> 
                <c:if test="${cateId>=7}">
                    <span style="font-weight: bold">${requestScope.listCate.get(cateId-2).name}</span> - 
                </c:if>
                <span style="font-weight: bold">${requestScope.content}</span></p>
            </div>
            <c:if test="${(requestScope.listAll==null) || (requestScope.listAll.size()==0)}" >
                <p style="font-weight: bold; text-align: center; font-size: 2.5rem; padding: 10px">Không tìm thấy sản phẩm liên quan</p>
            </c:if>
        </div>
        <div class="container-category-new">
            <div class="product-title">
                <c:set var="page" value="${requestScope.page}"/>
                <div class="pagination">
                    <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                        <a class="${i==page?"active":""}" href="search?cate=${cateId}&page=${i}">${i}</a>
                    </c:forEach>
                </div>
            </div>

            <div class="product">
                <c:forEach items="${requestScope.listAll}" var="listAll" >
                    <div class="content-product">
                        <a href="" class="content-product-link">
                            <div class="product-image">
                                <img src="${listAll.image}" alt="">
                                <p class="product-sale">Giảm<br>${listAll.discount}%</p>

                            </div>
                            <div class="content-product-text">

                                <p class="product-name hidden-product ">${listAll.name}</p>
                                <div class="product-pricce">
                                    <fmt:setLocale value = "en_US"/>

                                    <p class="product-oldPrice"><fmt:formatNumber value = "${listAll.price}" type = "currency"/></p>
                                    <p class="product-newPrice"><fmt:formatNumber value = "${listAll.price - listAll.price*listAll.discount/100}" type = "currency"/></p>
                                </div>
                                <div class="product-sold">
                                    <p>Đã bán(${listAll.sold})</p>
                                </div>
                                <p class="product-rate">
                                <c:forEach begin="1" end="${listAll.rate}">

                                    <span class="fa fa-star checked"></span>
                                </c:forEach>
                                <c:forEach begin="1" end="${ 5-listAll.rate}">

                                    <span style="color: grey" class="fa fa-star "></span>
                                </c:forEach>
                                </p>
                            </div>
                        </a>
                        <div class="product-detail-mini">
                            <div class="product-detail-mini-content">
                                <div class="product-detail-mini-content-img">

                                    <img src="${listAll.image}" alt="">
                                </div>
                                <div class="product-text">
                                    <h1 class="product-name" style="font-size: 1.8rem; line-height: 20px; padding-bottom: 5px;">${listAll.name}
                                    </h1>
                                    <p style="padding-top: 5px;" class="product-author"><label>Tác giả:</label> ${listAll.author}</p>

                                    <p style="padding-top: 5px;" class="product-nxb"><label>Nhà xuất bản:</label> ${listAll.title}</p>
                                    <p style="padding-top: 5px;" class="product-date"><label>Ngày ra mắt:</label> ${listAll.releaseDate}</p>
                                    <p style="padding-top: 5px;" class="product-describe hidden-describe"><label>Mô tả:</label> ${listAll.describe}</p>
                                    <a href="#">Xem thêm</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
</html>
