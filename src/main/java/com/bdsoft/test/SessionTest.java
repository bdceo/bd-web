package com.bdsoft.test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionTest extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		session.setAttribute("list", list);
		//�������session���Ժ��������е���ݸ��¶���Ӱ�쵽session�е�ֵ
		//����Ҳ�������˴����ִ��Ч��
		list.add("cc");
		list.add("dd");
		
		List liss=(List)session.getAttribute("list");
		for(int i=0;i<liss.size();i++){
			System.out.println(list.get(i));//��ӡaabbccdd
		}		
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
