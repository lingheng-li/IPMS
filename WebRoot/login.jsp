<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登陆</title>
</head>
<body>
	<form action="UserAction_login" method="post">
		<p style="color:red;">
			<!-- 接收抛出的异常信息 -->
			<s:property value="exception.message" />
		</p>
		<p>
			用户名:<input type="text" name="name">
		<p>
			密　码:<input type="password" name="pwd">
		</p>
		<p>
			<input type="image" src="images/dl.jpg">
		</p>
	</form>
</body>
</html>
