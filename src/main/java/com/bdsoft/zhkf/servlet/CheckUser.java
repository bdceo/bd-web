package com.bdsoft.zhkf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUser extends HttpServlet {

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, 
					  HttpServletResponse response)
					  throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, 
					   HttpServletResponse response)
			  		   throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//��������Ѿ�ע�������λ�û�
		String[] logined = {"admin","users","dywdyw","liubin"};
		//���մӿͻ����ύ��loginName����
		String loginName = request.getParameter("loginName");
		//����һ������Ӧ���ݵ��ַ�
		String responseContext = "true";
		for (int i=0;i<logined.length;i++){
			//������ע���û��б?������ύ��ע�����Ѵ��ڣ����޸���Ӧ����
			if (loginName.equals(logined[i]))responseContext = "false";
		}
		//��������ظ�ͻ���
		out.println(responseContext);
		out.flush();
		out.close();
	}

	public void init() throws ServletException {}

}
