<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<HTML>
	<HEAD>
		<meta http-equiv=refresh content="5; rl=#">
		<script language="JavaScript">
<!--
function menuclick(member)   {   
  //显示用户详细信息部分
  if( member.style.display =='none' ) 
     member.style.display = 'block';
   else  member.style.display = 'none';
}
function PerformSubmit(user) {             //改变当前聊天对象
  parent.sendmessage.sendform.talkto.value=user;
}
-->
</script>
	</HEAD>
	<%
		int usernum = 0;
		String act = "";
		String face = "";
		String nick = "";
		String sex = "";
		String qq = "";
		String email = "";

		String name = (String) session.getAttribute("userid");
		Hashtable userlist = (Hashtable) application
				.getAttribute("userlist");
		Enumeration aa = userlist.elements(); //获取在线用户
		usernum = userlist.size();
	%>

	<BODY bgcolor="#99CCFF">
		<form action="/" name="userlist">
			<BR>
			[在线用户:
			<span style="color: red;"><%=usernum%></span>人]
			<HR>
			<%
				int index = 0;

				while (aa.hasMoreElements()) { //罗列各个用户的信息
					index++;
					act = (String) aa.nextElement();
					int i = act.indexOf("++");
					if (i != -1) {
						nick = act.substring(0, i);
						act = act.substring(i + 2);
					}
					i = act.indexOf("++");
					if (i != -1) {
						face = act.substring(0, i);
						act = act.substring(i + 2);
					}
					i = act.indexOf("++");
					if (i != -1) {
						sex = act.substring(0, i);
						act = act.substring(i + 2);
					}
					i = act.indexOf("++");
					if (i != -1) {
						qq = act.substring(0, i);
						act = act.substring(i + 2);
					} //由拼接的信息提取各个部分
					//html完成显示
					email = act;
			%>
			<DIV
				onClick="menuclick(member<%=index%>);PerformSubmit('<%=nick%>');"
				width="15" height="15" style="CURSOR: hand">
				<img
					src="images/
<% if  (nick.equals(name)) out.print("me");
     else if (sex.equals("0"))out.print("gg");
        else out.print("mm");%>.gif">
				<%=nick%></div>
			<DIV id=member <%=index%> style="DISPLAY: none;">
				<IMG SRC="images/face<%=face%>.gif" WIDTH="32" HEIGHT="32" BORDER=0>
				&nbsp;&nbsp;
				<B><U><I><%=nick%></I>
				</U>
				</B>
				<BR>
				<B>QQ</B>:<%=qq%><BR>
				<B>Email</B>:<%=email%><BR>
			</div>
			<%
				}
			%>
			<HR>
		</form>
	</BODY>
</HTML>
