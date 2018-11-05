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
  		<td colspan="3"><input type="text" name="name" id="name" placeholder="请输入账号" class="rinput"></td></tr>
  	<tr><td style="width: 100px;">请选择性别</td>
  		<td colspan="3"><input type="radio" name="sex" value="0" checked>男
  						<input type="radio" name="sex" value="1">女</td></tr>
  	<tr><td>请输入密码</td>
  		<td colspan="3"><input type="password" name="password" id="password" placeholder="请输入密码" class="rinput"></td></tr>
  	<tr><td>请确认密码</td>
  		<td><input type="password" name="password2" id="password2" placeholder="请再次输入密码" class="rinput"></td></tr>
  	<tr><td style="width: 100px;">请输入手机</td>
  		<td colspan="3"><input type="text" name="phone" id="phone" placeholder="请输入手机号" class="rinput"></td></tr>
  	<tr><td style="width: 100px;">请输入邮箱</td>
  		<td colspan="3"><input type="text" name="email" id="email" placeholder="请输入邮箱" class="rinput"></td></tr>
   	<tr><td colspan="4" align="center"><input type="button" value="注册" class="submit" id="register">
			<input type="button" value="返回登录" class="submit" id="backLogin"/></td></tr>
  </table>
  </form>
	<div style="size: 10px;align-content: center;color: red"><span id="info"></span></div>
</div>
<script type="text/javascript" src="./js/jquery.min.js"></script>
<script type="text/javascript">
	$("#backLogin").click(function () {
		window.location.href = "${path}/login.jsp";
	})

	$("#register").click(function () {
	    var msg="";
	    msg+=checkName()
		msg+=checkPassword()
		msg+=checkPassword2()
		msg+=checkPhone()
		msg+=checkEamil()
		if(msg.length>1){
            $("#info").html(msg)
			return;
            $.alert()
		}
		var userVO=$("#form1").serialize();
		var url="${path}/user/register";
		$.ajax({
			url:url,
			data:userVO,
			type:'post',
			dataType: 'json',
			success:function (data) {
				if(data.result) {
					alert("注册成功")
					window.location.href = "${path}/login.jsp";
				}else{
					alert(data.msg)
				}
			}
		})
	})

	function checkName() {
		var name=$("#name").val();
		if(name==null||name.length<1){
		    return "Name cann't be empty!<br>"
		}
		return "";
    }
    function checkPassword() {
        var password=$("#password").val();
        if(password==null||password.length<1){
            return "Password cann't be empty!<br>"
        }
        return "";
    }
    function checkPassword2() {
        var password=$("#password").val();
        var password2=$("#password2").val();
        if(password!=password2){
            return "Different passwords<br>"
        }
        return "";
    }
    function checkPhone() {
        var phone=$("#phone").val();
        if(phone==null||phone.length<1){
            return "Phone cann't be empty!<br>"
        }
        return "";
    }
    function checkEamil() {
        var email=$("#email").val();
        if(email==null||email.length<1){
            return "Email cann't be empty!<br>"
        }
        return "";
    }

</script>
</body>
</html>
