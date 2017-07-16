<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<HTML>
<HEAD>
<TITLE>聊天室</TITLE>
</HEAD>
<%		response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
		String name = "";
			String code = "";

			String pass = "";
			String sex = "";
			String qq = "";
			String face = "";
			String email = "";

			boolean ismember = false;//varirable defination

			request.setCharacterEncoding("UTF-8");

			name = request.getParameter("userid");
			code = request.getParameter("password");
			
			String url = "jdbc:mysql://127.0.0.1/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8";

			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection c = DriverManager.getConnection(url);

			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("SELECT * FROM chat where nickname='"
					+ name + "'"); // query user
			while (r.next()) {
				ismember = true;
				pass = r.getString("password");
				face = r.getString("face");
				sex = r.getString("sex");
				qq = r.getString("qq");
				email = r.getString("email");
			} //  get user's information

			if (ismember) { //  user is a  registed user
				if (code.equals(pass)) {
					session.setAttribute("userid", name);
					session.setAttribute("password", code);
					session.setAttribute("qq", qq);
					session.setAttribute("sex", sex);
					session.setAttribute("email", email);
					session.setAttribute("face", face); //save user's information in session
					Hashtable userlist = (Hashtable) application
							.getAttribute("userlist");

					if (userlist == null)
						userlist = new Hashtable();
					userlist.put(name, name + "++" + face + "++" + sex + "++"
							+ qq + "++" + email);
					application.setAttribute("userlist", userlist);//insert uer's infomation into userlist (Hashtable)

				%>
	<FRAMESET cols="*,200">
		<FRAME SRC="send.jsp" NAME="sendmessage" noresize frameborder=0>
		<FRAME SRC="getinfo.jsp" NAME="receivemessage" noresize frameborder=0>
	</FRAMESET>
<%} else {
				%>
<BODY bgcolor=#99CCFF>
<p>密码错误，请<A HREF="index.jsp">重新登录</A></p>
</BODY>
<%}
		} else {
%>
<BODY bgcolor=#99CCFF>
<p>会员 <%=name%>不存在，请<A HREF="register.jsp">注册新会员</A></p>
</BODY>
<%}%>
</HTML>
