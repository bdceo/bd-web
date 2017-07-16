package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;
import com.bdsoft.web2p0.ch27.util.ProductXML;

public class QueryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/xml; charset=utf-8";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		ConnectBean db = new ConnectBean();
		String selectValue = "";
		if (request.getParameter("selectValue") != null) {
			selectValue = new String(request.getParameter("selectValue")
					.getBytes("ISO-8859-1"), "UTF8");
			int page;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			} else {
				page = 1;
			}
			if (request.getParameter("action") != null) {
				if (request.getParameter("action").equals("frist")) {
					page = 1;
				} else if (request.getParameter("action").equals("last")) {
					page = ConnectBean.PAGECOUNT;
				} else if (request.getParameter("action").equals("back")) {
					page -= 1;
				} else if (request.getParameter("action").equals("next")) {
					page += 1;
				}
			}
			ArrayList list = db.selectCDBean(selectValue, page, 10);
			ProductXML xml = new ProductXML();
			String xmlString = xml.getXML(list, ConnectBean.PAGECOUNT);
			int pagecount = ConnectBean.PAGECOUNT;
			request.setAttribute("pagecount", new Integer(pagecount));
			out.print(xmlString);
			System.out.println(xmlString);
		}
		db.Close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}

}
