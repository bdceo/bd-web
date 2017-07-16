package com.bdsoft.zhkf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateXML extends HttpServlet {

	public CreateXML() {
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
		String selected = request.getParameter("selected");
		PrintWriter out = response.getWriter();
		out.println("<response>");
		//����ֱ�Ϊ}��ʡ�ݴ�������
		if (selected.equals("1")){//���ѡ����ǡ�����ʡ��
			out.println("<city>");
			out.println("<cityname>��ɳ</cityname>");
			out.println("<cityvalue>1</cityvalue>");
			out.println("</city>");
			out.println("<city>");
			out.println("<cityname>¦��</cityname>");
			out.println("<cityvalue>2</cityvalue>");
			out.println("</city>");
			out.println("<city>");
			out.println("<cityname>����</cityname>");
			out.println("<cityvalue>3</cityvalue>");
			out.println("</city>");
		}else{//���ѡ����ǡ��㶫ʡ��
			out.println("<city>");
			out.println("<cityname>����</cityname>");
			out.println("<cityvalue>1</cityvalue>");
			out.println("</city>");
			out.println("<city>");
			out.println("<cityname>����</cityname>");
			out.println("<cityvalue>2</cityvalue>");
			out.println("</city>");
			out.println("<city>");
			out.println("<cityname>��ɽ</cityname>");
			out.println("<cityvalue>3</cityvalue>");
			out.println("</city>");
		}
		out.println("</response>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {}

}
