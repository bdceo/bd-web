<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
	<head>
		<title>My JSP 'p1.jsp' starting page</title>
	</head>

	<body>
		<form method="post" action="p3.jsp">
			<%
			Integer in = Integer.valueOf(request.getParameter("num"));
			int num=in.intValue()*2;
			out.println("�����ǣ�"+num);
			%>
			���ֵĶ����ǣ�
			<input name="num" value="<%=num %>" type="hidden"> 
			<br>
			<input type="submit">
		</form>
	</body>
</html>
