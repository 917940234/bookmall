<%--
  Created by IntelliJ IDEA.
  User: zongyoucheng
  Date: 2021/12/6
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="/bookmall/static/css/style.css" >
<script type="text/javascript" src="/bookmall/static/script/jquery-1.7.2.js"></script>
