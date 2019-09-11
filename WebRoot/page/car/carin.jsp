<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="utf-8">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="format-detection" content="telephone=no">
	<link rel="stylesheet" href="../../layui/css/layui.css" media="all" />
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="../../css/user.css" media="all" />
	</head>
<body class="childrenBody">
	<blockquote class="layui-elem-quote news_search">
		<div class="layui-inline">
		    <div class="layui-input-inline">
		    	<input type="text" value="" placeholder="请输入关键字" class="layui-input search_input">
		    </div>
		    <a class="layui-btn search_btn">查询</a>
		</div>
		<div class="layui-inline">
			<a class="layui-btn layui-btn-normal usersAdd_btn">添加车辆</a>
		</div>
 		<div class="layui-inline">
			<a class="layui-btn layui-btn-danger showAll">显示全部</a>
		</div> 
		<div class="layui-inline">
			<div class="layui-form-mid layui-word-aux">　本页面刷新后除新添加的文章外所有操作无效，关闭页面所有数据重置</div>
		</div>
	</blockquote>
	<div class="layui-form users_list">
	  	<table class="layui-table">
		    <colgroup>
				<col width="50">
				<col width="20%">
				<col width="28%">
				<col width="30%">
				<col width="22%">
		    </colgroup>
		    <thead>
				<tr>
					<th><input type="checkbox" name="" lay-skin="primary" lay-filter="allChoose" id="allChoose"></th>
					<th>车牌号</th>
					<th>进入时间</th>
					<th>用户姓名</th>
					<th>操作</th>
				</tr> 
<%-- 				<tr>
			    	<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>
			    	<td>${user.username}</td>
			    	<td>${user.access}</td>
			    	<td>${user.truename}</td>
			    	<td>
					<a class="layui-btn layui-btn-mini users_edit"><i class="iconfont icon-edit"></i> 结算</a>
					<a class="layui-btn layui-btn-danger layui-btn-mini users_del" data-id="data[i].usersId+"><i class="layui-icon">&#xe640;</i> 删除</a>
			        </td>
			    </tr> --%>
		    </thead>
		    <tbody class="users_content"></tbody>
		</table>
	</div>
	<div id="page"></div>
	<script type="text/javascript" src="../../layui/layui.js"></script>
	<script type="text/javascript" src="allCar.js"></script>
</body>
</html>
