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
	<h1>新增页面</h1>
<form action="ContactServlet?do=add" method="post" style="width:50%;"> 
   <fieldset> 
    <label>姓名 <input type="text" placeholder="name" required="required" name="name" /> </label> 
    <label>年龄 <input type="number" placeholder="age" required="required"  min="1" max="133" name="age" /> </label> 
    <label>电话<input type="text" placeholder="phonenum" required="required" name="phone" /> </label> 
    <label>生日<input type="date" placeholder="date" required="required" name="date" /> </label> 
    <label>爱好<input type="text" placeholder="favorite" required="required" name="favorite" /> </label> 
    <input type="submit" value="新增" class="button" /> 
    <input type="reset" class="button" /> 
   </fieldset> 
  </form>   
</body>
</html>