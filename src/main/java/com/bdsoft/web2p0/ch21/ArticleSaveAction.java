package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ArticleSaveAction extends HttpServlet {

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
		String title = request.getParameter("title");
		String sortid = request.getParameter("sortid");
		String content = request.getParameter("content");
		int iSortId = 0;
		if (sortid != null) {
			iSortId = Integer.parseInt(sortid);
		}

		DbOperate db = new DbOperate();
		/*
		 * 获取Blog信息
		 */
		HttpSession session = request.getSession(true);
		Blog blog = (Blog) session.getAttribute(Constants.LOGIN_USER_KEY);

		/*
		 * 设置保存文章信息
		 */
		Article article = new Article();
		article.setTitle(title);
		article.setSortid(iSortId);
		article.setBlogid(blog.getId());
		article.setContent(content);
		SimpleDateFormat df = new SimpleDateFormat("MMddhhmmss");
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		article.setPubtime(df.format(new Date()));
		db.save(article);

		/*
		 * 返回结果信息
		 */
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		// 创建输出流对象
		PrintWriter out = response.getWriter();
		out.println("发表成功！");
		out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO 自动生成方法存根
		this.doGet(arg0, arg1);
	}

}
