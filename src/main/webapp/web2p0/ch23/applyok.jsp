<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import=" java.sql.*"%>
<HTML>
	<HEAD>
		<TITLE>聊天室</TITLE>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
	</HEAD>
	<BODY bgcolor="#99CCFF" >
		<%! String face,nick,code,code1,sex,email,qq;%>
		<%   
			request.setCharacterEncoding("UTF-8");
		    face= request.getParameter("face");
		    nick= request.getParameter("nick");
			code= request.getParameter("code"); 
			sex= request.getParameter("sex");
			email= request.getParameter("email");
			qq=request.getParameter("qq");    //从注册页面获得用户注册信息
			
			boolean fSame=false;
			if (face==null) face="4";
			if (sex==null)  sex="0";
			if (code==null)  code="";
			if (email==null)  email="";
			if (qq==null)  qq="";            //设置默认的用户信息  
              
		    String url = "jdbc:mysql://127.0.0.1/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    Connection c = DriverManager.getConnection(url);
		    Statement s = c.createStatement();//数据库的连接
		    if ((nick==null)||(nick.length()<=0))  nick="";
			else if (nick.length()>0)  {       // 用户输入呢称
				ResultSet r=s.executeQuery("SELECT * FROM chat " + "where Nickname='" + nick + "'"); //查询呢称，互斥
		        while(r.next()) {
				    fSame=true;
		        }
			 }
		    if (!fSame) {      //新的互斥的呢称
				s.executeUpdate(
			      "insert into chat values ('"+nick+"','"+code+"','"+sex+"','"+face+"','"
				  +qq+"','"+email+"')" );         //用户注册信息插入数据库
		        
				session.putValue ("face",face);
			    session.putValue ("code",code);
			    session.putValue ("nick",nick);
			    session.putValue ("sex",sex);
			    session.putValue ("email",email);
			    session.putValue ("qq",qq);          //信息存入session
			%>
		
		<DIV align=center>
		<BR><BR>
		<p><font color=red size=4>恭喜你，注册成功了!</font></P>
		
		<FORM action="index.jsp" method="POST" name="register" onsubmit="">
		<TABLE border="2" width="200">
		<TR><TD align="center" class="title">
		
		<FONT SIZE="4">您的信息如下</FONT></TD></TR><TR><TD>
		
		<FONT SIZE="2" >呢称:<%=nick %>
		
		</TD></TR><TR><TD>
		
		头像: <IMG SRC="images/face<%= face%>.gif" WIDTH="32" HEIGHT="32" BORDER=0 ALT="">
		<font color=red ></font></TD></TR><TR><TD>
		性别:<% if (sex.equals("0")) out.print("男");
		          else if (sex.equals("1")) out.print("女");
				    else out.print("保密"); %> 
		<font color=red ></font></TD></TR><TR><TD>QQ号码：<%= qq%>
		<font color=red ></font>
		
		</TD></TR><TR><TD>Email:<%= email%>
		<BR></TD></TR><TR><TD align="center">
		
		</TD></TR></TABLE>
		<BR>
		<INPUT type="button" value="关 闭 窗 口"  onclick="window.close();">
		<INPUT TYPE="submit" value="回到登录页面">
		</FORM>
		</div>
		
		
		
		<%	   } else {%>
			<BR>
			<CENTER><FONT COLOR="#FF0000">注册失败</FONT>，请<A HREF="register.jsp">重新注册</A>！</CENTER>
		<%  }
			s.close() ; %>
	</BODY>
</HTML>
