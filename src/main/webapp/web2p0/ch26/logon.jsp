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
<title>ϵͳ��¼</title>
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
<h1>��Ա�Ǽ�ϵͳ��¼</h1>
<br>
<br>
<form name="LogonForm" action="<%=basePath%>LogonAction.do?method=logOn"
	method="post">
<table align="center"> 
	<tr> 
		<td align=right>�û���:&nbsp;</td>
		<td><input type="text" name="name" size=19/></td>
	</tr>
	<tr>
		<td align=right>����:&nbsp;</td>
		<td><input type="password" name="pwd" size=20/></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=center colspan=2>
		<input type="submit" onclick="javascript:logonsys()" name="Submit" value="��¼">&nbsp;
		<input type="reset"  value="����">&nbsp;
	</tr>
</table>
</form>
<br />
</center>
</body>
</html>
