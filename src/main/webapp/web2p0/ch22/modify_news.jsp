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
<title>修改新闻</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script language="javascript" src="script/common.js"></script>
</head>
<body  bgcolor="#C6F4D6">
<form method="post"
	action="/newsOption.do?method=modify&newsid=<bean:write name="modifyNews" property="newsId" scope="session"/>">
<TABLE width="100%">
    <tr>
    <td align=center><b>修改新闻</td>
     </tr>
	<tr>
		<td>新闻标题：<input type="text" name="title"
			value="<bean:write name="modifyNews" property="title" scope="session"/>"></td>
	</tr>
	<tr>
		<td>时间：<input type="text" name="createDate"
			value="<bean:write name="modifyNews" property="createDate" scope="session"/>"> </td>
	</tr>
	<tr>
		<td>新闻内容</td>
	</tr>
	<tr>
		<td><textarea name="content" rows="10" cols="50"><bean:write
			name="modifyNews" property="content" scope="session" /></textarea></td>
	</tr>
	<tr>
		<td align=center><input type="submit" value="确认">&nbsp;&nbsp;<input type="reset"
			value="重置"></td>
	</tr>
</TABLE>
</form>
</body>
</html>
