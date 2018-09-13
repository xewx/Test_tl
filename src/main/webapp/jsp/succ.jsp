<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-08-08
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
    <div>
        <input type="text" id="id" name="id">
        <input type="button" id="sub" value="search">
        <a href="add.jsp">add</a>
    </div>
    <div>
        <table>
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>password</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="inff">
            </tbody>
        </table>
    </div>
    <div id = "upd" style="float:left;width: 100%;background-color: #f0f4f7;padding: 0 3.8rem;"></div>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/asd.js"></script>
</body>
</html>
