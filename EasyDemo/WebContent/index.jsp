<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="pers.contact.entity.Contact"%>
<%@ page import="pers.contact.service.ContactService"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//下面的语句初始为初始化页面，如果不加下面语句访问主页不会显示数据库中保存的数据
	ContactService ud = new ContactService();
	List<Contact> ulist = ud.GetAllContact();
	request.setAttribute("ulist", ulist);
%>  
    
 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
 
<meta charset="ISO-8859-1">
 
<link rel="stylesheet"
	href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
<style type="text/css">
table {
	margin: auto;
}
td {
	text-align: center;
}
h1 {
	margin-left: 40%;
}
a#add {
	margin-left: 45%;
}
</style>
<title>Insert title here</title>
</head>
<body style="padding:20px;">
	<h1>通讯录主页</h1>
	<a id="add" href="add.jsp">新增小伙伴</a>
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>电话</th>
				<th>生日</th>
				<th>爱好</th>
				<th>操作</th>
			</tr>
			<c:forEach var="U" items="${ulist}">
			<tr>
				<th>${U.id}</th>
				<th>${U.name}</th>
				<th>${U.age}</th>
				<th>${U.phone}</th>
				<th>${U.date}</th>
				<th>${U.favorite}</th>
				<th><a href="ContactServlet?do=editbefore&id=${U.id}">修改</a> <a href="ContactServlet?do=del&id=${U.id}">删除</a> </th>
			</tr>
			</c:forEach>
		</thead>
		<%--<c:forEach/>标签遍历List--%>
		
	</table>
</body>
</html>