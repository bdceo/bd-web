package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;
import com.bdsoft.web2p0.ch27.bean.UserBean;

public class CheckServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		if (request.getParameter("userName") != null
				&& request.getParameter("userPwd") != null) {
			String userName = new String(request.getParameter("userName")
					.getBytes("ISO-8859-1"), "UTF8");
			String userPwd = new String(request.getParameter("userPwd")
					.getBytes("ISO-8859-1"), "UTF8");
			ConnectBean db = new ConnectBean();
			UserBean ub = db.checkUsersLogin(userName, userPwd);
			request.getSession().setAttribute("user", ub);
			db.Close();
			if (ub == null) {
				out.print("您所输入的用户名或密码不正确");
			} else {
				out.print("登录成功！");
			}
		} else {
			out.print("您所输入信息有误！");
		}
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}

}
