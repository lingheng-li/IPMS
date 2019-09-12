<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>费率修改页面</title>
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="css/user.css" media="all" /> 
	<style type="text/css">
		.layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
		@media(max-width:1240px){
			.layui-form-item .layui-inline{ width:100%; float:none; }
		}
	</style>
</head>

<body  class="childrenBody">
		<form action="FeilvAction_edit" method="post" style="width:80%;">
		<div class="user_left">
			<input type="hidden" name="user.id" value="<s:property value="#user.id"/>" />
				<div class="layui-form-item">
				    <label class="layui-form-label">车位数</label>
				    <div class="layui-input-block">
				    	<input type="text" name="user.parkingSpaces" class="layui-input userName" value="<s:property value="user.parkingSpaces"/>" />
				    </div>
				</div>
				<div class="layui-form-item">
				    <label class="layui-form-label">停车费</label>
				    <div class="layui-input-block">
				    	<input type="text" name="user.dayIncome" class="layui-input userName" value="<s:property value="user.dayIncome"/>" />
				    </div>
				</div>
				<div class="layui-form-item">
				    <label class="layui-form-label">月票费用</label>
				    <div class="layui-input-block">
				    	<input type="text" name="user.monthticketFee"  class="layui-input userName" value="<s:property value="user.monthticketFee"/>" />
				    </div>
				</div>
		</div>
		<div class="user_right">
			<input type="file" name="userFace" class="layui-upload-file" lay-title="掐指一算，我要换一个头像了">
			<p>由于是纯静态页面，所以只能显示一张随机的图片</p>
			<img src="images/face.jpg" class="layui-circle" id="userFace">
		</div>
		<div class="layui-form-item" style="margin-left: 5%;">
		    <div class="layui-input-block">
		    	<button class="layui-btn" type="submit">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
		</form>
</body>
</html>
