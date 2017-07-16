package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;
import com.bdsoft.web2p0.ch27.bean.ProductBean;

public class NewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	public void init() throws ServletException {
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String cdName = new String(request.getParameter("cdName").getBytes(
				"ISO-8859-1"), "UTF8");
		String cdCom = new String(request.getParameter("cdCom").getBytes(
				"ISO-8859-1"), "UTF8");
		String cdSinger = new String(request.getParameter("cdSinger").getBytes(
				"ISO-8859-1"), "UTF8");
		String cdType = new String(request.getParameter("cdType").getBytes(
				"ISO-8859-1"), "UTF8");
		ConnectBean db = new ConnectBean();
		ProductBean cb = new ProductBean();
		cb.setCdAlbum(cdSinger);
		cb.setCdCompany(cdCom);
		cb.setCdName(cdName);
		cb.setCdType(cdType);
		boolean result = db.addMusicBean(cb);
		db.Close();
		if (result) {
			out.print("新增成功");
		} else {
			out.print("新增失败");
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
