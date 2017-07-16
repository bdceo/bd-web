package com.bdsoft.web2p0.ch27.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.web2p0.ch27.bean.ConnectBean;
import com.bdsoft.web2p0.ch27.bean.ProductBean;
import com.bdsoft.web2p0.ch27.util.ProductXML;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/xml; charset=utf-8";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		if (request.getParameter("id") != null) {
			long id = Long.parseLong(request.getParameter("id"));
			ConnectBean db = new ConnectBean();
			ProductBean cb = null;
			if (request.getParameter("action") != null) {
				if (request.getParameter("action").equals("updata")) {
					cb = new ProductBean();
					cb.setCdAlbum(new String(request.getParameter("cdSinger")
							.getBytes("ISO-8859-1"), "UTF8"));
					cb.setCdCompany(new String(request.getParameter("cdCom")
							.getBytes("ISO-8859-1"), "UTF8"));
					cb.setCdName(new String(request.getParameter("cdName")
							.getBytes("ISO-8859-1"), "UTF8"));
					cb.setCdType(new String(request.getParameter("cdType")
							.getBytes("ISO-8859-1"), "UTF8"));
					cb.setCdId(id);
					boolean result = db.setMusicBean(cb);
					if (result)
						out.print("修改成功！");
					else
						out.print("修改失败！");
				}
			} else {
				cb = db.getMusicBean(id);
				ProductXML xml = new ProductXML();
				String xmlstr = xml.getXML(cb);

				out.print(xmlstr);
			}
			db.Close();
			out.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void destroy() {
	}

}
