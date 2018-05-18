<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>我的拍卖</title>

</head>
<body background="./images/background.jpg">
<%
Integer o = (Integer)request.getAttribute("ACTION");
int action=o.intValue();
if(action==1){
%>
<h1 align="center">我的拍卖</h1>
<%
}
else if(action==2){
%>
<h1 align="center">我的竞价记录</h1>
<%
}
else
{
%>
<h1 align="center">竞拍到的物品</h1>
<%
}
%>

Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">退出登录</a> <a href="login.do?flag=1">返回首页</a><br><br>

<a href="queryProductByName.do?action=1">我的拍卖</a>
<a href="showRecord.do">我的竞价记录</a>
<a href="queryProductByName.do?action=3">竞拍到的物品</a>
<a href="newProduct.jsp">新的拍卖</a>
<br><br>


<br>

<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("QUERYPRODUCT_RES");
if(arr.size()==0){
%>
无物品
<%
}
else
{
%>



<table border=3>
<tr><th>产品名称</th><th>产品描述</th><th>拍卖状态</th><th>查看详情</th></tr>

<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<%String state="拍卖中"; %>
    <%if(vo.getState()==0) state="已结束";%>
	<td><%=state%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId()%>&action=<%= action%>">查看详情</a></td>
</tr>
<%} }%>
</table>

</body>
</html>