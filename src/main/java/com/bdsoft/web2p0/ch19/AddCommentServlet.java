package com.bdsoft.web2p0.ch19;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCommentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = response.getWriter();
		String nikename = request.getParameter("nn");

		String comment = request.getParameter("rsn");
		String attitude = request.getParameter("atti");
		String filepath = request.getSession().getServletContext().getRealPath(
				"web2p0/ch19/data/comment.xml");
		// System.out.println(filepath);
		CommentBean bean = new CommentBean(filepath);
		String str = bean.addComment(nikename, comment, attitude);
		out.println(str);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
