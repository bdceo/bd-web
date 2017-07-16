<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<title>图书订阅</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="library.js" >
</script>
</head>

<body onload="startup()">
<font face="Arial,Helvetica,Verdana" size="3">

<form name="LibraryForm" action="/library">
<b>输入类型: </b>
<input type="text" name="subscriptionID" onblur="validate(this.form)"/> &nbsp; &nbsp;

<!-- Font for Status Message -->
<font face="Arial,Helvetica,Verdana" size="2" color="#FF0000">
<b id="msg"></b>
</font>
<!--  Font End -->
<hr>


<table height="300" width="600" border="1">
<tr>
<td valign="top" width="40%">

<!-- Font for Radio Buttons -->
<font face="Arial,Helvetica,Verdana" size="2">
<input type="radio" name="select" value="author" onclick="displayList('author')" />&nbsp;
<b>作者</b>
<input type="radio" name="select" value="pubs" onclick="displayList('pubs')" />
<b>出版社</b>
</font>
<!--  Font End -->

<br><br>
<div id="selectionList">
</div>
</td>

<td width="20%">&nbsp;</td>

<td valign="top" width="40%">
<b>选择标题: </b> <br>
<div id="titles"></div>
</td>

</tr>
</table>
<hr>
<input type="submit" name="order" value="订阅" disabled /> &nbsp; &nbsp;
<input type="reset" name="cancel" value="取消" />
</form>

</font>

</body>
</html>