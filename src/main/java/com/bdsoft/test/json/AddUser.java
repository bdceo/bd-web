package com.bdsoft.test.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.json.JSONObject;
//
//import com.bdsoft.global.utils.JsonUtil;

public class AddUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		// ��ȡ�ͻ����ύ��JSON���
//		StringBuffer json = new StringBuffer();
//		String line = null;
//		BufferedReader reader = request.getReader();
//		while ((line = reader.readLine()) != null) {
//			// �Զ�ȡ����ݽ��б���ת��
//			line = new String(line.getBytes("ISO8859-1"), "UTF-8");
//			json.append(line);
//		}
//
//		// ��bһ�����˵�JSONObject�������ͻ��˵�JSON���
//		JSONObject jsonObj = null;
//		try {
//			jsonObj = new JSONObject(json.toString());
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}		
//		// ��JSONObject������ȡ�������ݽ��д���
//		String userName, password, department, headship, sex, old;
//		try {
//			userName = jsonObj.getString("userName").toUpperCase();
//			password = jsonObj.getString("password");
//			department = jsonObj.getString("department").toUpperCase();
//			headship = jsonObj.getString("headship").toUpperCase();
//			sex = jsonObj.getString("sex");
//			old = jsonObj.getString("old") + "��";
//			if (sex.equals("1")) {
//				userName = userName + "����";
//				sex = "��";
//			} else {
//				userName = userName + "Ůʿ";
//				sex = "Ů";
//			}
//			// ����������ݷ�װ��JSONObject����
//			// jsonObj.put("userName", userName);
//			// jsonObj.put("password", password);
//			// jsonObj.put("department", department);
//			// jsonObj.put("headship", headship);
//			// jsonObj.put("sex", sex);
//			// jsonObj.put("old", old);
//
//			// ���鷽ʽ
//			List us = new ArrayList();
//			jsonObj = new JSONObject();
//			for (int i = 0; i < 10; i++) {
//				Uu u = new Uu(userName + i, department + i, password + i,
//						headship + i, old + i, sex + i);
//				us.add(u);
//			}
//			// JSONArray ja = JsonUtil.collection2Json(us);
//			// jsonObj.put("uss", ja);
//
//			jsonObj.put("uss", JsonUtil.collection2Json(us));
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		// ��JSONObject����ת�����ַ�󷵻ؿͻ���
//		response.setContentType("text/html");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println(jsonObj.toString());
//		out.flush();
//		out.close();
	}
}


