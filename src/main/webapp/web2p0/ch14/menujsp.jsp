<%@ page contentType="text/html; charset=GBK" %>

<%
            String sort=request.getParameter("sort");
            String contents1="";
            String contents2="";
            if(sort.equals("submenu1")){
               contents1="一子菜单1";
               contents2="一子菜单2";
            }else if(sort.equals("submenu2")){
               contents1="二子菜单1";
               contents2="二子菜单2";
            }
   			 //传回响应数据 
             response.setContentType("text/xml; charset=UTF-8");
             response.setHeader("Cache-Control", "no-cache");
             out.println("<response>");
             out.println("<res>" + contents1 + "</res>");
             out.println("<res>" + contents2 + "</res>");
             out.println("</response>");
             out.flush();
             //out.close();         
%>
