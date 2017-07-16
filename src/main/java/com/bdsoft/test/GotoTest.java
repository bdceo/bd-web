package com.bdsoft.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GotoTest extends HttpServlet {
	
	//��תURL���ԣ�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//forward()��ת
		
		
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
