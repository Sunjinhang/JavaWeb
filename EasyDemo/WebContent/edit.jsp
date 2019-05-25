<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'add.jsp' starting page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/foundation/5.5.3/css/foundation.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/foundation.min.js"></script>
<script
	src="https://cdn.bootcss.com/foundation/5.5.3/js/vendor/modernizr.js"></script>
</head>
<body>
	<h1>修改页面</h1>
	<form action="ContactServlet?do=edit&id=${edituser.id}" method="post" style="width:50%">
		<fieldset>
			<label>姓名 <input type="text"  placeholder="name"  name="name" value = "${edituser.name}">
			</label> 
			<label>年龄 <input type="text"  placeholder="age" name="age" value = "${edituser.age}">
			</label>
			<label>电话<input type="text"  placeholder="phone" name="phone" value = "${edituser.phone}">
			</label>
			<label>生日<input type="date"  placeholder="date" name="date" value = "${edituser.date}">
			</label>
			<label>爱好<input type="text"  placeholder="favorite" name="favorite" value = "${edituser.favorite}">
			</label>
			<input type="submit" value="修改" class="button"> <input type="reset" class="button">
		</fieldset>
	</form>
</body>
</html>