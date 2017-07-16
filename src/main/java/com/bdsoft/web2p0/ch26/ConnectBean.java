package com.bdsoft.web2p0.ch26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectBean {
	public ConnectBean() {
		con = null;
		getConn();
	}

	public Connection getConnection() {
		return con;
	}

	public void getConn() {
		String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8";
		String DBDriver = "org.gjt.mm.mysql.Driver";
		String username = "root";
		String password = "root";
		try {
			Class.forName(DBDriver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			Close_DBConnection();
		} catch (SQLException e) {
			System.out.println(e);
			Close_DBConnection();
		}
	}

	public void Close_DBConnection() {
		if (con != null)
			try {
				con.close();
			} catch (Exception ex) {
				System.out.println(ex);
			}
	}

	Connection con;
}