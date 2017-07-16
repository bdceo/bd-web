<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.bdsoft.web2p0.ch21.*"%>
<%
	Blog blog = (Blog)session.getAttribute(Constants.VISIT_BLOG_KEY);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>博客主页</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
		<base target="contents">
	</head>
	<body>


		<table height="45" cellspacing="0" cellpadding="0" width="750" border="0">
			<tbody>
				<tr>
					<td align="middle">
						<b><font size="2" color="#FF0000"><%=blog.getSubject()%>的博客</font></b>
					</td>
				</tr>
				
			</tbody>
		</table>

	</body>
</html>
