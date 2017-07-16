package com.bdsoft.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBean {
	private int id;

	private String name;

	private Connection con;

	private PreparedStatement ps;

	private ResultSet rs;

	public Connection getCon() {
		Connection conn;
		try {
			// 1��SqlServer ��ݿ�l�ӳ�:
			// Context ct = new InitialContext();
			// DataSource dc = (DataSource)
			// ct.lookup("java:comp/env/jdbc/test");
			// conn = dc.getConnection();

			// 2��Ĭ��ʹ�������ļ�l�ӣ�proxool��
			// driverClass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
			// urll="jdbc:sqlserver://localhost:1433;DatabaseName=test";
			conn = DriverManager.getConnection("proxool.dglabour");

			// 3��Mysql��ݿ�l�Ӳ���:
			// Class.forName("com.mysql.jdbc.Driver");
			// conn = DriverManager.getConnection(
			// "jdbc:mysql://localhost:3306/test", "root", "root");

			// 4��Oracle��ݿ�l�Ӳ��ԣ�
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			// conn = DriverManager.getConnection(
			// "jdbc:oracle:thin:@192.168.0.102:1521:jdi", "scott",
			// "tiger");
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return conn;
	}

	public void CloseAll() {
		try {
			if (con != null) {
				con.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * �ж��û���¼
	 */
	public int Login(String uid, String pwd) {
		int i = 0;
		try {
			con = this.getCon();
			ps = con
					.prepareStatement("select * from login where uid=? and pwd=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
		return i;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
