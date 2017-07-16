<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
	<head>
		<title>客户关系管理系统</title>
	</head>
	<body>
		<table width="100%">
			<tr>
				<td colspan="2" height="25%">
					<tiles:insert attribute="header"></tiles:insert>
				</td>
			</tr>
			<tr>
				<td height="55%" width="20%">
					<tiles:insert attribute="tree"></tiles:insert>
				</td>
				<td height="55%" width="*">
					<tiles:insert attribute="content"></tiles:insert>
				</td>
			</tr>
			<tr>
				<td colspan="2" height="20%">
					<tiles:insert attribute="footer"></tiles:insert>
				</td>
			</tr>
		</table>
	</body>
</html>

