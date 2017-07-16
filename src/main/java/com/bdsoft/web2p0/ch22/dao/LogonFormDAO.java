package com.bdsoft.web2p0.ch22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdsoft.web2p0.ch22.base.DBConnection;
import com.bdsoft.web2p0.ch22.struts.form.LogonForm;

public class LogonFormDAO {
	protected DBConnection conn = new DBConnection();

	public boolean checkUser(LogonForm lf) {
		boolean validate = false;
		String name = lf.getUserName();
		String pwd = lf.getPassWord();
		String sql = "select * from administrator where username='" + name
				+ "' and passwd='" + pwd + "'";
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				validate = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return validate;
	}
}
