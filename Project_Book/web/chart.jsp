<%-- 
    Document   : chart
    Created on : Oct 25, 2022, 10:51:23 PM
    Author     : TrongHoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<figure class="highcharts-figure">
    <div id="container"></div>
    <p class="highcharts-description">
        Doanh thu toàn bộ sản phẩm của người bán ${sessionScope.account.username} trong năm 2022
    </p>
</figure>
<script>
    Highcharts.chart('container', {
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Doanh thu toàn bộ sản phẩm'
        },
        xAxis: {
            categories: [<c:forEach items="${requestScope.listChart}" var="list">'Tháng ${list.month}', </c:forEach>],
            accessibility: {
                description: 'Months of the year'
            }
        },
        yAxis: {
            title: {
                text: 'Doanh thu'
            },
            labels: {
                formatter: function () {
                    return '$' + this.value;
                }
            }
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
                name: 'Doanh thu',
                marker: {
                    symbol: 'square'
                },
                data: [<c:forEach items="${requestScope.listChart}" var="list">${list.month}, </c:forEach>]

            }]
    });
</script>


