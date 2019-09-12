<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <style type="text/css">
			#laiyu_div{
				margin: 50px  30%;
			}
			.laiyun_table{
				background-color: whitesmoke;
				color: royalblue;
				width: 600px ;
				height:300px;
			}
			input{
				height: 40px;
				width:300px;
				font-size: 20px;
				text-align: left;
				border-radius: 5px;
			}
			.laiyun_td{
				text-align:right;
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
  
  <body>
    <div id="laiyu_div">
			<form action="monthticketAction_add" method="post">
			<input type="hidden" name="ticket.id" value="<s:property value="#ticket.id"/>" />
			<input type="hidden" name="ticket.carToken" value="<s:property value="ticket.carToken"/>" />
				<table border="0" cellspacing="0" cellpadding="10" class="laiyun_table" >
					<thead>
						<tr>
							<s:if test="#ticket.id!= null">
								<td colspan="2" style="text-align: center;"><h3>编辑月票信息</h3></td>
							</s:if>
							<s:else>
								<td colspan="2" style="text-align: center;"><h3>新增月票信息</h3></td>
							</s:else>
							
						</tr>
					</thead>
					<tr>
						<td class="laiyun_td">月票卡号:</td>
						<td><input type="text" name="ticketId" value="<s:property value="#ticket.ticketId"/>"/></td>
					</tr>
					<tr>
						<td class="laiyun_td">车主姓名:</td>
						<td><input type="text" name="ownerInfo" value="<s:property value="#ticket.ownerInfo"/>"/></td>
					</tr>
					<tr>
						<td class="laiyun_td">车牌号码:</td>
						<td><input type="text" name="carId"  value="<s:property value="#ticket.carId"/>" /></td>
					</tr>
					<tr>
						<td class="laiyun_td">到期月份:</td>
						<td><input type="text" name="dueMonth"  value="<s:property value="#ticket.dueMonth"/>" /></td>
					</tr>
					<tr>
						<td class="laiyun_td">删除标志:</td>
						<td><input type="text" name="carToken"  value="<s:property value="#ticket.carToken"/>" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input type="submit" value="立即提交" style=" background-color:#5FB878;text-align: center;width: 100px;height: 30px;"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" value="重置" style="width:100px;height:30px;background-color:#5FB878;text-align: center; " onclick="reset()"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
  </body>
</html>
