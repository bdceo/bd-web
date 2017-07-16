<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<HTML>
	<HEAD>
		<TITLE>发送消息</TITLE>
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" src="js/chat.js"></script>
	</HEAD>
	<BODY bgcolor=#99CCFF onload="refresh()">
		<%
			String name = (String) session.getAttribute("userid");
			Vector chatwords = (Vector) application.getAttribute("chatwords");
			int num = 0;
			if (chatwords != null) {
				num = chatwords.size();
			}
		%>

		<font color=#669900 size=2>欢迎 <FONT COLOR=#660066 size=4>
				<I><B><%=name%></B>
			</I> <BR>
				<hr>
				<FORM action="#" name="sendform">
					<input type="hidden" id="num" value='<%=num%>'>
					<TABLE border=0 cellspacing=0 cellpadding=0>
						<TBODY>
							<TR>
								<TD colspan="3">
									对象
									<input type="text" name="talkto" id="talkto" value="所有人" />
									<SELECT name="act" id="act">
										<option value='向B说道：' selected>
											说话
										</option>
										<option value='很严肃的问道B：'>
											请问
										</option>
										<option value='使劲地拍着巴掌向B喊：'>
											喝采
										</option>
										<OPTION VALUE="抿着嘴向着B：">
											微笑
										</OPTION>
										<OPTION VALUE="扭过头跟B说：">
											躲避
										</OPTION>
									</SELECT>
								</TD>
							</TR>
							<TR>
								<TD colspan="3">
									<FONT SIZE="2">信息</FONT>
									<INPUT type="text" name="words" id="words" size="45"
										maxlength="120" />
									<button name="submit1" class="btnStyle" onclick='send()'>
										发送
									</button>
									<span class="p9"> <a href="exit.jsp" target='_top'>
											<IMG SRC="images/leave.gif" WIDTH="60" HEIGHT="35" BORDER=0>
									</a>
									</span>
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</FORM>

				<HR>
				<div id="wordsContainer">
					<%
						if (chatwords != null) { // 显示信息
							Object[] arraychatwords = chatwords.toArray();
							int wordslen = arraychatwords.length;
							for (int i = wordslen - 1; i >= 0; i--) {
								out.println("<p>" + (String) arraychatwords[i] + "</p>");
							}
						}
					%>
				</div>
	</BODY>
</HTML>
