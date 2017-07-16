package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLinksAction extends HttpServlet {

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
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		String id = request.getParameter("id");

		// 利用hibernate查询热点博客和最新文章
		DbOperate db = new DbOperate();
		HttpSession session = request.getSession(true);

		// 设置输出信息的格式及字符集
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		// 创建输出流对象
		PrintWriter out = response.getWriter();
		// 依据验证结果输出不同的数据信息
		out.println("<response>");
		Blog blog = (Blog) session.getAttribute(Constants.LOGIN_USER_KEY);

		if ("load".equals(action)) {
			List linkList = db.getBlogLinks(blog.getId());
			for (int i = 0; i < linkList.size(); i++) {
				Links link = (Links) linkList.get(i);
				out.println("<link>");
				out.println("<id>" + link.getId() + "</id>");
				out.println("<name>" + link.getName() + "</name>");
				out.println("<url>" + link.getUrl() + "</url>");
				out.println("</link>");
			}
		} else if ("add".equals(action)) {
			Links link = new Links();
			link.setName(name);
			link.setUrl(url);
			link.setBlogid(blog.getId());
			db.save(link);
			out.println("<id>" + link.getId() + "</id>");
			out.println("<name>" + link.getName() + "</name>");
			out.println("<url>" + link.getUrl() + "</url>");
		} else if ("delete".equals(action)) {
			Links link = db.getLink(Integer.parseInt(id));
			db.delete(link);
			out.println("<id>" + link.getId() + "</id>");
		}
		out.println("</response>");
		out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO 自动生成方法存根
		this.doGet(arg0, arg1);
	}
}
