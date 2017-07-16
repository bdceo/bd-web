<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8"%>
<HTML>
	<HEAD>
		<TITLE>聊天室</TITLE>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
	</HEAD>
	<BODY>
		<h1>聊天室</h1>
		<br/>
		<br/>
		会员登陆:
		<FORM METHOD=post ACTION="frame.jsp">
			呢称：<input type="text" name="userid" style="width:90px;" maxLength="12"><BR>
			密码：<input type="password" name="password" style="width:90px;" maxLength="12"> <BR>
			<BR>
			<INPUT TYPE="submit" value="提交">
			<INPUT TYPE="reset" value="取消">
		</FORM>
		<a href="register.jsp">注册新会员</a>
	</BODY>
</HTMl>
