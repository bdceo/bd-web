<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<HTML>
<HEAD>
</HEAD>
<%  response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	String name = (String) session.getAttribute("userid");
	session.setAttribute("userid", null);
    Hashtable userlist = 
	         (Hashtable) application.getAttribute("userlist");
    userlist.remove(name);                   //在线用户列表删除此用户
	application.setAttribute("userlist",userlist);  //更新用户application中的列表
%>
<BODY bgcolor = "#99CCFF"  >
   <BR><BR><BR><CENTER><B><%= name %></B>再见，欢迎再来!</CENTER>
</BODY>

</HTMl>