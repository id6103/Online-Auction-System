<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Insert title here</title>
</head>
<body background="./images/background.jpg">
<%=session.getAttribute("LOGIN_USER") %>，你已经登录。<br>
点击<a href="logout.do">此处退出</a>
</body>
</html>