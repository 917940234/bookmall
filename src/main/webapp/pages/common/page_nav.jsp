<%--
  Created by IntelliJ IDEA.
  User: zongyoucheng
  Date: 2021/12/17
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--大于首页，才显示--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${ requestScope.page.url }&pageNo=1">首页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--情况1：如果总页码小于等于5的情况，页码的范围是：1-总页码--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i == requestScope.page.pageNo}">
                    [${i}]
                </c:if>
                <c:if test="${i != requestScope.page.pageNo}">
                    <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <%--情况2：如果总页码大于5的情况，假设一共十页--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--小情况1：当前页码为前三个：1、2、3的情况，页码范围是：1-5--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--小情况2：当前页码为后三个：8、9、10的情况，页码范围是：总页码减4-总页码--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 2}">
                    <c:forEach begin="${requestScope.page.pageTotal - 4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--小情况3：当前页码为中间部分：页码范围是：当前页码减2-当前页码加2--%>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo - 2}" end="${requestScope.page.pageNo + 2}" var="i">
                        <c:if test="${i == requestScope.page.pageNo}">
                            [${i}]
                        </c:if>
                        <c:if test="${i != requestScope.page.pageNo}">
                            <a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <%--页码输出的结束--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function() {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();
                //javaScript语言中提供了一个location地址栏对象
                //它有一个属性叫href，它可以获取浏览器中的地址
                //href属性可读、可写
                location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo;
            });
        });
    </script>
</div>
