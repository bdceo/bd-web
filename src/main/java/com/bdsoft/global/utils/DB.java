package com.bdsoft.global.utils;

import java.sql.*;

public class DB {
	private static final String USERNAME = "sa";
	private static final String PWD = "jjjjjj";

	// private static final String URL =
	// "jdbc:oracle:thin:@192.168.0.50:1521:jdi";
	// private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

	private static final String M_URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String M_DRIVER = "com.mysql.jdbc.Driver";

	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databasename=traindata";
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getMySqlConn() {
		Connection conn = null;
		try {
			Class.forName(M_DRIVER);
			conn = DriverManager.getConnection(M_URL, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		DB.getConn();
	}

	public static PreparedStatement prepare(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			if (conn != null) {
				pstmt = conn.prepareStatement(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public static PreparedStatement prepare(Connection conn, String sql,
			int autoGenereatedKeys) {
		PreparedStatement pstmt = null;
		try {
			if (conn != null) {
				pstmt = conn.prepareStatement(sql, autoGenereatedKeys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			if (conn != null) {
				stmt = conn.createStatement();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	/*
	 * public static ResultSet getResultSet(Connection conn, String sql) {
	 * Statement stmt = getStatement(conn); ResultSet rs = getResultSet(stmt,
	 * sql); close(stmt); return rs; }
	 */

	public static ResultSet getResultSet(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			if (stmt != null) {
				rs = stmt.executeQuery(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public static void executeUpdate(Statement stmt, String sql) {
		try {
			if (stmt != null) {
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
