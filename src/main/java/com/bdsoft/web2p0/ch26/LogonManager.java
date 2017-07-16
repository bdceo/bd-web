package com.bdsoft.web2p0.ch26;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogonManager {

	public LogonManager() {
	}

	public boolean logonSys(LogonForm LogonForm) throws SQLException {
		ConnectBean db;
		boolean check;
		String sql;
		db = new ConnectBean();
		check = false;
		sql = "select * from admin  where name='"
				+ (String) LogonForm.getName() + "' and password='"
				+ (String) LogonForm.getPwd() + "'";
		;
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next())
				check = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return check;
	}
}