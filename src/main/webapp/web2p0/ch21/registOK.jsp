<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.bdsoft.web2p0.ch21.*"%>
<%
	Blog blog = (Blog)session.getAttribute(Constants.LOGIN_USER_KEY);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>用户注册成功</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
	</head>
	<body>
		<table height="45" cellspacing="0" cellpadding="0" width="750" border="0">
						
		</table>
		<table height="19" cellspacing="0" cellpadding="0" width="750" border="0">
			<tr>
				<td width="3"></td>
				<td width="252"></td>
				<td style="PADDING-TOP: 2px" align="middle">
					<p align="center">
						<b><font color="#ffffff">注册成功</font></b>
					</p>
				</td>
				<td width="252"></td>
				<td width="3"></td>
			</tr>
		</table>
		<table height="45" cellspacing="0" cellpadding="0" width="750" border="0">
			<tbody>
				<tr>
					<td align="middle">
						<font color="#FF0000"><b>恭喜您，您的BLOG空间已经开通！</b></font>
					</td>
				</tr>
				
			</tbody>
		</table>
		
		<table border="1" width="750" bordercolor="#000000">
			<tr>
				<td width="99%" valign="top">
					<p>
						<b>您现在可以：</b>
						<br>
						<br>
						<a class="for" href="/openBlog?blogid=<%=blog.getId()%>">进入您的BLOG</a>： 现在就开始吧
					</p>
					<p>
					</p>
				</td>
			</tr>
		</table>
	</body>
</html>
