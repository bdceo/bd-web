<%@ page contentType="text/html; charset=GBK" %>

<%
 
            String key=request.getParameter("key");
            String contents="";
            if(key.equals("1")){
               contents="IBM�ʼǱ�,IBM�ʼǱ�,IBM�ʼǱ�,IBM�ʼǱ�,IBM�ʼǱ�";
            }else if(key.equals("2")){
               contents="HP�ʼǱ�,HP�ʼǱ�,HP�ʼǱ�,HP�ʼǱ�,HP�ʼǱ�,HP�ʼǱ�";
            }else if(key.equals("3")){
               contents="SONY�ʼǱ�,SONY�ʼǱ�,SONY�ʼǱ�,SONY�ʼǱ�,SONY�ʼǱ�";
            }
           
   			 //������Ӧ���� 
             response.setContentType("text/xml; charset=UTF-8");
             response.setHeader("Cache-Control", "no-cache");
             out.println("<response>");
             out.println("<content>" + contents + "</content>");
             out.println("</response>");
             out.flush();
             //out.close();         
          
     
%>