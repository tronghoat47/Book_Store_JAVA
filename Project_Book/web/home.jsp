<%-- 
    Document   : home
    Created on : Oct 7, 2022, 10:05:21 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="CSS/base.css">
        <link rel="stylesheet" href="CSS/main.css">
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="app">
            <%@include file="navbar.jsp" %>
            <%@include file="slide.jsp" %>

            <div class="container">
                <div class="container-category">
                    <div class="container-cate-first">
                        <i class="fa-solid fa-grip-vertical"></i>
                        <h1>Danh mục sản phẩm</h1>
                    </div>
                    <div class="container-cate">
                        <div class="container-cate-detail ${requestScope.cateId==0?"active":""}">
                            <a href="home?cate=${0}">
                                <img src="images/images_background/back4.jpg" alt="">
                                <br />
                                <p>Tất cả sản phẩm</p>
                            </a>
                        </div>
                        <c:forEach items="${requestScope.listCate}" var="listCate">
                            <div class="container-cate-detail ${requestScope.cateId==listCate.categoryID?"active":""} ">
                                <a class="" href="home?cate=${listCate.categoryID}">
                                    <img src="${listCate.image}" alt="">
                                    <br />
                                    <p>${listCate.name}</p>
                                </a>
                            </div>
                        </c:forEach>  
                    </div>
                </div>

                <!-----------------------------DONE-------------------------------------------->

                <div class="container-category-new">
                    <div class="product-title">
                        <div class="product-title_ao">
                            <c:set var="cateId" value="${requestScope.cateId}"/>
                            <c:if test="${cateId==0}">
                                <h1>Tất cả sản phẩm</h1>
                            </c:if>
                            <c:if test="${cateId!=0 && cateId < 7}">
                                <h1>${listCate.get(cateId-1).name}</h1>
                            </c:if>
                            <c:if test="${cateId>=7}">
                                <h1>${listCate.get(cateId-2).name}</h1>
                            </c:if>
                            <p class="product-title_ao-tg"></p>
                        </div>
                        <c:set var="page" value="${requestScope.page}"/>
                        <div class="pagination">
                            <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                                <a class="${i==page?"active":""}" href="home?cate=${cateId}&page=${i}">${i}</a>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="product">
                        <c:forEach items="${requestScope.listAll}" var="listAll" >
                            <div class="content-product">
                                <a href="product?bookId=${listAll.bookID}" class="content-product-link">
                                    <div class="product-image">
                                        <img src="${listAll.image}" alt="">
                                        <p class="product-sale">Giảm<br>${listAll.discount}%</p>

                                    </div>
                                    <div class="content-product-text">

                                        <p class="product-name hidden-product ">${listAll.name}</p>
                                        <div class="product-pricce">
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
                                <a href="product?bookId=${listAll.bookID}" style="color: var(--primary-color)">
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
                                                <a style="color: blue" href="product?bookId=${listAll.bookID}">Xem thêm</a>
                                            </div>
                                        </div>
                                    </div>
                                </a>

                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="container-category-new">
                    <div class="product-title">
                        <div class="product-title_ao">

                            <h1>Sản phẩm mới ra mắt</h1>
                            <p class="product-title_ao-tg"></p>
                        </div>
                    </div>
                    <div class="product">
                        <c:forEach items="${requestScope.listNew}" var="listNew" begin="0" end="4">
                            <div class="content-product">
                                <a href="product?bookId=${listNew.bookID}" class="content-product-link">
                                    <div class="product-image">
                                        <img src="${listNew.image}" alt="">
                                        <p class="product-sale">Giảm<br>${listNew.discount}%</p>

                                    </div>
                                    <div class="content-product-text">

                                        <p class="product-name hidden-product ">${listNew.name}</p>
                                        <div class="product-pricce">

                                            <p class="product-oldPrice"><fmt:formatNumber value = "${listNew.price}" type = "currency"/></p>
                                            <p class="product-newPrice"><fmt:formatNumber value = "${listNew.price - listNew.price*listNew.discount/100}" type = "currency"/></p>
                                        </div>
                                        <div class="product-sold">
                                            <p>Đã bán(${listNew.sold})</p>
                                        </div>
                                        <p class="product-rate">
                                            <c:forEach begin="1" end="${listNew.rate}">

                                                <span class="fa fa-star checked"></span>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${ 5-listNew.rate}">

                                                <span style="color: grey" class="fa fa-star "></span>
                                            </c:forEach>
                                        </p>
                                    </div>
                                </a>
                                <a href="product?bookId=${listNew.bookID}" style="color: var(--primary-color)">
                                    <div class="product-detail-mini">
                                        <div class="product-detail-mini-content">
                                            <div class="product-detail-mini-content-img">

                                                <img src="${listNew.image}" alt="">
                                            </div>
                                            <div class="product-text">
                                                <h1 class="product-name" style="font-size: 1.8rem; line-height: 20px; padding-bottom: 5px;">${listNew.name}
                                                </h1>
                                                <p style="padding-top: 5px;" class="product-author"><label>Tác giả:</label> ${listNew.author}</p>

                                                <p style="padding-top: 5px;" class="product-nxb"><label>Nhà xuất bản:</label> ${listNew.title}</p>
                                                <p style="padding-top: 5px;" class="product-date"><label>Ngày ra mắt:</label> ${listNew.releaseDate}</p>
                                                <p style="padding-top: 5px;" class="product-describe hidden-describe"><label>Mô tả:</label> ${listNew.describe}</p>
                                                <a style="color: blue" href="product?bookId=${listNew.bookID}">Xem thêm</a>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                </div>
                <div class="container-category-new">
                    <div class="product-title">
                        <div class="product-title_ao">

                            <h1>Sản phẩm được yêu thích</h1>
                            <p class="product-title_ao-tg"></p>
                        </div>
                    </div>
                    <div class="product">
                        <c:forEach items="${requestScope.listLove}" var="listLove" begin="0" end="4">
                            <div class="content-product">
                                <a href="product?bookId=${listLove.bookID}" class="content-product-link">
                                    <div class="product-image">
                                        <img src="${listLove.image}" alt="">
                                        <p class="product-sale">Giảm<br>${listLove.discount}%</p>

                                    </div>
                                    <div class="content-product-text">

                                        <p class="product-name hidden-product ">${listLove.name}</p>
                                        <div class="product-pricce">
                                            <fmt:setLocale value = "en_US"/>

                                            <p class="product-oldPrice"><fmt:formatNumber value = "${listLove.price}" type = "currency"/></p>
                                            <p class="product-newPrice"><fmt:formatNumber value = "${listLove.price - listLove.price*listLove.discount/100}" type = "currency"/></p>
                                        </div>
                                        <div class="product-sold">
                                            <p>Đã bán(${listLove.sold})</p>
                                        </div>
                                        <p class="product-rate">
                                            <c:forEach begin="1" end="${listLove.rate}">

                                                <span class="fa fa-star checked"></span>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${ 5-listLove.rate}">

                                                <span style="color: grey" class="fa fa-star "></span>
                                            </c:forEach>
                                        </p>
                                    </div>
                                </a>
                                <a href="product?bookId=${listLove.bookID}" style="color: var(--primary-color)">
                                    <div class="product-detail-mini">
                                        <div class="product-detail-mini-content">
                                            <div class="product-detail-mini-content-img">

                                                <img src="${listLove.image}" alt="">
                                            </div>
                                            <div class="product-text">
                                                <h1 class="product-name" style="font-size: 1.8rem; line-height: 20px; padding-bottom: 5px;">${listLove.name}
                                                </h1>
                                                <p style="padding-top: 5px;" class="product-author"><label>Tác giả:</label> ${listLove.author}</p>

                                                <p style="padding-top: 5px;" class="product-nxb"><label>Nhà xuất bản:</label> ${listLove.title}</p>
                                                <p style="padding-top: 5px;" class="product-date"><label>Ngày ra mắt:</label> ${listLove.releaseDate}</p>
                                                <p style="padding-top: 5px;" class="product-describe hidden-describe"><label>Mô tả:</label> ${listLove.describe}</p>
                                                <a style="color: blue" href="product?bookId=${listLove.bookID}">Xem thêm</a>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>

                    </div>
                </div>

                <div class="container-category-new">
                    <div class="product-title">
                        <div class="product-title_ao">

                            <h1>Sản phẩm bán chạy</h1>
                            <p class="product-title_ao-tg"></p>
                        </div>
                    </div>

                    <div class="product">
                        <c:forEach items="${requestScope.listSold}" var="listSold" begin="0" end="4">
                            <div class="content-product">
                                <a href="product?bookId=${listSold.bookID}" class="content-product-link">
                                    <div class="product-image">
                                        <img src="${listSold.image}" alt="">
                                        <p class="product-sale">Giảm<br>${listSold.discount}%</p>

                                    </div>
                                    <div class="content-product-text">

                                        <p class="product-name hidden-product ">${listSold.name}</p>
                                        <div class="product-pricce">
                                            <fmt:setLocale value = "en_US"/>

                                            <p class="product-oldPrice"><fmt:formatNumber value = "${listSold.price}" type = "currency"/></p>
                                            <p class="product-newPrice"><fmt:formatNumber value = "${listSold.price - listSold.price*listSold.discount/100}" type = "currency"/></p>
                                        </div>
                                        <div class="product-sold">
                                            <p>Đã bán(${listSold.sold})</p>
                                        </div>
                                        <p class="product-rate">
                                            <c:forEach begin="1" end="${listSold.rate}">

                                                <span class="fa fa-star checked"></span>
                                            </c:forEach>
                                            <c:forEach begin="1" end="${ 5-listSold.rate}">

                                                <span style="color: grey" class="fa fa-star "></span>
                                            </c:forEach>
                                        </p>
                                    </div>
                                </a>
                                <a href="product?bookId=${listSold.bookID}" style="color: var(--primary-color)">
                                    <div class="product-detail-mini">
                                        <div class="product-detail-mini-content">
                                            <div class="product-detail-mini-content-img">

                                                <img src="${listSold.image}" alt="">
                                            </div>
                                            <div class="product-text">
                                                <h1 class="product-name" style="font-size: 1.8rem; line-height: 20px; padding-bottom: 5px;">${listSold.name}
                                                </h1>
                                                <p style="padding-top: 5px;" class="product-author"><label>Tác giả:</label> ${listSold.author}</p>

                                                <p style="padding-top: 5px;" class="product-nxb"><label>Nhà xuất bản:</label> ${listSold.title}</p>
                                                <p style="padding-top: 5px;" class="product-date"><label>Ngày ra mắt:</label> ${listSold.releaseDate}</p>
                                                <p style="padding-top: 5px;" class="product-describe hidden-describe"><label>Mô tả:</label> ${listSold.describe}</p>
                                                <a style="color: blue" href="product?bookId=${listSold.bookID}">Xem thêm</a>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>



            </div>

            <div class="end">
                <p class=""></p>
            </div>
            <%@include file="click.jsp" %>

            <%@include file="footer.jsp" %>
        </div>





    </body>
</html>
