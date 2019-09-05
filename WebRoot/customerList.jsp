<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>">
<meta charset="utf-8">
<title>首页</title>
<link rel="stylesheet" href="css/oa.css">
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function changePage(pageNum,pageSize){
		$("#currentPageInput").val(pageNum);
		$("#pageSizeInput").val(pageSize);
		$("#customerForm").submit();
	}
	function del(custId){
		var flag =confirm("确定删除吗？");
		//如果flag为true删除
		if(flag){
			window.location.href= "CustomerAction_delete?customer.custId="+custId;
		}		
	}
	function changePageSize(pageSize){
		$("#pageSizeInput").val(pageSize);
		
		$("#customerForm").submit();
	}
</script>
<style>
	*{
		margin: 0 auto;
	}
	.oa_div{
		width: 100%;
		height: 75px;
		background-color: #1E90FF;
	}
	ul{
		list-style:none;
	}
	.oa_tou_ul li{
		display:inline-block;
		width:100px;
		height:50px;
		line-height:50px;
	}
</style>
</head>
<body>
	<table width="50%" class="oa_table">
		<tr>
			<td valign="top" colspan="3">
			    <form action="CustomerAction_list" method="post" id="customerForm">
			      	<span>顾客名称</span>
			      	<input type="text" name="custName">
			      	<input type="submit" value="查询">
			      	<!-- 当前页隐藏控件 -->
			      	<input type="hidden" name="currentPage" id="currentPageInput">
			      	<!-- 每页显示几条数据隐藏控件 -->
			      	<input type="hidden" name="pageSize" id="pageSizeInput">
			      	
					<table width="100%" class="oa_table" id="table1">
						<tr class="oa_tr">
							<td colspan="10" align="center" height="50" style="font-size:20px;">顾客一览表</td>
						</tr>
						<tr class="oa_tr">
							<td align="center"><span class="oa_body_span">顾客编号</span></td>
							<td align="center"><span class="oa_body_span">顾客名称</span></td>
							<td align="center"><span class="oa_body_span">顾客行业</span></td>
							<td align="center"><span class="oa_body_span">顾客等级</span></td>
							<td align="center"><span class="oa_body_span">顾客电话</span></td>
							<td align="center"><span class="oa_body_span">操作</span></td>
	
						</tr>
						<s:iterator value="#pageBean.list" var="cust">
							<tr class="oa_tr">
								<td align="center"><span class="oa_body_span"><s:property value="#cust.custId"/></span></td>
								<td align="center"><span class="oa_body_span"><s:property value="#cust.custName"/></span></td>
								<td align="center"><span class="oa_body_span"><s:property value="#cust.custIndustry.dictItemName"/></span></td>
								<td align="center"><span class="oa_body_span"><s:property value="#cust.custLevel.dictItemName"/></span></td>
								<td align="center"><span class="oa_body_span"><s:property value="#cust.custPhone"/></span></td>
								<td align="center">
									<span class="oa_body_span">
										<a href="CustomerAction_edit?customer.custId=<s:property value="#cust.custId"/>">更新</a>
										<a href="javascript:del(<s:property value="#cust.custId"/>)">删除</a>
									</span>
								</td>
							</tr>
						</s:iterator>
							<tr>
								<td align="center">共[<s:property value="#pageBean.totalCount"/>]条记录</td>
								<td align="center">[<s:property value="#pageBean.totalPage"/>]页</td>
								<td align="center">每页显示
									<select id="pageSizeSelect"  onchange="changePageSize($('#pageSizeSelect option:selected').val())">	
										<option value="3" <s:property value="#pageBean.pageSize==3?'selected':''"/>>3</option>
										<option value="5" <s:property value="#pageBean.pageSize==5?'selected':''"/>>5</option>
									</select>
									</td>
								<td align="center">
									<a href="javascript:void(0)" onclick="changePage(<s:property value="#pageBean.currentPage-1"/>,<s:property value="#pageBean.pageSize"/>)">[前一页]</a>
									<a href="javascript:void(0)" onclick="changePage(<s:property value="#pageBean.currentPage+1"/>,<s:property value="#pageBean.pageSize"/>)">[后一页]</a>
								</td>
								<td align="center">到
								<input id="page" type="text" value="<s:property value="#pageBean.currentPage"/>"/>页
								<input type="button" value="Go" onclick="changePage($('#page').val(),<s:property value="#pageBean.pageSize"/>)"/>
								</td>
							</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>