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

public class ShowFeedbackAction extends HttpServlet {

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
		String pageId = request.getParameter("pageid");

		/*
		 * 文章编号处理
		 */
		HttpSession session = request.getSession(true);
		DbOperate db = new DbOperate();
		int iArticleId = 0;
		Article article = null;
		if (articleId != null) {
			iArticleId = Integer.parseInt(articleId);
			article = db.getArticle(iArticleId);
			session.setAttribute(Constants.CUR_ARTICLE_KEY, article);
		} else {
			article = (Article) session.getAttribute(Constants.CUR_ARTICLE_KEY);
			iArticleId = article.getId();
		}

		/*
		 * 页号处理
		 */
		int iPageId = 0;
		int pageCount = 0;

		List feedBackList = db.getFeedBacks(iArticleId);
		if (pageId != null) {
			iPageId = Integer.parseInt(pageId);
			if (iPageId < 0)
				iPageId = 0;
			/*
			 * 获取总页数
			 */
			if (feedBackList.size() % Constants.ARTICLE_PAGE_SIZE == 0) {
				pageCount = feedBackList.size() / Constants.ARTICLE_PAGE_SIZE;
			} else {
				pageCount = feedBackList.size() / Constants.ARTICLE_PAGE_SIZE
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
		if ((feedBackList.size() > iPageId * Constants.ARTICLE_PAGE_SIZE)
				&& (iPageId >= 0)) {
			for (int i = iPageId * Constants.ARTICLE_PAGE_SIZE; i < (iPageId + 1)
					* Constants.ARTICLE_PAGE_SIZE; i++) {
				if (i < feedBackList.size()) {
					dispList.add(feedBackList.get(i));
				}
			}
		}
		session.setAttribute(Constants.FEEDBACK_LIST_KEY, dispList);
		response.sendRedirect("/web2p0/ch21/feedback.jsp");
	}
}
