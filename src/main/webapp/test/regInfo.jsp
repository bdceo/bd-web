<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>ע����Ϣ</title> 
  </head>  
  <body> 
  	<%
  		request.setCharacterEncoding("gb2312");
  		out.println("��ѡ���б���Ϣ��");
  		String[] work=request.getParameterValues("work");
  		for(int i=0;i<work.length;i++){
  			out.println(work[i]);
  		}
  		out.println("<br/>");
  		out.println("�绰��");
  		String[] phone=request.getParameterValues("phone");
  		for(int i=0;i<phone.length;i++){
  			out.println(phone[i]);
  		} 
  		out.println("<br/>");
  		String[] sub=request.getParameterValues("sub");
  		for(int i=0;i<sub.length;i++){
  			out.println(sub[i]);
  		} 
  		out.println("<br/>");
  	 %>
  </body>
</html>
