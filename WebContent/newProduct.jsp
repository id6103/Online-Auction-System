<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<%@ page import="auction.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��������ϵͳ</title>

</head>
<body background="./images/background.jpg">


<h1 align="center">��������ϵͳ(��Ʒ����)</h1>
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">�˳���¼</a>&nbsp;&nbsp;<a href="login.do?flag=1">������ҳ</a><br>
<br><br>

	<form action="addAuction.do" method="post">
	
	��Ʒ����:<input name="productName"><br><br>
	��Ʒ����:<input name="productDesc"><br><br>
	���ļ�:&nbsp;&nbsp<input name="startPrice"><br><br>
	ͼƬ��<input type="file" id="imgUpload" name="imgUpload"/>
	<br><br>
	<input type="submit" value="�ύ�µ�����">
	<input type="reset">
	
	</form>





</body>
</html>