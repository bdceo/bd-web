<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>����</title>
</head>
<body bgcolor="#B1C2E9" onload="javascript:selectCDs(page,'frist');">
<jsp:include flush="false" page="head.jsp" />
<br>
<center>
<table>
	<tr>
		<td>�����������</td>
		<td><input type="text" name="selectValue1"
			onchange="selectValue=this.value" value="" /></td>
		<td><input type="submit"
			onclick="selectValue=selectValue1.value;selectCDs(page,'frist')"
			value="��ѯ" /> <input type="button"
			onclick="selectValue='';selectCDs(page,'frist')" value="ȫ��" /></td>
	</tr>
</table>
<br>
<table border="1" cellpadding="5" cellspacing="0">
	<tbody id="results">
	</tbody>
</table>
<table>
	<tr>
		<td><a name="frist" href="javascript:selectCDs(page,'frist');">��ҳ</a>&nbsp;
		</td>
		<td><a name="back" href="javascript:selectCDs(page-1,'');">��һҳ</a>&nbsp;
		</td>
		<td><a name="next" href="javascript:selectCDs(page+1,'');">��һҳ</a>&nbsp;
		</td>
		<td><a name="last" href="javascript:selectCDs(page,'last');">βҳ</a>&nbsp;
		</td>
		<td><samp id="page">0</samp>/<samp id="pageCount">0</samp></td>
		<td>ת�� <input type="text" size="2" name="pageText" /> <input
			type="button" value="GO" onclick="selectCDs(document.all.pageText.value,'');" /></td>
	</tr>
</table>
</center>
</body>
</html>
