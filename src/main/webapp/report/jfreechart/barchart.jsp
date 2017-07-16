<%@ page language="java" pageEncoding="gbk"%>
<%@ page import="com.bdsoft.report.CreateBarChart"%>
<%@ page import="java.io.PrintWriter"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
	</head>
	<body>
		<%
			CreateBarChart barChart = new CreateBarChart();
			String fileName = barChart.getBarChart(session,
					new PrintWriter(out));
			String graphURL = request.getContextPath()
					+ "/DisplayChart?filename=" + fileName;
		%>
		<img src="<%=graphURL%>" width=1024 height=768 border=0¡¡usemap="<%=fileName%>"> 
	</body>
</html>
