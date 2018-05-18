<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="GB2312"%>
    <%@ page import="java.util.List"%>
<%@ page import="auction.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>网上拍卖系统</title>

</head>
<body background="./images/background.jpg">
<h1 align="center">网上拍卖系统</h1>
Welcome to you, <%=session.getAttribute("LOGIN_USER") %> &nbsp;&nbsp;
<a href="logout.do">退出登录</a>
<a href="login.do?flag=1">返回首页</a><br><br>

<form action="queryProduct.do">
    查询条件(商品名称)：<input name="keyword">
    <input type="hidden" name="page" value="1">
    <input type="submit" value="查询Search">
</form>

<%!int pageNum;%>
<%!int totalPage;%>
<%!String keyword;%>



<%
List<ProductVO> arr = (List<ProductVO>)request.getAttribute("QUERYPRODUCT_RES");
Integer o = (Integer) request.getAttribute("PAGE_NUM");//int->Integer
pageNum = o.intValue();
Integer p=(Integer) request.getAttribute("TOTAL_PAGE_NUM");
totalPage = p.intValue();
String keyword=(String)request.getAttribute("KEYWORD");
%>

<%if(arr.size()==0){ %>
<br/>未查询到符合条件商品！No available products!
<%
}else{
%>
<br>查询结果Result：<br><br>
当前第<%=pageNum%>页 共<%=totalPage%>页
<br><br>


<table border=3>
<tr><th>产品名称Product Name</th><th>产品描述Product Description</th><th>查看详情Detail</th></tr>
<%for (ProductVO vo : arr) {%>
<tr>
	<td><%=vo.getProductName()%></td>
	<td><%=vo.getProductDesc()%></td>
	<td><a href="productDetail.do?productId=<%= vo.getId() %>&action=2">查看详情Detail</a></td>
</tr>
<%}%>
</table>
<%if(totalPage!=1){ %>
<%if(pageNum==1&totalPage!=1) {%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum+1%>">下一页Next</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=totalPage%>">末页Last</a>
<%}
else if(pageNum==totalPage&totalPage!=1){%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=1">首页First</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum-1%>">上一页Previous</a>
<%}
else {%>
<a href="queryProduct.do?keyword=<%=keyword%>&page=1">首页First</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum-1%>">上一页Previous</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=pageNum+1%>">下一页Next</a>
<a href="queryProduct.do?keyword=<%=keyword%>&page=<%=totalPage%>">末页Last</a>
<%} } }%>

</body>
</html>