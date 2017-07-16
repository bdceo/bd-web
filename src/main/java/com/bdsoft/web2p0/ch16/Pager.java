package com.bdsoft.web2p0.ch16;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class Pager extends HttpServlet {

	private static final int COUNTAPAGE = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 0;
		if (request.getParameter("currentPage") != null)
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// 获取书籍列表
		ServXml service = new ServXml();
		Collection results = new ArrayList();
		int totalPage = 0;
		try {
			Item[] newslist = service.getAllMessage();
			if ((newslist != null) && (newslist.length != 0)) {
				totalPage = (newslist.length % COUNTAPAGE == 0) ? (newslist.length / COUNTAPAGE)
						: (newslist.length / COUNTAPAGE + 1);
				if (currentPage <= 0)
					currentPage = 1;
				if (currentPage > totalPage)
					currentPage = totalPage;
				for (int i = ((currentPage - 1) * COUNTAPAGE); i < COUNTAPAGE
						* currentPage; i++) {
					if (i >= newslist.length)
						break;
					results.add(newslist[i]);
				}
			}
			// 输出为范式良好的XML文档
			response.setContentType("application/xml");
			Document doc = new Document();
			Element root = new Element("list");
			Element e_page = new Element("currentPage").addContent(String
					.valueOf(currentPage));
			root.addContent(e_page);
			Element e_total = new Element("totalPage").addContent(String
					.valueOf(totalPage));
			root.addContent(e_total);
			Element e_newslist = new Element("newslist");
			Iterator iterator = results.iterator();
			for (int i = 0; i < results.size(); i++) {
				Item news = (Item) iterator.next();
				Element e_news = new Element("news").setAttribute("id", news
						.getId());
				e_news.addContent(new Element("title").addContent(news
						.getTitle()));
				e_news.addContent(new Element("submittime").addContent(news
						.getAuthor()));
				e_newslist.addContent(e_news);
			}
			root.addContent(e_newslist);
			doc.addContent(root);
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()
					.setEncoding("ISO8859-1"));
			outputter.output(doc, response.getWriter());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
