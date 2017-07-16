package com.bdsoft.czbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// ���Ի���
		Integer init = (Integer) request.getSession().getAttribute("total");
		if (init == null) {
			init = new Integer(1);
		} else {
			init++;
		}
		request.getSession().setAttribute("total", init);

		String[] names = { "ceo", "jdi", "laoding", "dingchenye" };
		String str = request.getParameter("name");
		// str = new String(str.getBytes("ISO8859-1"), "UTF-8");
		str = URLDecoder.decode(str, "UTF-8");
		System.out.println("-----" + str);
		boolean back = false;
		if (str == null || str.length() == 0) {
			out.println("�û�����Ϊ�գ�" + init);
		} else {
			for (String name : names) {
				if (name.equals(str)) {
					back = true;
				}
			}
		}
		if (back) {
			out.println("�û���" + str + "���Ѿ����ڣ���ʹ�������û���" + init);
		} else {
			out.println("�û���" + str + "������ʹ�ã�" + init);
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
