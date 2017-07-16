package com.bdsoft.web2p0.ch12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestA extends HttpServlet {

	public static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");

		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/xml;charset=utf-8");

		PrintWriter out = response.getWriter();

		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from User as u where u.name=:username");
		query.setString("username", name);
		List list = query.list();
		System.out.println("查询结果：" + list.size());
		out.println("<pront>");
		if (list.size() != 0) {
			out.println("<content>" + "对不起，此网名已注册！" + "</content>");
		} else {
			out.println("<content>" + "此网名可以注册！" + "</content>");
		}
		out.println("</pront>");

		out.flush();
		out.close();
		session.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
