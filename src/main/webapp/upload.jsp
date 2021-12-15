<%--
  Created by IntelliJ IDEA.
  User: zongyoucheng
  Date: 2021/12/6
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/bookmall/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"><br>
        头  像：<input type="file" name="photo"><br>
        <input type="submit" value="上传">
    </form>
</body>
</html>
