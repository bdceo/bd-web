<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>系统登录</title>
<script language="javascript" src="ajaxscript.js"></script>
<script language="javascript">
	function logonsys(){
			var f=document.forms[0];
			f.action='<%=basePath%>'+"LogonAction.do?method=logOn";
			AjaxAnywhere.submitAJAX();
	}
</script>
</head>
<body bgcolor="#67ACE4">
<center>
<h1>人员登记系统登录</h1>
<br>
<br>
<form name="LogonForm" action="<%=basePath%>LogonAction.do?method=logOn"
	method="post">
<table align="center"> 
	<tr> 
		<td align=right>用户名:&nbsp;</td>
		<td><input type="text" name="name" size=19/></td>
	</tr>
	<tr>
		<td align=right>密码:&nbsp;</td>
		<td><input type="password" name="pwd" size=20/></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=center colspan=2>
		<input type="submit" onclick="javascript:logonsys()" name="Submit" value="登录">&nbsp;
		<input type="reset"  value="重置">&nbsp;
	</tr>
</table>
</form>
<br />
</center>
</body>
</html>
