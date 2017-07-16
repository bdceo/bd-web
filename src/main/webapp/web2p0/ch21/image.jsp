<%@ page contentType="image/jpeg"%>
<%@ page import="javax.imageio.*"%>
<jsp:useBean id="image" scope="session" class="com.bdsoft.web2p0.ch21.ImageTool" />
<%
	
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	
	
	ImageIO.write(image.creatImage(), "JPEG", response.getOutputStream());
	session.setAttribute("rand",image.sRand);	
	
	out.clear();
	out = pageContext.pushBody();
%>
 