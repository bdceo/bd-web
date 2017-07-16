package com.bdsoft.web2p0.ch15;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TreeviewServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parentID = request.getParameter("parent");// 获得id的值
		if (parentID != null && !parentID.equals(""))// 如果不为null和空
		{
			Category category = new Category(Integer.parseInt(parentID));// 创建Category对象
			TreeviewElement[] top = category.getChildren();// 得到该分类的所有下级分类
			response.setContentType("text/html");
			java.io.PrintWriter out = response.getWriter();
			for (int i = 0; i < top.length; i++)
				// 循环显示每个分类
				out.println(TreeviewRender.renderTreeViewAjax(top[i], false));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
