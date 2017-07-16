package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAction extends HttpServlet {

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
		String uname = request.getParameter("uname");
		String psw = request.getParameter("psw");
		String checkwd = request.getParameter("checkwd");

		HttpSession session = request.getSession();
		String checkwd2 = (String) session.getAttribute("rand");
		// 设置输出信息的格式及字符集
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		// 创建输出流对象
		PrintWriter out = response.getWriter();

		// 依据验证结果输出不同的数据信息
		out.println("<response>");
		Blog blog = new DbOperate().getBlog(uname);

		if (blog == null) { // 用户名错误
			out.println("<res>1</res>");
		} else {
			String dbPassword = blog.getPassword();
			if (!dbPassword.equals(psw)) { // 口令错误
				out.println("<res>2</res>");
			} else if (!checkwd.equals(checkwd2)) { // 验证码错误
				out.println("<res>3</res>");
			} else {
				session.setAttribute(Constants.LOGIN_USER_KEY, blog);
				out.println("<res>0</res>");
				out.println("<id>" + blog.getId() + "</id>");
			}
		}
		out.println("</response>");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
