<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加/修改页面</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
</head>
<body>
<center>

<s:form action="xiaomi_addSche.action" id="myform">
	商 品 名：<s:textfield style="margin:5px;" name="s.productName" value="%{s.productName}"/><br>
	<%-- 购买时间：<s:date name="s.buyDate" value="%{s.buyDate}"/><br> --%>
	收 货 人：<s:textfield style="margin:5px;" name="s.consignee" value="%{s.consignee}"/><br>
	邮箱地址：<s:textfield style="margin:5px;" name="s.email" value="%{s.email}"/><br>
	手 机 号：<s:textfield style="margin:5px;" name="s.mobile" value="%{s.mobile}"/><br>
	收获地址：<s:textfield style="margin:5px;" name="s.address" value="%{s.address}"/><br>
	<s:hidden id="hidden" value="%{status}"/>
	<s:hidden name="s.sid" value="%{s.sid}"/>
	<s:hidden name="s.buyDate" value="%{s.buyDate}"/>
	<s:submit style="margin:5px;" value="添加" id="btn"/>
</s:form>

</center>

<script type="text/javascript">
$(function(){
	$("#btn").val($("#hidden").val());
	$("#btn").click(function(){
		if($(this).val()=="修改"){
			$("#myform").prop("action","xiaomi_updateSche.action");
			$("#myform").submit();
		}else{
			$("#myform").prop("action","xiaomi_addSche.action");
			$("#myform").submit();
		}
	})
});

</script>
</body>
</html>