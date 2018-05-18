<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>网上拍卖系统Online Auction System</title>
<style>
#header{width:100%;height:150px;background-image:url(./images/head_bg.jpg);
		background-repeat:no-repeat ;}
</style>
</head>


<body background="">
<div id="container">
<div id="header" >
<br>
<h1 align="center"> 网上拍卖系统Online Auction System</h1>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp; 
<a href="UpdateUser.jsp"> 修改用户信息Edit User Info</a>
<a href="logout.do" >退出登录Log Out</a><br>
<br>
</div>

<br>
<a href="queryProductByName.do?action=1">我的拍卖My Auction</a>&nbsp;
<a href="showRecord.do">我的竞价记录My Bidding Records</a>&nbsp;
<a href="queryProductByName.do?action=3"> 竞拍到的物品What I have bought</a>&nbsp;
<a href="newProduct.jsp">新的拍卖New Auction</a>&nbsp; &nbsp;
<br>
<br>

<form action="queryProduct.do">
    查询条件Query Condition(商品名称Product Name)：<input name="keyword">
    <input type="hidden" name="page" value="1">
    <input type="submit" value="查询Search">
</form>
<br>



<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("ALL_PRODUCT");
%>

<%if(arr.size()==0){ %>
当前无正在拍卖的商品！There is no product for sale now!
<%
}else{
%>

<br>
正在拍卖On Sale：<br>
<br>
<table border=3>
<tr><th>产品名称Product Name</th>
<th>产品描述Product Description</th>
<th>查看详情Details</th>
</tr>
<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId() %>&action=2">查看详情Details</a>	</td>
</tr>
<%} }%>
</table>
</div>
</body>
</html>