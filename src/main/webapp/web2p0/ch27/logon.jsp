<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>ϵͳ��¼</title>
<script language="javascript" src="js/script.js" type=""></script>
</head>
<body bgcolor="#B1C2E9">
<center>
<h1>���˸�������ϵͳ��¼</h1>
<br>
<br>
<form>
<table align="center">
	<tr> 
		<td align=right>�û���:&nbsp;</td>
		<td><input type="text" name="userName" size=19/></td>
	</tr>
	<tr>
		<td align=right>����:&nbsp;</td>
		<td><input type="password" name="userPwd" size=20/></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=center colspan=2>
		<input type="submit" onclick="javascript:logonsys(userName.value,userPwd.value)" name="Submit" value="��¼">&nbsp;
		<input type="reset"  value="����">&nbsp;
		<input type="button" value="ע��" onclick="regPage()"/></td>
	</tr>
</table>
</form>
<br />
</center>
</body>
</html>
