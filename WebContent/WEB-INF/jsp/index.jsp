<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib uri="/struts-tags" prefix="s" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style>	
  /* body{background: url(js/ct.jpg);width:100%} */
  body{color:#666666;}
  #table_all{text-align: center;}
  
  table{width:1000px;border:1px solid black;text-align: center; margin-top: 30px;}
  th,td{border:1px black solid;}
  #query,#delete,#sendAdd{
  text-decoration: none;
  width: 80dp;height: 35dp;font-size: 18px;}
  #delete{color:red;}
  #query2{width: 220px;height: 25px;}
</style>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>

<center>
	
	<h2 style="color: #00a2e3">小米手机售卖后台</h2>
	
 <s:form action="xiaomi_find">
	
	模糊查询：<input id="query2" name="like" placeholder=" 商品名 或 收货人查询"> <s:submit id="query" value="查询"/>
	
</s:form>
<s:form action="xiaomi_delSche.action"> 
	<table border="1">
		<tr>
			<th>选择</th>
			<th>预约号</th>
			<th>商品名</th>
			<th>购买时间</th>
			<th>收货人</th>
			<th>邮箱地址</th>
			<th>手机号</th>
			<th>收获地址</th>
		</tr>
	<s:iterator value="list" status="status">
			<tr>
				<td><s:checkbox fieldValue="%{sid}" name="sids" value="false"/></td>
				<td><s:property value="sid"/></td>
				<td><s:property value="productName"/></td>
				<td><s:date name="buyDate" format="yyyy-MM-dd"/></td>
				<td><s:property value="consignee"/></td>
				<td><s:property value="email"/></td>
				<td><s:property value="mobile"/></td>
				<td><s:property value="address"/></td>
				
			    <td><s:a href="xiaomi_sendUpdate?update_id=%{sid}">修改</s:a></td> 
			</tr>
	</s:iterator>
	<tr>
		<td colspan="6" align=center><s:submit  style="margin: 5px;" id="delete" value="删除"/></td>
		<td colspan="4" align=center><Button  style="margin: 5px;"><s:a id="sendAdd" href="xiaomi_sendAdd">添加</s:a></Button></td>
	</tr>
			
	</table>
</s:form>

</center>

<script type="text/javascript">
	$(function(){
		$("tr:even").css("background","#d2d2d2");
		
	});
	
</script>
</body>
</html>