<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>查看新闻</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script language="javascript" src="script/common.js"></script>
</head >
<body  bgcolor="#C6F4D6">
<TABLE width="100%">
    <tr>
    <td align=center><b>阅读新闻</td>
     </tr>
	<tr>
		<td>标题：<bean:write name="modifyNews" property="title"
			scope="session" /></td>
	</tr>
	<tr>
		<td>时间：<bean:write name="modifyNews" property="createDate"
			scope="session" /></td>
	</tr>
	<tr>
		<td>内容：<bean:write name="modifyNews" property="content"
			scope="session" /></td>
	</tr>
	<tr>
		<td align=center><input type="button" value="返回" onclick="history.back();"></td>
	</tr>
</TABLE>
</body>
</html>
