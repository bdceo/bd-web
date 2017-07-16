package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WriteFeedbackAction extends HttpServlet {

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
		String uname = request.getParameter("uname");
		String content = request.getParameter("content");

		HttpSession session = request.getSession(true);
		Article article = (Article) session
				.getAttribute(Constants.CUR_ARTICLE_KEY);

		/*
		 * 保存至数据库
		 */
		DbOperate db = new DbOperate();

		FeedBack feedBack = new FeedBack();
		feedBack.setUname(uname);
		feedBack.setContent(content);
		SimpleDateFormat df = new SimpleDateFormat("MMddhhmmss");
		df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		feedBack.setPubtime(df.format(new Date()));
		feedBack.setArticleid(article.getId());
		db.save(feedBack);
		response.sendRedirect("/showFeedback?articleid=" + article.getId()
				+ "&pageid=0");

	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO 自动生成方法存根
		this.doGet(arg0, arg1);
	}
}
