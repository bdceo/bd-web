package com.bdsoft.web2p0.ch21;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveSelfInfoAction extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
	}

	/*
	 * 处理<GET> 请求方法.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置接收信息的字符集
		request.setCharacterEncoding("UTF-8");
		// 接收浏览器端提交的信息
		String subject = request.getParameter("subject");
		String psw = request.getParameter("psw");
		String email = request.getParameter("email");

		HttpSession session = request.getSession(true);
		Blog blog = (Blog) session.getAttribute(Constants.LOGIN_USER_KEY);
		blog.setPassword(psw);
		blog.setSubject(subject);
		blog.setEmail(email);

		/*
		 * 保存信息
		 */
		DbOperate db = new DbOperate();
		db.update(blog);
		session.setAttribute(Constants.MODIFY_OK_KEY, new Integer(1));
		response.sendRedirect("/web2p0/ch21/adminSelf.jsp");
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO 自动生成方法存根
		this.doGet(arg0, arg1);
	}

}
