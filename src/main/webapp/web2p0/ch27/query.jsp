<%@page contentType="text/html; charset=GBK"%>
<jsp:include flush="false" page="validate.jsp" />
<html>
<head>
<title>管理</title>
</head>
<body bgcolor="#B1C2E9" onload="javascript:selectCDs(page,'frist');">
<jsp:include flush="false" page="head.jsp" />
<br>
<center>
<table>
	<tr>
		<td>请输入歌曲名</td>
		<td><input type="text" name="selectValue1"
			onchange="selectValue=this.value" value="" /></td>
		<td><input type="submit"
			onclick="selectValue=selectValue1.value;selectCDs(page,'frist')"
			value="查询" /> <input type="button"
			onclick="selectValue='';selectCDs(page,'frist')" value="全部" /></td>
	</tr>
</table>
<br>
<table border="1" cellpadding="5" cellspacing="0">
	<tbody id="results">
	</tbody>
</table>
<table>
	<tr>
		<td><a name="frist" href="javascript:selectCDs(page,'frist');">首页</a>&nbsp;
		</td>
		<td><a name="back" href="javascript:selectCDs(page-1,'');">上一页</a>&nbsp;
		</td>
		<td><a name="next" href="javascript:selectCDs(page+1,'');">下一页</a>&nbsp;
		</td>
		<td><a name="last" href="javascript:selectCDs(page,'last');">尾页</a>&nbsp;
		</td>
		<td><samp id="page">0</samp>/<samp id="pageCount">0</samp></td>
		<td>转到 <input type="text" size="2" name="pageText" /> <input
			type="button" value="GO" onclick="selectCDs(document.all.pageText.value,'');" /></td>
	</tr>
</table>
</center>
</body>
</html>
