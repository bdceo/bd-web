<%@ page contentType="text/html; charset=GBK" %>

<%
 
            String key=request.getParameter("key");
            String contents="";
            if(key.equals("1")){
               contents="IBM笔记本,IBM笔记本,IBM笔记本,IBM笔记本,IBM笔记本";
            }else if(key.equals("2")){
               contents="HP笔记本,HP笔记本,HP笔记本,HP笔记本,HP笔记本,HP笔记本";
            }else if(key.equals("3")){
               contents="SONY笔记本,SONY笔记本,SONY笔记本,SONY笔记本,SONY笔记本";
            }
           
   			 //传回响应数据 
             response.setContentType("text/xml; charset=UTF-8");
             response.setHeader("Cache-Control", "no-cache");
             out.println("<response>");
             out.println("<content>" + contents + "</content>");
             out.println("</response>");
             out.flush();
             //out.close();         
          
     
%>