package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstAction extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
	}

	/*
	 * 处理<GET> 请求方法.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 利用hibernate查询热点博客和最新文章
		DbOperate db = new DbOperate();
		List blogList = db.getBlogs(10);
		List artileList = db.getArticles(10);

		// 设置输出信息的格式及字符集
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		// 创建输出流对象
		PrintWriter out = response.getWriter();
		// 依据验证结果输出不同的数据信息
		out.println("<response>");
		/*
		 * 输出热点博客
		 */
		Blog curBlog = null;
		for (int i = 0; i < blogList.size(); i++) {
			curBlog = (Blog) blogList.get(i);
			out.println("<blog>");
			out.println("<id>" + curBlog.getId() + "</id>");
			out.println("<name>" + curBlog.getSubject() + "</name>");
			out.println("</blog>");
		}
		/*
		 * 输出最新文章
		 */
		Article curArticle = null;
		for (int i = 0; i < artileList.size(); i++) {
			curArticle = (Article) artileList.get(i);
			out.println("<article>");
			out.println("<id>" + curArticle.getId() + "</id>");
			out.println("<title>" + curArticle.getTitle() + "</title>");
			out.println("<time>" + curArticle.getPubtime() + "</time>");
			out.println("</article>");
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
