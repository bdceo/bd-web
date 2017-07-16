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

public class OpenArticleAction extends HttpServlet {

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
		String articleId = request.getParameter("articleid");
		HttpSession session = request.getSession(true);
		int iArticleId = Integer.parseInt(articleId);
		/*
		 * 保存文章对象及BlogID
		 */
		DbOperate db = new DbOperate();
		Article article = db.getArticle(iArticleId);
		int iBlogId = article.getBlogid();
		session.setAttribute(Constants.CUR_ARTICLE_KEY, article);
		session.setAttribute(Constants.CUR_BLOGID_KEY, new Integer(iBlogId));

		/*
		 * 左侧框架页信息设置
		 */
		Blog blog = db.getBlog(iBlogId);
		blog.setVisitcount(blog.getVisitcount() + 1);
		db.update(blog);
		session.setAttribute(Constants.VISIT_BLOG_KEY, blog);

		List sortList = db.getBlogSorts(iBlogId);
		session.setAttribute(Constants.SORT_LIST_KEY, sortList);

		List linkList = db.getBlogLinks(iBlogId);
		session.setAttribute(Constants.LINK_LIST_KEY, linkList);

		List feedBackList = db.getFeedBacks(iArticleId);
		/*
		 * 分页显示
		 */
		List dispList = new ArrayList();
		for (int i = 0; i < feedBackList.size(); i++) {
			if (i < Constants.ARTICLE_PAGE_SIZE) {
				dispList.add(feedBackList.get(i));
			}
		}
		session.setAttribute(Constants.FEEDBACK_LIST_KEY, dispList);
		session.setAttribute(Constants.CUR_PAGEID_KEY, new Integer(0));
		response.sendRedirect("/web2p0/ch21/otherBlogMain.jsp");

	}

}
