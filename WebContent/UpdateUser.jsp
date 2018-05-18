<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
          function pw() {
              var pw1 = document.getElementById("pw1").value;
              var pw2 = document.getElementById("pw2").value;
              if(pw1 == pw2) {
                  document.getElementById("submit").disabled = false;
              }
              else {
            	alert("两次输入密码不同,请重新输入Please enter identical passwords");
                document.getElementById("pw1").value="";
            	document.getElementById("pw2").value="";
            	
                document.getElementById("submit").disabled = true;
              }
          }
      </script>
</head>
<body background="./images/background.jpg">
 <form action="UserUpdate.do"  method="post" >
<%=session.getAttribute("LOGIN_USER") %>，welcome<br>
    <h3 align="center"> 用户修改信息Edit User Info</h3>
              密码Password:<input type="password" name="pwd" id="pw1"><br><br>
              确认密码Comfirm Password:<input type="password" name="pwd2" id="pw2"><br><br>
	地址Address:<input  name="address" onclick=pw()><br><br>
	身份证号ID:<input name="identification_no"><br><br>
              年龄AGE:<input  name="age"><br><br>
             兴趣Interests：<input name="hobby" ><br><br>
      
	<input type="submit" value="update">
	</form>

</body>
</html>
