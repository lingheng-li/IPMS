<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:property value="#customer==null?'新增':'修改'"/>顾客</title>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/loadSelect.js"></script>
    <script type="text/javascript">
	    $(document).ready(function(){
	    	loadSelect("001","custlevel","customer.custLevel.dictId",<s:property value="#customer.custLevel.dictId"/>);
	    	loadSelect("002","custIndustry","customer.custIndustry.dictId",<s:property value="#customer.custIndustry.dictId"/>);
	    }); 
    </script>
  </head>
  
  <body>
   	<form action="CustomerAction_add">
   		<input type="hidden" name="customer.custId" value="<s:property value="#customer.custId"/>">
   		<table>
   			<tr>
   				<td colspan="3"><s:property value="#customer==null?'新增':'修改'"/>顾客</td>
   			</tr>
	   		<tr>
	   			<td><span>顾客姓名</span></td>
	   				<td>
	   				<s:if test="customer==null">
	   					<input type="text" name="customer.custName" value="<s:property value="#customer.custName"/>">
	   				</s:if>
	   				<s:else>
	   					 <input type="text" name="customer.custName" readonly="readonly" value="<s:property value="#customer.custName"/>">
	   				</s:else>	
	   				</td>
	   			<td><span>顾客行业</span></td>
	   			<td id="custIndustry"></td>
	   		</tr>
	   		<tr>
	   			<td><span>顾客等级</span></td>
	   			<td id="custlevel"></td>
	   			<td><span>电话号码</span></td>
	   			<td><input type="text" name="customer.custPhone" value="<s:property value="#customer.custPhone"/>"></td>
	   		</tr>
	   		<tr>
	   			<td><input type="submit" value="提交"/></td>
	   		</tr>
   		</table>
   	</form>
  </body>
</html>
