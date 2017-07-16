package com.bdsoft.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=GBK";

	public void init() throws ServletException {
	}

	LoginBean login = new LoginBean();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		if (login.Login(uid, pwd) != 0) {
			response.sendRedirect("sql/main.jsp");
		} else {
			response.sendRedirect("sql/error.jsp");
		}
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Clean up resources
	public void destroy() {
	}
}
