<%@ page contentType="text/html; charset=GBK" %>

<%
            String sort=request.getParameter("sort");
            String contents1="";
            String contents2="";
            if(sort.equals("submenu1")){
               contents1="һ�Ӳ˵�1";
               contents2="һ�Ӳ˵�2";
            }else if(sort.equals("submenu2")){
               contents1="���Ӳ˵�1";
               contents2="���Ӳ˵�2";
            }
   			 //������Ӧ���� 
             response.setContentType("text/xml; charset=UTF-8");
             response.setHeader("Cache-Control", "no-cache");
             out.println("<response>");
             out.println("<res>" + contents1 + "</res>");
             out.println("<res>" + contents2 + "</res>");
             out.println("</response>");
             out.flush();
             //out.close();         
%>
