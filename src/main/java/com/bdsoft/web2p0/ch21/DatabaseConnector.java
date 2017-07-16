package com.bdsoft.web2p0.ch21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {

	Connection conn;
	Statement stmt;

	public DatabaseConnector() {
		initConnection();
	}

	public DatabaseConnector(Connection conn) {
		this.conn = conn;
	}

	private void initConnection() {
		try {
			if (conn == null) {
				String url = "jdbc:mysql://127.0.0.1/test?user=root&password=root&useUnicode=true&characterEncoding=UTF-8";

				Class.forName("com.mysql.jdbc.Driver").newInstance();

				conn = DriverManager.getConnection(url);

			}
		} catch (Exception ex) {
			System.out.println("Can not get new Connection" + ex.getMessage());
		}
	}

	public PreparedStatement getPreparedStmt(String sql) throws SQLException {
		PreparedStatement preStmt = null;
		try {
			preStmt = conn.prepareStatement(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		}
		return preStmt;
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("dbTrans.executeQuery:" + ex.getMessage());
			throw ex;
		}
		return rs;
	}

	public void executeUpdate(String sql) throws SQLException {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("dbTrans.executeUpdate:" + ex.getMessage());
			throw ex;
		}
	}

	public void close() throws SQLException {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Closeing connection fail" + ex.getMessage());
			throw ex;
		}
	}

}