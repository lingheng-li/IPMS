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
<base href="<%=basePath%>">
<title>新增用户页面</title>
	<style type="text/css">
			#laiyu_div{
				margin: 50px  30%;
			}
			.laiyun_table{
				background-color: whitesmoke;
				color: royalblue;
				width: 600px ;
				height:300px;
				text-align: left ;
			}
			input{
				height: 40px;
				width:300px;
				font-size: 20px;
				text-align:left;
				border-radius: 5px;
			}
			.laiyun_td{
				text-align: center;
				font-size: 20px;
			}
			.laiyun_select{
				height: 40px;
				width:300px;
				text-align: left;
				font-size: 20px;
				border-radius: 5px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
		<script type="text/javascript">
		$(function(){
			function reset(){
				$("input").val("");
			}
		})
		</script>
</head>

<body  class="childrenBody">
	<div id="laiyu_div">
			<form action="UserAction_add" method="post">
			<input type="hidden" name="user.id" value="<s:property value="#user.id"/>" />
				<table border="0" cellspacing="0" cellpadding="10" class="laiyun_table" >
					<thead>
						<tr>
							<s:if test="#user.id != null">
								<td colspan="2" class="laiyun_td"><h3>编辑用户信息</h3></td>
							</s:if>
							<s:else>
								<td colspan="2" class="laiyun_td"><h3>新增用户信息</h3></td>
							</s:else>
							
						</tr>
					</thead>
					<tr>
						<td class="laiyun_td">用户名:</td>
						<td class="laiyun_td"><input type="text" name="user.username" value="<s:property value="#user.username"/>" /></td>
					</tr>
					<tr>
						<td class="laiyun_td">密码:</td>
						<td class="laiyun_td"><input type="text" name="user.password" value="<s:property value="#user.password"/>"/></td>
					</tr>
					<tr>
						<td class="laiyun_td">姓名:</td>
						<td class="laiyun_td"><input type="text" name="user.truename"  value="<s:property value="#user.truename"/>" /></td>
					</tr>
					<tr>
						<td class="laiyun_td">手机号:</td>
						<td class="laiyun_td"><input type="text" name="user.phone"  value="<s:property value="#user.phone"/>" /></td>
					</tr>
					<tr>
						<td class="laiyun_td">用户权限:</td>
						<td class="laiyun_td" >
							<select name="user.access" class="laiyun_select">
								<option value="0" <s:property value="#user.access==0?'selected':''"/> >管理员</option>
								<option value="1" <s:property value="#user.access==1?'selected':''"/> >普通用户</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="laiyun_td">删除标记:</td>
						<td class="laiyun_td">
						<select name="user.usertoken" class="laiyun_select">
								<option value="0" <s:property value="#user.usertoken==0?'selected':''"/> >未删除</option>
								<option value="1" <s:property value="#user.usertoken==1?'selected':''"/> >已删除</option>
						</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="laiyun_td" >
						<input type="submit" value="立即提交" style="width:120px;height:40px;background-color:#5FB878;text-align: center; "/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="重置" style="width:120px;height:40px;background-color:#5FB878;text-align: center; " onclick="reset()"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>
