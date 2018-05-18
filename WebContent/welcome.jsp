<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>��������ϵͳOnline Auction System</title>
<style>
#header{width:100%;height:150px;background-image:url(./images/head_bg.jpg);
		background-repeat:no-repeat ;}
</style>
</head>


<body background="">
<div id="container">
<div id="header" >
<br>
<h1 align="center"> ��������ϵͳOnline Auction System</h1>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp; 
<a href="UpdateUser.jsp"> �޸��û���ϢEdit User Info</a>
<a href="logout.do" >�˳���¼Log Out</a><br>
<br>
</div>

<br>
<a href="queryProductByName.do?action=1">�ҵ�����My Auction</a>&nbsp;
<a href="showRecord.do">�ҵľ��ۼ�¼My Bidding Records</a>&nbsp;
<a href="queryProductByName.do?action=3"> ���ĵ�����ƷWhat I have bought</a>&nbsp;
<a href="newProduct.jsp">�µ�����New Auction</a>&nbsp; &nbsp;
<br>
<br>

<form action="queryProduct.do">
    ��ѯ����Query Condition(��Ʒ����Product Name)��<input name="keyword">
    <input type="hidden" name="page" value="1">
    <input type="submit" value="��ѯSearch">
</form>
<br>



<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("ALL_PRODUCT");
%>

<%if(arr.size()==0){ %>
��ǰ��������������Ʒ��There is no product for sale now!
<%
}else{
%>

<br>
��������On Sale��<br>
<br>
<table border=3>
<tr><th>��Ʒ����Product Name</th>
<th>��Ʒ����Product Description</th>
<th>�鿴����Details</th>
</tr>
<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId() %>&action=2">�鿴����Details</a>	</td>
</tr>
<%} }%>
</table>
</div>
</body>
</html>