<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<script language="javascript" src="js/script.js" type=""></script>
<body bgcolor="#B1C2E9">
<center>
<h1>��ӭ${sessionScope.user.userName}��¼����ϵͳ��</h1>
<br>
<br>
<table>
	<tr>
		<td><b><a href="javascript:goAdd()">[��������]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:goSelect()">[��������]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:goChenge()">[�޸�����]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:out()">>>�˳�</a></td>
	</tr>
</table>
</center> 
</body>
