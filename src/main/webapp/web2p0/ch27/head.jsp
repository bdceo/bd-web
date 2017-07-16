<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<script language="javascript" src="js/script.js" type=""></script>
<body bgcolor="#B1C2E9">
<center>
<h1>欢迎${sessionScope.user.userName}登录管理系统！</h1>
<br>
<br>
<table>
	<tr>
		<td><b><a href="javascript:goAdd()">[新增歌曲]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:goSelect()">[歌曲管理]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:goChenge()">[修改密码]</a>&nbsp;&nbsp;</td>
		<td><b><a href="javascript:out()">>>退出</a></td>
	</tr>
</table>
</center> 
</body>
