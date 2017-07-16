package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;
import com.bdsoft.web2p0.ch27.bean.UserBean;

public class PasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		ConnectBean db = new ConnectBean();
		boolean result;
		UserBean ub = (UserBean) request.getSession().getAttribute("user");
		if (ub.getUserPwd().equals(request.getParameter("oldPwd"))) {
			ub.setUserPwd(request.getParameter("newPwd"));
			result = db.setUserBean(ub);
			if (result) {
				out.print("修改成功！");
			} else {
				out.print("修改失败！");
			}
			db.Close();
		} else {
			out.print("您所输入的原始密码不正确");
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
