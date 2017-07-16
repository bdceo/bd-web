<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册提交</title>
	</head>

	<body>
		<h1><br> 
			</h1><h1>填写您的注册信息 
		</h1>
		<br>
		<form action="regInfo.jsp" method="post">
			多选列表框：
			<select name="work" multiple="multiple" size="4">
				<option value="teacher">
					老师
				</option>
				<option value="student">
					学生
				</option>
				<option value="manager">
					管理者
				</option>
				<option value="officer">
					官员
				</option>
			</select>
			<br>
			填写您的电话号码：<br>
			<input type="text" name="phone">
			<input type="text" name="phone">
			<input type="text" name="phone">
			<br>
			<input type="submit" value="提交a" name="sub"> 
			<input type="submit" value="提交s" name="sub">			
		</form>
	</body>
</html>
