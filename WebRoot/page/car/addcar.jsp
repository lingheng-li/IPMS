<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>入库停车--IPMS</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<style type="text/css">
		.layui-form-item .layui-inline{ width:33.333%; float:left; margin-right:0; }
		@media(max-width:1240px){
			.layui-form-item .layui-inline{ width:100%; float:none; }
		}
	</style>
</head>
<body class="childrenBody">
	<form class="layui-form" style="width:80%;">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" id="userId" class="layui-input userName" lay-verify="required" placeholder="请输入用户名">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车牌号</label>
			<div class="layui-input-block">
				<input type="text" id="carId" class="layui-input userEmail" lay-verify="" placeholder="请输入车牌号">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="addCar">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="../../layui/layui.js"></script>
<!-- 	<script type="text/javascript" src="addUser.js"></script> -->
		<script>
 			layui.use(['form'], function() {
				var form = layui.form(),
					layer = layui.layer;
				var $ = layui.jquery;

				//监听提交
				form.on('submit(addCar)', function() {
 					$.post({
						url:"RecordAction_addCar",
						data:{userId: $("#userId").val(),carId:$("#carId").val()},
						success:function (data){
							if(data==1){
								window.location.href="carin.jsp";
							}else{
								alert("用户不是月票用户，请办理");
								window.location.href="../../page/monticket/mtms.jsp";
							}
						}
					}); 
					return false; 
				});
			});
		</script>
</body>
</html>