package com.bdsoft.zhkf.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.*;
import java.io.*;

public class YahooSearch extends HttpServlet {

	public YahooSearch() {
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

		//����Yahoo������Web Service�ķ���URL�Ļ���
		String baseUrl = "http://api.search.yahoo.com/WebSearchService/V1/webSearch?appid=YahooDemo&ei=UTF-8&type=all";
		//��ÿͻ��Ĳ�ѯ�ؼ���
		String query = request.getParameter("query");
		//��query�����ת��
		query = new String(query.getBytes("ISO8859-1"),"gb2312");
		//��query��URL����
		query = URLEncoder.encode(query,"UTF-8");
		//������ѯ�ؼ��ֲ���
		query = "&query="+query;
		//��ÿͻ��ļ�¼��
		String results = request.getParameter("results");
		//������¼�����
		results = "&results="+results;	
		//����������URL
		String url = baseUrl+query+results;
		//��bһ��HttpURLConnection�����������
		HttpURLConnection con = (HttpURLConnection)new URL(url).openConnection();
		//����HttpURLConnection����ķ��ʷ���
		con.setRequestMethod("GET");
		
		//����ѯ�Ľ����XML�ĵ����ظ�ͻ���
		response.setContentType("text/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//��bһ��BufferedReader�����ȡ��ѯ���
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line = null;
		//һ��һ�еض�ȡ��ѯ���
		while ((line = reader.readLine())!=null){
			//�Զ�ȡ����ݽ��б���ת��
			line = new String(line.getBytes(),"UTF-8");
			out.println(line);
		}
		out.flush();
		out.close();
	}

	public void init() throws ServletException {}

}
