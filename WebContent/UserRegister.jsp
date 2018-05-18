<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body background="./images/background.jpg">
 <h3 align="center">用户注册User Registration</h3>
<form action="UserRegister" method="post">
   
              姓名Name:<input name="username"><br><br>
	密码Password:<input type="password" name="pwd"><br><br>
	地址Address:<input  name="address"><br><br>
	身份证号ID:<input name="identification_no"><br><br>
              年龄Age:<input  name="age"><br><br>
             兴趣Interests：<input name="hobby" ><br><br>
      
	<input type="submit" value="register">
	</form>

</body>
</html>