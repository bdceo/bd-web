<%@page contentType="text/html; charset=GBK"%>
<html>
<head>
<title>disInfo</title>
</head>
<body bgcolor="#ffffff">
<h1>用户登录——测试纯java连接</h1>
<form method="post" action="/test/LoginServlet">
<table>
  <tr>
    <td>用户名：</td>
    <td>
      <input type="text" name="uid"/>
    </td>
  </tr>
  <tr>
    <td>口令：</td>
    <td>
      <input type="password" name="pwd"/>
    </td>
  </tr>
</table>
<input type="button" value="登录" onClick="submit()">
<input type="reset" value="清空">
</form>
</body>
</html>
