<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>出口管理--IPMS</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="layui/css/layui.css" media="all" />
 	<link rel="stylesheet" href="css/user.css" media="all" /> 
</head>
  
<body class="childrenBody">
    <form class="layui-form">
		<div class="user_left" >
			<input type="hidden" id="id" value="${record.id}" disabled class="layui-input layui-disabled">
			<input type="hidden" id="userId" value="${record.userId.id}" disabled class="layui-input layui-disabled">
			<div class="layui-form-item">
			    <label class="layui-form-label">用户姓名</label>
			    <div class="layui-input-block">
			    	<input type="text" value="${record.userId.username}" disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">车牌号码</label>
			    <div class="layui-input-block">
			    	<input type="text" id="carId" value="${record.carId}" disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">真实姓名</label>
			    <div class="layui-input-block">
			    	<input type="text" value="${record.userId.truename}" disabled placeholder="请输入真实姓名" lay-verify="required" class="layui-input realName">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">进入时间</label>
			    <div class="layui-input-block">
			    	<input type="text" id="entertime" value="${record.entertime}" disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">离开时间</label>
			    <div class="layui-input-block">
			    	<input type="text" id="leavetime" value="${record.leavetime}" disabled class="layui-input layui-disabled">
			    </div>
			</div>
			<div class="layui-form-item">
			    <label class="layui-form-label">停车费用</label>
			    <div class="layui-input-block">
			    	<input type="text" id="fee" value="${record.fee}" disabled class="layui-input layui-disabled">
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
		    	<button class="layui-btn" lay-submit="" lay-filter="carout">立即结算</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
		</div>
	</form>
	<script type="text/javascript" src="layui/layui.js"></script>
<!-- 	<script type="text/javascript" src="page/user/user.js"></script> -->
		<script>
 			layui.use(['form'], function() {
				var form = layui.form(),
					layer = layui.layer;
				var $ = layui.jquery;

				//监听提交
				form.on('submit(carout)', function() {
 					$.post({
						url:"RecordAction_Pay",
						data:{id: $("#id").val(),userId:$("#userId").val(),
							carId:$("#carId").val(),entertime:$("#entertime").val(),
							leavetime:$("#leavetime").val(),fee:$("#fee").val()},
						success:function (data){
							if(data==1){
								window.location.href="page/car/carin.jsp";
							}
						}
					}); 
					return false; 
				});
			});
		</script>
</body>
</html>
