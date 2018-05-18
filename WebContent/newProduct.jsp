<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<%@ page import="auction.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>网上拍卖系统</title>

</head>
<body background="./images/background.jpg">


<h1 align="center">网上拍卖系统(商品详情)</h1>
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">退出登录</a>&nbsp;&nbsp;<a href="login.do?flag=1">返回首页</a><br>
<br><br>

	<form action="addAuction.do" method="post">
	
	产品名称:<input name="productName"><br><br>
	产品描述:<input name="productDesc"><br><br>
	起拍价:&nbsp;&nbsp<input name="startPrice"><br><br>
	图片：<input type="file" id="imgUpload" name="imgUpload"/>
	<br><br>
	<input type="submit" value="提交新的拍卖">
	<input type="reset">
	
	</form>





</body>
</html>