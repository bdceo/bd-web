<%@page contentType="text/html; charset=GBK"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>�޸�</title>
<script language="javascript" src="js/script.js" type=""></script>
</head>
<body bgcolor="#91C0E3" onload="getCDs(window.dialogArguments.id)">
<table>
	<tr style="display:none">
		<td>���:&nbsp; <input type="text" name="cdIdform" size="2 value="" 
			ead nly /></td>
	</tr>
	<tr >
		<td colspan=2 align=center height=40><b>�޸Ĳ���</td>
	</tr>
	<tr height=30>
		<td  align=right>����:&nbsp;</td>
		<td><input type="text" name="cdNameform" value="" /></td>
	</tr>
	<tr height=30>
		<td  align=right>���֣�&nbsp;</td>
		<td><input type="text" name="cdAlbumform" value="" /></td>
	</tr>
		<tr height=30>
		<td  align=right>��ע��&nbsp;</td>
		<td><input type="text" name="cdCompanyform" value="" /></td>
	</tr>
	<tr height=30>
		<td  align=right>���:&nbsp;</td>
		<td><sql:setDataSource
			dataSource="proxool.DatabasePool" var="db" scope="page" /> <sql:query
			var="query" dataSource="${db}">select * from musictype</sql:query> <select
			name="cdTypeform">
			<c:forEach var="type" items="${query.rows}">
				<option value="${type.CDtypeId}">${type.display}</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan=2 align=center><br><input type="submit"
			onclick="javascript:updateCDs(cdIdform.value,cdNameform.value,cdCompanyform.value,cdAlbumform.value,cdTypeform.value)"
			value="ȷ��" />&nbsp;&nbsp;<input type="button"
			onclick="javascript:window.close(this);" value="�ر�" /></td>
	</tr>
</table>
</body>
</html>
