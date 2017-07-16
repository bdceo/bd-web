<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>注册</title>
<script language="javascript" src="js/script.js"></script>
</head>
<body bgcolor="#B1C2E9">
<center><br>
<table>
	<tr>
		<td align=center colspan=2><b>用户注册<br></td>
	</tr>
		<tr>
		<td align=center colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=right>用户名:&nbsp;</td>
		<td><input type="text" name="userName" /></td>
	</tr>
	<tr>
		<td align=right>用户密码: &nbsp;</td>
		<td><input type="password" name="userPwd" /></td>
	</tr>
	<tr>
		<td align=right>确认密码:&nbsp;</td>
		<td><input type="password" name="accPwd" /></td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="userReg(userName.value,userPwd.value,accPwd.value)"
			value="确认" />&nbsp;<input type="reset" value="重置" />&nbsp;<input type="button" value="返回" onclick="history.back();"/></td>
	</tr>
</table>
</center>
</body>
</html>
