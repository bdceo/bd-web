<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ע��</title>
<script language="javascript" src="js/script.js"></script>
</head>
<body bgcolor="#B1C2E9">
<center><br>
<table>
	<tr>
		<td align=center colspan=2><b>�û�ע��<br></td>
	</tr>
		<tr>
		<td align=center colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=right>�û���:&nbsp;</td>
		<td><input type="text" name="userName" /></td>
	</tr>
	<tr>
		<td align=right>�û�����: &nbsp;</td>
		<td><input type="password" name="userPwd" /></td>
	</tr>
	<tr>
		<td align=right>ȷ������:&nbsp;</td>
		<td><input type="password" name="accPwd" /></td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="userReg(userName.value,userPwd.value,accPwd.value)"
			value="ȷ��" />&nbsp;<input type="reset" value="����" />&nbsp;<input type="button" value="����" onclick="history.back();"/></td>
	</tr>
</table>
</center>
</body>
</html>
