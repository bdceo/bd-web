<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.PrintWriter"%>
<%
	int wordslen = 0;
	String linewords = "";

	request.setCharacterEncoding("UTF-8");

	response.setHeader("Content-Type", "text/xml;charset=UTF-8");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");

	Vector chatwords = (Vector) application.getAttribute("chatwords");
	String face = (String) session.getAttribute("face"); //获取用户发送信息的个部分
	int num = Integer.parseInt(request.getParameter("num"));

	if (chatwords == null) { // 创建聊天信息列表
		chatwords = new Vector();
		application.setAttribute("chatwords", chatwords);
	}

	//以下完成各部分的拼接得到完整的发送信息
	String user1 = (String) session.getAttribute("userid");
	String words = request.getParameter("words");
	if (words != null) {
		String act = request.getParameter("act");
		String talkto = request.getParameter("talkto");
		int i = act.indexOf("B");
		if (i != -1) {
			act = act.substring(0, i) + talkto + act.substring(i + 1);
		}

		linewords = user1 + act + words;

		chatwords.add(linewords); //发送信息存入信息列表

	}

	Object[] arraychatwords = chatwords.toArray();
	int len = arraychatwords.length;

	/* XML的格式如下:
	 * <?xml version="1.0" encoding="UTF-8" ?>
	 * <words num=''>
	 *	<word></word>
	 * </words>
	 */

	PrintWriter pw = response.getWriter();
	StringBuffer sb = new StringBuffer();

	sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	sb.append("<words ").append("num='").append(len).append("'>");

	for (int j = len - 1; j >= num; j--) {
		sb.append("<word>").append((String) arraychatwords[j]).append(
				"</word>");
	}
	sb.append("</words>");
	pw.write(sb.toString());
%>
