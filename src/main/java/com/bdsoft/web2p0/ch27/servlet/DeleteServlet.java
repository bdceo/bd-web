package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		if (request.getParameter("id") != null) {
			ConnectBean db = new ConnectBean();
			boolean result = db.deleteMusicBean(Long.parseLong(request
					.getParameter("id")));
			db.Close();
			if (result) {
				out.print("删除成功！");
			} else {
				out.print("删除失败！");
			}
		} else {
			out.print("参数错误！");
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
