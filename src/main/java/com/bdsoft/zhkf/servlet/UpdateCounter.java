package com.bdsoft.zhkf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

public class UpdateCounter extends HttpServlet {

	public UpdateCounter() {
		super();
	}

	public void destroy() {
		super.destroy(); 

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Random rnd = new Random();//����һ�����������
		//�������ؿͻ��˵�ͳ�����XML�ĵ�
		out.println("<response>");
		//��������������Ϊʵʱͳ�����
		for (int i=0;i<6;i++){
			out.println("<counter>"+rnd.nextInt(100)+"</counter>");
		}
		out.println("</response>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {}

}
