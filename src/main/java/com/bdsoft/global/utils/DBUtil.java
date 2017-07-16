package com.bdsoft.global.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 

public class DBUtil {
	
	private static final String IP = "10.88.0.23";
	private static final String PORT = "50000";
	private static final String DB = "db_dcs";
	private static final String UNAME = "db2inst1";
	private static final String PWD = "zldb2inst1";
	
	public static Connection getCon() throws Exception {
		Connection con = null;
		Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
		String url = "jdbc:db2://" + IP + ":" + PORT + "/" + DB;
		con = DriverManager.getConnection(url, UNAME, PWD);
		return con;
	}

	// 获取指定序列的下一个值
	public static String nextVal(String sequence, Connection con)
			throws Exception {
		String next = "";
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select nextval for " + sequence
					+ " from sysibm.sysdummy1");
			while (rs.next()) {
				next = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		}
		return next;
	}
}