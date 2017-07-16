package com.bdsoft.czbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxXmlServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();

		String str = request.getParameter("name");
		boolean back = false;
		if (str == null || str.length() == 0) {
			out.println("<message>�û�����Ϊ�գ�</message>");
		} else {
			StringBuffer builder = new StringBuffer();
			builder.append("<message>");
			if (str.equals("ceo")) {
				builder.append("�û���" + str + "���Ѿ����ڣ���ʹ�������û���</message>");
			} else {
				builder.append("�û���" + str + "������ʹ�ã�</message>");
			}
			out.println(builder.toString());
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
