<%@ page language="java" pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<%
			String uname = request.getParameter("userName");			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "root");
			String sql = "select * from ru where uname='" + uname + "'";
			ResultSet rs = con.createStatement().executeQuery(sql);
			if (rs.next()) { 
				out.println("Sorry!");
			} else { 
				out.println("you can use !");
			}
			rs.close();
			con.close();
		%>
	</body>
</html>