<%@page contentType="text/html; charset=GBK"%>
<html>
<head>
<title>disInfo</title>
</head>
<body bgcolor="#ffffff">
<h1>�û���¼�������Դ�java����</h1>
<form method="post" action="/test/LoginServlet">
<table>
  <tr>
    <td>�û�����</td>
    <td>
      <input type="text" name="uid"/>
    </td>
  </tr>
  <tr>
    <td>���</td>
    <td>
      <input type="password" name="pwd"/>
    </td>
  </tr>
</table>
<input type="button" value="��¼" onClick="submit()">
<input type="reset" value="���">
</form>
</body>
</html>
