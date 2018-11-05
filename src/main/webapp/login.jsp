<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
    request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/login.css">
 </head>
 <body>
<div class="headtop"></div>
<div class="login">
  <h1>欢迎登录</h1>
  <form method="post" id="form1">
  <table cellpadding="5px">
  	<tr><td style="width:50px">账&nbsp;&nbsp;&nbsp;号</td>
  		<td colspan="3"><input type="text" name="name" id="name" placeholder="请输入账号" class="input" value="${name }"></td></tr>
  	<tr><td>密&nbsp;&nbsp;&nbsp;码</td>
  		<td colspan="3"><input type="password" name="password" id="password" placeholder="请输入密码" class="input" value="${password }"></td></tr>
  	<%--<tr><td>验证码</td><td><input type="text" name="checkcode" placeholder="请输入验证码" class="input"></td>--%>
  		<%--<td><img border="0" src="images" id="cim"></td>--%>
    	<%--<td><input type="button" value="换一张" onclick=change() class="change"></td></tr>--%>
    <tr><td colspan="4" align="center"><input type="button" value="登录" class="submit" id="login">
   		<input type="button" value="注册" id="backRedister" class="submit"></td></tr>
  </table>
      <div style="size: 10px;align-content: center;color: red"><span id="info"></span></div>
  </form>
</div>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#backRedister").click(function () {
            window.location.href = "${path}/register.jsp";
        })
    })
	$("#login").click(function () {
		var name=$("#name").val();
		var password=$("#password").val();
		$.post("${path}/user/login",
            {name:name,password:password},
            function (data) {
                if(data=="Success"){
                    window.location.href = "${path}/index.jsp";
                }else{
                    $("#info").html(data)
                }
            }
        )
        return false;	// 阻止form表单自动提交事件！
    })
</script>
</body>
</html>
