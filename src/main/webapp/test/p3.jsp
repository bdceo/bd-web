<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
	<head>
		<title>My JSP 'p1.jsp' starting page</title>
	</head>
	<body>
		<%
			Integer in = Integer.valueOf(request.getParameter("num"));
			int num = in.intValue() * 3;
		%>

		输入一个数字：
		<input name="num" value="<%=num%>">
		<br>
	</body>
</html>
