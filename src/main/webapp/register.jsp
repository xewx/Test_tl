<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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
<div class="register">
  <h1>欢迎注册</h1>
  <form method="post" id="form1">
  <table cellpadding="5px">
  	<tr><td style="width: 100px;">请输入账号</td>
  		<td colspan="3"><input type="text" name="name" placeholder="请输入账号" class="rinput"></td></tr>
  	<tr><td style="width: 100px;">请选择性别</td>
  		<td colspan="3"><input type="radio" name="sex" value="0" checked>男
  						<input type="radio" name="sex" value="1">女</td></tr>
  	<tr><td>请输入密码</td>
  		<td colspan="3"><input type="password" name="password" placeholder="请输入密码" class="rinput"></td></tr>
  	<tr><td>请确认密码</td>
  		<td><input type="password" name="password2" placeholder="请再次输入密码" class="rinput"></td></tr> 
  	<tr><td style="width: 100px;">请输入手机</td>
  		<td colspan="3"><input type="text" name="phone" placeholder="请输入手机号" class="rinput"></td></tr>
  	<tr><td style="width: 100px;">请输入邮箱</td>
  		<td colspan="3"><input type="text" name="email" placeholder="请输入邮箱" class="rinput"></td></tr>		
   	<tr><td colspan="4" align="center"><input type="submit" value="注册" class="submit" id="register">
			<input type="button" value="返回登录" class="submit" id="backLogin"/></td></tr>
  </table>
  </form>
</div>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
    $(function() {
        $("#backLogin").click(function () {

        })

        $("#register").click(function () {
            var userVO=$("#form1").serialize();
            var url="${path}/xew/register";
            $.ajax({
				url:url,
				data:userVO,
				type:'post',
                async:false,
                dataType: 'json',
				success:function (data) {
				    if(data.result) {
                        alert("注册成功")
                    }else{
				        alert("注册失败")
					}
                }
			})
        })
    })
</script>
</body>
</html>
