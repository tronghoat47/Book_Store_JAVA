<%-- 
    Document   : product
    Created on : Oct 15, 2022, 10:42:28 PM
    Author     : TrongHoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US"/>
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
        <link rel="stylesheet" href="fontawesome-free-6.2.0-web/fontawesome-free-6.2.0-web/css/all.css">
        <script type="text/javascript" src="<%=request.getContextPath()%>/libraries/ckeditor/ckeditor.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <c:set var="book" value="${requestScope.book}"/>
        <div class="product-mar">
            <div class="product-detail">
                <div class="product-detail-info">
                    <div class="product-image">
                        <img src="${book.image}">
                        <p>${book.discount}%</p>
                    </div>
                    <div class="product-head-info">
                        <h1 class="product-name">${book.name}</h1>
                        <p>Nhà cung cấp <a style="color: var(--primary-color); font-weight: 600" href="home">BookHouse</a></p>
                        <div class="product-price">
                            <div class="price-new">
                                <p><fmt:formatNumber value = "${book.price - book.price*book.discount/100}" type = "currency"/></p>
                            </div>
                            <div class="price-old">
                                <p><fmt:formatNumber value = "${book.price}" type = "currency"/></p>
                            </div>
                            <p>Bạn tiết kiệm được <span style="font-weight: 600"><fmt:formatNumber value = "${book.price*book.discount/100}" type = "currency"/></span></p>
                        </div>
                        <div class="khuyenmai">
                            <ul>
                                Khuyến mãi và Ưu đãi tại <span>BookHouse</span>
                                <li><span>Freeship</span> toàn bộ các tỉnh miền Bắc cho đơn hàng từ $300</li>
                                <li><span>Freeship</span> các tỉnh miền Nam cho đơn hàng từ $500</li>
                            </ul>
                        </div>
                        <p>Số lượng</p>
                        <form action="" name="f" method="post" class="product-detail-cart">
                            <input class="number" style="text-align: center" type="number" name="num" value="1">
                            <input class="cart_submit" onclick="buy('${book.bookID}')" type="button" value="Thêm vào giỏ hàng"/>
                        </form>
                        <div class="product-contact">
                            <p>Gọi đặt mua <span>7628390434</span>(Thứ 2 - Thứ 7 | 07:00 - 20:00)</p>
                        </div>
                    </div>
                </div>

            </div>
            <div class="product-detail-content">
                <div class="describe_review">
                    <div class="describe">
                        <p class="headhead">Mô tả</p>
                        <div class="describe-content">
                            <div class="describe-left">
                                <p>Nhà xuất bản</p>
                                <p>Tác giả</p>
                                <p>Ngày ra mắt</p>
                            </div>
                            <div class="describe-right">
                                <p>${book.title}</p>
                                <p>${book.author}</p>
                                <p>${book.releaseDate}1</p>
                            </div>
                        </div>
                        <h1>${book.name}</h1>
                        <p class="describe-title">${book.describe}</p>
                    </div>
                    <p class="headhead">Bình luận & Đánh giá</p>
                    <c:if test="${requestScope.bought != null}">
                        <h1>Đánh giá sản phẩm</h1>
                        <form class="review-form" action="review" method="post">
                            <div class="rating">
                                <input type="hidden" value="${book.bookID}" name="bookId"/>
                                <input value="5" type="radio" name="star" id="star1"><label for="star1"></label>
                                <input value="4" type="radio" name="star" id="star2"><label for="star2"></label>
                                <input value="3" type="radio" name="star" id="star3"><label for="star3"></label>
                                <input value="2" type="radio" name="star" id="star4"><label for="star4"></label>
                                <input value="1" type="radio" name="star" id="star5"><label for="star5"></label>
                            </div>
                            <textarea name="comment" id="" cols="100" rows="5"></textarea>
                            <input class="submit" type="submit" value="Đánh giá"/>
                        </form>
                    </c:if>
                    <div class="review">
                        <c:forEach items="${requestScope.listRv}" var="rv">
                            <div class="comment_rate">
                                <div class="date"><span>Ngày: </span>${rv.date}</div>
                                <div class="user">
                                    <span>Khách hàng: </span>
                                    <img src="${rv.image}" alt="">
                                    <p class="username">${rv.username}</p>
                                </div>
                                <div class="rate">
                                    <c:forEach begin="1" end="${rv.rating}">
                                        <span class="fa fa-star checked"></span>
                                    </c:forEach>
                                    <c:forEach begin="1" end="${5-rv.rating}">
                                        <span style="color: grey" class="fa fa-star "></span>
                                    </c:forEach>
                                </div>
                                <div class="comment"><span>Đánh giá: </span>${rv.comment}</div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
                <div class="product-similar">
                    <p style="text-align: center;" class="headhead">Sản phẩm tương tự</p>
                    <c:forEach items="${requestScope.list}" var="list">
                        <a href="product?bookId=${list.bookID}">
                            <div class="product-similar-item">
                                <img src="${list.image}" alt="">
                                <div class="product-similar-item-content">
                                    <span>${list.name}</span>
                                    <div class="product-price-item">
                                        <div class="price-new">
                                            <p><fmt:formatNumber value = "${list.price - list.price*list.discount/100}" type = "currency"/></p>
                                        </div>
                                        <div class="price-old">
                                            <p><fmt:formatNumber value = "${list.price}" type = "currency"/></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>



        <%@include file="click.jsp" %>
        <%@include file="footer.jsp" %>
    </body>
    <script type="text/javascript">
        function buy(id) {
            var m = document.f.num.value;
            document.f.action = "product?bookId=" + id + "&num=" + m;
            document.f.submit();
        }
    </script>
</html>

