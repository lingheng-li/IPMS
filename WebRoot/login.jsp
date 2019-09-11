<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>IPMS</title>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
	</head>

	<body>
		<div class="m-login-bg">
			<div class="m-login">
				<h3>IPMS登录</h3>
				<div class="m-login-warp">
					<form class="layui-form">
						<div class="layui-form-item">
							<input type="text" id="name" required lay-verify="required" name="tUser.username" placeholder="用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<input type="password" id="pwd" required lay-verify="required" name="tUser.password" placeholder="密码" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-item">
							<div class="layui-inline">
								<input type="text" name="verity" required lay-verify="required" placeholder="验证码" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-inline">
								<img class="verifyImg" onclick="this.src=this.src+'?c='+Math.random();" src="images/login/yzm.jpg" />
							</div>
						</div>
						<div class="layui-form-item m-login-btn">
							<div class="layui-inline">
								<button class="layui-btn layui-btn-normal" lay-submit lay-filter="login">登录</button>
							</div>
							<div class="layui-inline">
								<button type="reset" class="layui-btn layui-btn-primary">取消</button>
							</div>
						</div>
					</form>
				</div>
				<p class="copyright">Copyright 2019 by LI</p>
			</div>
		</div>
 		<script src="layui/layui.js" type="text/javascript" charset="utf-8"></script>
 		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script>
 			layui.use(['form'], function() {
				var form = layui.form(),
					layer = layui.layer;
				var $ = layui.jquery;

				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					password: [/(.+){6,12}$/, '密码必须6到12位'],
					verity: [/(.+){6}$/, '验证码必须是6位'],
				});

				//监听提交
				form.on('submit(login)', function() {
					/* $("#loginFrom").submit(); */
 					$.post({
						url:"UserAction_login",
						data:{name:$("#name").val(),pwd:$("#pwd").val()},
/* 						dataType:"json", */
						success:function (data){
							var obj=data;
							var access = obj["access"];
							if(access==1){
								window.location.href="index.jsp";
							}else if (access==0) {
								window.location.href="index.jsp";
							}else{
								window.location.href="login.jsp";
							}
						}
					}); 
					return false;
				});
			});
		</script>
	</body>

</html>