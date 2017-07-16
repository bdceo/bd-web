<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>欢迎登录简易新闻系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0"> 
</head> 
<body bgcolor="#C6F4D6">
<center>
<h1>简易新闻管理系统</h1> 
<img src="web2p0/ch22/images/logon.gif">
<form action="/logon.do" method="post">
<TABLE width="100%">
	<TR>
		<TD align="center">用户名：<input type="text" name="userName"  size=19></TD>
	</TR>
	<TR>
		<TD align="center">密   码：<input type="password" name="passWord"  size=21></TD>
	</TR>
	<TR>
		<TD align="center"><input type="submit" value="登录">&nbsp;&nbsp;<input
			type="reset" value="重置"></TD>
	</TR>
</TABLE>
</form>
</body>
</html>
