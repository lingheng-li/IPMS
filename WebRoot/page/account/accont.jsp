<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>用户管理页面</title>
<link rel="stylesheet"href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
<link rel="stylesheet" href="css/monTicket.css" media="all" />
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function changePage(pageNum,pageSize){
		$("#currentPageInput").val(pageNum);
		$("#pageSizeInput").val(pageSize);
		$("#userForm").submit();
	}
	
	function changePageSize(pageSize){
	
		$("#pageSizeInput").val(pageSize);
		
		$("#userForm").submit();
	}
</script>
</head>

<body class="childrenBody">
	<form action="UserAction_list" method="post" id="userForm">
	<!-- 当前页隐藏控件 -->
		<input type="hidden" name="currentPage" id="currentPageInput" />
	<!-- 每页显示几条数据隐藏控件 -->
		<input type="hidden" name="pageSize" id="pageSizeInput" />
	<blockquote class="layui-elem-quote news_search">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" value="" placeholder="请输入用户名" name="username"
						class="layui-input search_input">
				</div>
				<input type="submit" class="layui-btn search_btn" value="查询"/>
			</div>
			<div class="layui-inline">
				<a class="layui-btn linksAdd_btn" style="background-color:#5FB878" href="page/account/addAcount.jsp">新增用户</a>
			</div>
		</blockquote>
		<table class="layui-table">
			<thead>
				<tr>
					<th style="width:100px;text-align: center;">序号</th>
					<th style="text-align: center;">用户名</th>
					<th style="text-align: center;">密码</th>
					<th style="text-align: center;">真实姓名</th>
					<th style="text-align: center;">联系方式</th>
					<th style="text-align: center;">权限</th>
					<th style="text-align: center;">是否删除</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody class="links_content">
			<s:iterator value="#pageBean.list" var="user" >
				<tr>
					<td><span><s:property value="#user.id"/></span></td>
					<td><span><s:property value="#user.username"/></span></td>
					<td><span><s:property value="#user.password"/></span></td>
					<td><span><s:property value="#user.truename"/></span></td>
					<td><span><s:property value="#user.phone"/></span></td>
					<s:if test="#user.access == 1">
						<td><span>管理员</span></td>
					</s:if>
					<s:else><td><span>普通用户</span></td></s:else>
					<s:if test="#user.usertoken == 0">
					<td><span>未删除</span></td>
					</s:if>
					<s:else><td><span>已删除</span></td></s:else>
					<td>
						<a href="UserAction_edit?userid=<s:property value="#user.id"/>" style="color:white; height:30px;width:75px;background-color:#009688;;">编辑</a>
					</td>
				</tr>
			</s:iterator>
				<tr>
					<td colspan="2">共[<s:property value="#pageBean.totalCount"/>]条记录</td>
					<td>共[<s:property value="#pageBean.totalPage"/>]页</td>
					<td>每页显示
					 <select  id="pageSizeSelect" onchange="changePageSize($('#pageSizeSelect option:selected').val())">
							<option value="3" <s:property value=" #pageBean.pageSize==3?'selected':''"/> >3</option>
							<option value="5" <s:property value="#pageBean.pageSize==5?'selected':''"/>  >5</option>
					</select>条记录
					</td>
					<td>
						<a href="javascript:void(0)" onclick="changePage(<s:property value="#pageBean.currentPage-1"/>,<s:property value="#pageBean.pageSize"/>)" class="layui-btn search_btn">[前一页]</a>&nbsp;
						<a href="javascript:void(0)" onclick="changePage(<s:property value="#pageBean.currentPage+1"/>,<s:property value="#pageBean.pageSize"/>)" class="layui-btn search_btn">[后一页]</a>
					</td>
					<td colspan="4">到
					<input style="height:25px;width:100px;text-align:center" id="page" type="text" value="<s:property value="#pageBean.currentPage"/>"/>页 
					<input type="button"value="Go" style="color:white; height:30px;width:45px;background-color:#5FB878;" onclick="changePage($('#page').val(),<s:property value="#pageBean.pageSize"/>)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
