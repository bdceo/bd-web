package com.bdsoft.web2p0.ch11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SelectCityServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf8");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		String state = request.getParameter("state");
		Document doc = DocumentHelper.createDocument();
		Element root = doc.addElement("state");

		Element city = null;
		if ("hn".equals(state)) {
			city = root.addElement("city");
			city.setName("长沙");
			city = root.addElement("city");
			city.setText("常德");
			city = root.addElement("city");
			city.setText("益阳");
			city = root.addElement("city");
			city.setText("株洲");
			city = root.addElement("city");
			city.setText("怀化");
			city = root.addElement("city");
			city.setText("张家界");
		} else {
			city = root.addElement("city");
			city.setText("武汉");
			city = root.addElement("city");
			city.setText("沙市");
			city = root.addElement("city");
			city.setText("宜昌");
		}

		PrintWriter out = response.getWriter();
		String s = doc.asXML();
		out.write(s);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
