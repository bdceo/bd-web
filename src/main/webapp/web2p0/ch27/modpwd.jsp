<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>�޸�����</title>
</head>
<body bgcolor="#B1C2E9">
<jsp:include flush="false" page="head.jsp" />
<center>
<br />
<form>
<table>
	<tr>
		<td align=center colspan=2 height=40><b>�޸�����</td>
	</tr>
	<tr>
		<td align=right>������:&nbsp;</td>
		<td><input type="password" name="oldPwd" /></td>
	</tr>
	<tr>
		<td align=right>������:&nbsp;</td>
		<td><input type="password" name="newPwd" /></td>
	</tr>
	<tr>
		<td align=right>ȷ������:&nbsp;</td>
		<td><input type="password" name="accNewPwd" /></td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="chengePwd(oldPwd.value,newPwd.value,accNewPwd.value)"
			value="�޸�" />&nbsp;&nbsp;<input type="reset" value="����" /></td>
	</tr>
</table>
</form>
</center>
</body>
</html>
