package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OpenBlogAction extends HttpServlet {

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
		String blogId = request.getParameter("blogid");
		int iBlogId = Integer.parseInt(blogId);

		/*
		 * 左侧框架页信息设置
		 */
		HttpSession session = request.getSession(true);
		DbOperate db = new DbOperate();

		Blog blog = db.getBlog(iBlogId);
		blog.setVisitcount(blog.getVisitcount() + 1);
		db.update(blog);
		session.setAttribute(Constants.VISIT_BLOG_KEY, blog);

		List sortList = db.getBlogSorts(iBlogId);
		session.setAttribute(Constants.SORT_LIST_KEY, sortList);

		List linkList = db.getBlogLinks(iBlogId);
		session.setAttribute(Constants.LINK_LIST_KEY, linkList);

		List articleList = db.getBlogArticles(iBlogId, 0);
		/*
		 * 分页显示
		 */
		List dispList = new ArrayList();
		for (int i = 0; i < articleList.size(); i++) {
			if (i < Constants.ARTICLE_PAGE_SIZE) {
				dispList.add(articleList.get(i));
			}
		}
		session.setAttribute(Constants.ARTICLE_LIST_KEY, dispList);
		session.setAttribute(Constants.CUR_PAGEID_KEY, new Integer(0));
		session.setAttribute(Constants.CUR_SORTID_KEY, new Integer(0));

		response.sendRedirect("/web2p0/ch21/blogMain.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
