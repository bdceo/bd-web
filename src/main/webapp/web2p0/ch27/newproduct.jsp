<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>����</title>
</head>
<body bgcolor="#B1C2E9">
<jsp:include flush="false" page="head.jsp" />
<br>
<center>
<table>
	<tr>
		<td align=center colspan=2 height=40><b>��������</td>
	</tr>
	<tr>
		<td align=right>����:&nbsp;</td>
		<td><input type="text" name="cdName" /></td>
	</tr>
	<tr>
		<td align=right>����:&nbsp;</td>
		<td><input type="text" name="cdAlbum" /></td>
	</tr>
	<tr>
		<td align=right>��ע:&nbsp;</td>
		<td><input type="text" name="cdCompany" /></td>
	</tr>
	<tr>
		<td align=right>���:&nbsp;</td> 
		<td>
		<sql:setDataSource dataSource="proxool.DatabasePool"
			var="db" scope="page" /> <sql:query var="query" dataSource="${db}">select * from musictype</sql:query>
		<select name="cdType">
			<c:forEach var="type" items="${query.rows}">
				<option value="${type.CDtypeId}">${type.display}</option>
			</c:forEach>
		</select>
		</td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="insertCDs(cdName.value,cdCompany.value,cdAlbum.value,cdType.value)"
			value="ȷ��" />&nbsp;&nbsp;<input type="reset" value="����" /></td>
	</tr>
</table>
</center>
</body>
</html>
