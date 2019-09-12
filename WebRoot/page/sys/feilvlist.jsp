<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>费率查看页面</title>
	<link rel="stylesheet" href="//at.alicdn.com/t/font_tnyc012u2rlwstt9.css" media="all" />
	<link rel="stylesheet" href="css/monTicket.css" media="all" />
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function changePage(pageNum,pageSize){
		$("#currentPageInput").val(pageNum);
		$("#pageSizeInput").val(pageSize);
		$("#ticketForm").submit();
	}
	
	function changePageSize(pageSize){
	
		$("#pageSizeInput").val(pageSize);
		
		$("#ticketForm").submit();
	}
</script>
</head>
<body class="childrenBody">
	<form action="FeilvAction_list" method="post" id="ticketForm">
	<!-- 当前页隐藏控件 -->
		<input type="hidden" name="currentPage" id="currentPageInput" />
	<!-- 每页显示几条数据隐藏控件 -->
		<input type="hidden" name="pageSize" id="pageSizeInput" />
		<table class="layui-table">
			<thead>
				<tr >
					<th style="width:2000px;text-align: center;">序号</th>
					<th style="width:2000px;text-align: center;">车位数</th>
					<th style="text-align: center; width:2000px">停车费</th>
					<th style="text-align: center; width:2000px">月票费用</th>
					<th style="text-align: center; width:2000px">操作</th>
				</tr>
			</thead>
			<tbody class="links_content">	
					<tr >
						<td><span><s:property value="#pageBean.id"/></span></td>
						<td><span><s:property value="#pageBean.parkingSpaces"/></span></td>
						<td><span><s:property value="#pageBean.dayIncome"/></span></td>
						<td><span><s:property value="#pageBean.monthticketFee"/></span></td>
						<td>
						<a href="FeilvAction_edit1?userid=<s:property value="#pageBean.id"/>" style="color:white; height:30px;width:45px;background-color:#009688;;">编辑</a>&nbsp;
					</tr>
			</tbody>
		</table>
	</form>
</body>
</html>
