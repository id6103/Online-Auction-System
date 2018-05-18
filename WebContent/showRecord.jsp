<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>我的竞价记录My Bidding Records</title>

</head>
<body background="./images/background.jpg">


<h1 align="center">我的竞价记录My Bidding Records</h1>


Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">退出登录Log Out</a> <a href="login.do?flag=1">返回首页Main Page</a><br><br>

<a href="queryProductByName.do?action=1">我的拍卖My Auction</a>
<a href="showRecord.do">我的竞价记录My Bidding Records</a>
<a href="queryProductByName.do?action=3">竞拍到的物品What I have Bought</a>
<a href="newProduct.jsp">新的拍卖New Auction</a>
<br><br>


<br>

<%
List<RecordVO> arr = (List<RecordVO>)request.getAttribute("RECORD");
if(arr.size()==0){
%>
无竞价记录No existing bidding records
<%
}
else
{
%>



<table border=3>
<tr><th>产品名称Product Name</th><th>我的报价My Price</th><th>查看详情Detail</th></tr>

<%for (RecordVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getPrice()%></td>
    <%int productId=vo.getProductId();%>
	<td><a href="productDetail.do?productId=<%= vo.getProductId()%>&action=2">查看详情Detail</a></td>
</tr>
<%} }%>
</table>

</body>
</html>