package com.bdsoft.web2p0.ch10;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.global.utils.DB;

public class SearchSuggest extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("search");
		//System.out.println(key);
		String sql = "select * from suggest where title like '" + key
				+ "%' order by title";
		Connection con = DB.getMySqlConn();
		Statement stmt = DB.getStatement(con);
		ResultSet rs = DB.getResultSet(stmt, sql);
		Vector vector = new Vector();
		PrintWriter out = response.getWriter();
		try {
			while (rs.next()) {
				vector.add(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer buf = new StringBuffer();
		int size = vector.size();
		for (int i = 0; i < size; i++) {
			String sug = (String) vector.get(i);
			buf.append(sug+"\n");
		}
		out.print(buf.toString());
		out.flush();
		out.close();
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
