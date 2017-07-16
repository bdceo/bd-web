package com.bdsoft.zhkf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateTip extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����һ����Ʒ�б�
		String[][] shop ={{"��Ʒһ","90","photo/photo1.jpg"},
						  {"��Ʒ��","190","photo/photo2.jpg"},
						  {"��Ʒ��","290","photo/photo3.jpg"}	}; 
		
		//��ÿͻ����ύ�Ĳ���
		int index =Integer.parseInt(request.getParameter("index"));
		
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//��XML�ĵ���ʽ���ظ�ͻ���
		out.println("<shop>");
		out.println("<name>"+shop[index][0]+"</name>");
		out.println("<price>"+shop[index][1]+"</price>");
		out.println("<photo>"+shop[index][2]+"</photo>");
		out.println("</shop>");		

		out.flush();
		out.close();
	}

}
