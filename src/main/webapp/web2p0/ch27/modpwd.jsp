<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>修改密码</title>
</head>
<body bgcolor="#B1C2E9">
<jsp:include flush="false" page="head.jsp" />
<center>
<br />
<form>
<table>
	<tr>
		<td align=center colspan=2 height=40><b>修改密码</td>
	</tr>
	<tr>
		<td align=right>旧密码:&nbsp;</td>
		<td><input type="password" name="oldPwd" /></td>
	</tr>
	<tr>
		<td align=right>新密码:&nbsp;</td>
		<td><input type="password" name="newPwd" /></td>
	</tr>
	<tr>
		<td align=right>确认密码:&nbsp;</td>
		<td><input type="password" name="accNewPwd" /></td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="chengePwd(oldPwd.value,newPwd.value,accNewPwd.value)"
			value="修改" />&nbsp;&nbsp;<input type="reset" value="重置" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>
