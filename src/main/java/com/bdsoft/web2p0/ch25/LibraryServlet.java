package com.bdsoft.web2p0.ch25;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LibraryServlet extends HttpServlet {
	
	private Hashtable titles;
	final private String ID = "计算机";

	public void init() {
		this.populateTitles();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 设置接收信息的字符集
		req.setCharacterEncoding("UTF-8");
		String option = null;
		String key = null;
		String[] list = null;
		String xmlString = null;
		String ID = null;

		option = req.getParameter("select");
		key = req.getParameter("list");
		ID = req.getParameter("subscriptionID");

		if (option != null) {
			if (option.equals("author")) {
				list = this.populateAuthors();
				xmlString = this.getXMLData(list);
				//System.out.println(xmlString);
				this.writeResponse(resp, xmlString);
				//return;
			} else if (option.equals("pubs")) {
				list = this.populatePubs();
				xmlString = this.getXMLData(list);
				//System.out.println(xmlString);
				this.writeResponse(resp, xmlString);
				//return;
			}
		}

		if (key != null) {
			list = this.getTitle(key);
			xmlString = this.getXMLData(list);
			this.writeResponse(resp, xmlString);
			//return;
		}

		if (ID != null) {
			String status = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
					+ "<message>" + this.validID(ID) + "</message>";
			this.writeResponse(resp, status);
		//	return;
		}
	}

	public void writeResponse(HttpServletResponse resp, String output)
			throws IOException {
		resp.setHeader("Content-Type", "text/xml;charset=UTF-8");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		resp.getWriter().write(output);
	}

	public String[] getTitle(String key) {
		return (String[]) titles.get(key);

	}

	private String[] populateAuthors() {
		String[] authors = new String[7];
		authors[0] = "---";
		authors[1] = "Bruce Eckel";
		authors[2] = "孙卫琴";
		authors[3] = "Steve McConnell";
		authors[4] = "潘爱民";
		authors[5] = "戴尔卡耐基";
		authors[6] = "张素琴";

		return authors;
	}

	private String getXMLData(String[] data) {
		String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xmlString = xmlString + "<root>";
		xmlString = xmlString + "<index>" + data.length + "</index>";
		for (int i = 0; i < data.length; i++) {
			xmlString = xmlString + "<list>" + data[i] + "</list>";
		}
		xmlString = xmlString + "</root>";

		return xmlString;
	}

	private String[] populatePubs() {
		String[] pubs = new String[5];
		pubs[0] = "---";
		pubs[1] = "机械工业出版社";
		pubs[2] = "电子工业出版社";
		pubs[3] = "当代世界出版社";
		pubs[4] = "清华大学出版社";

		return pubs;
	}

	private void populateTitles() {
		titles = new Hashtable();
		titles.put("A0", new String[] { "** blank **" });
		titles.put("A1", new String[] { "Java编程思想" });
		titles.put("A2", new String[] { "精通Hibernate" });
		titles.put("A3", new String[] { "代码大全" });
		titles.put("A4", new String[] { "深入解析Windows操作系统" });
		titles.put("A5", new String[] { "人性的弱点" });
		titles.put("A6", new String[] { "编译原理" });

		titles.put("P0", new String[] { "&nbsp;" });
		titles.put("P1", new String[] { "Java编程思想" });
		titles.put("P2", new String[] { "精通Hibernate", "代码大全",
				"深入解析Windows操作系统" });
		titles.put("P3", new String[] { "人性的弱点" });
		titles.put("P4", new String[] { "编译原理" });
	}

	private boolean validID(String ID) {
		if (this.ID.equals(ID)) {
			return true;
		}

		return false;

	}

}
