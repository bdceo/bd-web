package com.bdsoft.web2p0.ch21;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminSortAction extends HttpServlet {
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
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String id = request.getParameter("id");

		HttpSession session = request.getSession(true);
		Blog blog = (Blog) session.getAttribute(Constants.LOGIN_USER_KEY);

		// 设置输出信息的格式及字符集
		response.setContentType("text/xml; charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		// 创建输出流对象
		PrintWriter out = response.getWriter();
		// 依据验证结果输出不同的数据信息
		out.println("<response>");
		/*
		 * 执行数据库操作并返回结果
		 */
		DbOperate db = new DbOperate();
		if ("load".equals(action)) {
			List sortList = db.getBlogSorts(blog.getId());
			for (int i = 0; i < sortList.size(); i++) {
				Sort sort = (Sort) sortList.get(i);
				out.println("<sort>");
				out.println("<id>" + sort.getId() + "</id>");
				out.println("<name>" + sort.getName() + "</name>");
				out.println("</sort>");
			}
		} else if ("add".equals(action)) {
			Sort sort = new Sort();
			sort.setName(name);
			sort.setBlogid(blog.getId());
			db.save(sort);
			out.println("<id>" + sort.getId() + "</id>");
			out.println("<name>" + sort.getName() + "</name>");
		} else if ("delete".equals(action)) {
			Sort sort = db.getSort(Integer.parseInt(id));
			db.delete(sort);
			out.println("<id>" + sort.getId() + "</id>");
		}
		out.println("</response>");
		out.close();
	}

	protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO 自动生成方法存根
		this.doGet(arg0, arg1);
	}

}
