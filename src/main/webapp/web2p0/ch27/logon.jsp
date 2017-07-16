<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>系统登录</title>
<script language="javascript" src="js/script.js" type=""></script>
</head>
<body bgcolor="#B1C2E9">
<center>
<h1>个人歌曲管理系统登录</h1>
<br>
<br>
<form>
<table align="center">
	<tr> 
		<td align=right>用户名:&nbsp;</td>
		<td><input type="text" name="userName" size=19/></td>
	</tr>
	<tr>
		<td align=right>密码:&nbsp;</td>
		<td><input type="password" name="userPwd" size=20/></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td align=center colspan=2>
		<input type="submit" onclick="javascript:logonsys(userName.value,userPwd.value)" name="Submit" value="登录">&nbsp;
		<input type="reset"  value="重置">&nbsp;
		<input type="button" value="注册" onclick="regPage()"/></td>
	</tr>
</table>
</form>
<br />
</center>
</body>
</html>
