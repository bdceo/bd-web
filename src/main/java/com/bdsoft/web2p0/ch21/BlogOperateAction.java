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

public class BlogOperateAction extends HttpServlet {

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
		String sortId = request.getParameter("sortid");
		String pageId = request.getParameter("pageid");

		HttpSession session = request.getSession(true);
		int iBlogId = 0;
		DbOperate db = new DbOperate();
		if (blogId != null) {
			iBlogId = Integer.parseInt(blogId);
			Blog blog = db.getBlog(iBlogId);
			session.setAttribute(Constants.VISIT_BLOG_KEY, blog);
		} else {
			Blog blog = (Blog) session.getAttribute(Constants.VISIT_BLOG_KEY);
			iBlogId = blog.getId();
		}

		int iSortId = 0;
		if (sortId != null) {
			iSortId = Integer.parseInt(sortId);
			session
					.setAttribute(Constants.CUR_SORTID_KEY,
							new Integer(iSortId));
		} else {
			Integer temp = (Integer) session
					.getAttribute(Constants.CUR_SORTID_KEY);
			iSortId = temp.intValue();
		}

		/*
		 * 页号处理
		 */
		int iPageId = 0;
		int pageCount = 0;
		List articleList = db.getBlogArticles(iBlogId, iSortId);
		if (pageId != null) {
			iPageId = Integer.parseInt(pageId);
			if (iPageId < 0)
				iPageId = 0;
			/*
			 * 获取总页数
			 */
			if (articleList.size() % Constants.ARTICLE_PAGE_SIZE == 0) {
				pageCount = articleList.size() / Constants.ARTICLE_PAGE_SIZE;
			} else {
				pageCount = articleList.size() / Constants.ARTICLE_PAGE_SIZE
						+ 1;
			}
			if (iPageId >= pageCount)
				iPageId = pageCount - 1;
			session
					.setAttribute(Constants.CUR_PAGEID_KEY,
							new Integer(iPageId));
		} else {
			Integer temp = (Integer) session
					.getAttribute(Constants.CUR_PAGEID_KEY);
			iPageId = temp.intValue();
		}

		/*
		 * 分页显示
		 */
		List dispList = new ArrayList();
		if ((articleList.size() > iPageId * Constants.ARTICLE_PAGE_SIZE)
				&& (iPageId >= 0)) {
			for (int i = iPageId * Constants.ARTICLE_PAGE_SIZE; i < (iPageId + 1)
					* Constants.ARTICLE_PAGE_SIZE; i++) {
				if (i < articleList.size()) {
					dispList.add(articleList.get(i));
				}
			}
		}
		session.setAttribute(Constants.ARTICLE_LIST_KEY, dispList);
		response.sendRedirect("/web2p0/ch21/main.jsp");

	}

}
