<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>ע���ύ</title>
	</head>

	<body>
		<h1><br> 
			</h1><h1>��д����ע����Ϣ 
		</h1>
		<br>
		<form action="regInfo.jsp" method="post">
			��ѡ�б��
			<select name="work" multiple="multiple" size="4">
				<option value="teacher">
					��ʦ
				</option>
				<option value="student">
					ѧ��
				</option>
				<option value="manager">
					������
				</option>
				<option value="officer">
					��Ա
				</option>
			</select>
			<br>
			��д���ĵ绰���룺<br>
			<input type="text" name="phone">
			<input type="text" name="phone">
			<input type="text" name="phone">
			<br>
			<input type="submit" value="�ύa" name="sub"> 
			<input type="submit" value="�ύs" name="sub">			
		</form>
	</body>
</html>
