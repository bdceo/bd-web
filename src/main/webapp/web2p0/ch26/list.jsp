<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>人员登记系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script language="javascript" src="ajaxscript.js"></script>
<script>
		AjaxAnywhere.formName="listForm";
		AjaxAnywhere.getZonesToReload = function(){
			return "formlist";
		} 		
		function addPeron(){
			var f=document.forms[0];
			f.action='<%=basePath%>'+"listAction.do?method=addInfo";
			AjaxAnywhere.submitAJAX();
		} 
		function delInfo(id){
			if(!confirm("您确认要删除吗?")){
				return;
			}
			var f=document.forms[0];
			f.id.value=id;
			f.action='<%=basePath%>'+"listAction.do?method=delInfo";
			AjaxAnywhere.submitAJAX();
		} 
		function searchPerson(){
			var f=document.forms[0];
			var name = document.all.search.value;
			f.name.value=name;
			f.action='<%=basePath%>'+"listAction.do?method=searchList";
			AjaxAnywhere.submitAJAX();
			f.name.value="";
		}
		function delAll(){
			if(!confirm("您确认要删除所有人员信息吗?")){
				return;
			}
			var f=document.forms[0]; 
			f.action='<%=basePath%>'+"listAction.do?method=delAll";
			AjaxAnywhere.submitAJAX();
		}
</script>
</head>
<body bgcolor=#67ACE4>
<center>
<div>
<h3>所有登记人员</h3>
<aa:zone name="formlist">
	<table  bgcolor=#ffffff  border="0" cellpadding="4" cellspacing="1" width="80%">
		<tr bgcolor=#67ACE4>
			<td><b>ID</td>
			<td><b>姓名</td>
			<td><b>电话</td>
			<td><b>单位</td>
			<td><b>地址</td>
			<td><b>操作</td>
		</tr>
		<tr bgcolor=#67ACE4>
			<td colspan=6 align=right>
			<input type="text" name="search">
			<input type="button" value="查询" onclick="searchPerson();">
			<input type="button" value="清空" onclick="document.all.search.value='';">
			</td>
		</tr>
		<logic:present name="result">
			<logic:iterate id="list" name="result">
				<tr bgcolor=#67ACE4>
					<td><bean:write name="list" property="id" /></td>
					<td><bean:write name="list" property="name" /></td>
					<td><bean:write name="list" property="sex" /></td>
					<td><bean:write name="list" property="work" /></td>
					<td><bean:write name="list" property="address" /></td>
					<td><a href="javascript:delInfo('<bean:write name="list" property="id" />');">删除<a></td>
				</tr>
			</logic:iterate>
		</logic:present>
		<tr bgcolor=#67ACE4>
			<td colspan=6  align=left><input   type="button" value="删除全部" onclick="delAll();"></td>
		</tr>
	</table>
</aa:zone></center>
<hr><hr>
<center>
<div>
<h3>人员登记</h3>
</div>
<form name="listForm" action="<%=basePath%>listAction.do?method=addInfo"
	method="post">
	<input type="hidden" name="id" />
<table>
	<tr>
		<td align=right>姓名 :</td>
		<td><input type="text" name="name" /></td>
	</tr>
	<tr>
		<td align=right>电话 :</td>
		<td><input type="text" name="sex" /></td>
	</tr>
	<tr>
		<td align=right>单位 :</td>
		<td><input type="text" name="work" /></td>
	</tr>
	<tr>
		<td align=right>地址 :</td> 
		<td><input type="text" name="address" /></td>
	</tr>
	<tr>
		<td align=center colspan=2><input type="button" value="提交" onclick="addPeron()" />&nbsp;&nbsp;<input type="reset" value="重置" /></td>
	</tr>

</table>
</form>
</center>
</body>
</html>
