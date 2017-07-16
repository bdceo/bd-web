package com.bdsoft.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bdsoft.global.utils.DB;

public class DwrDao {
	
	public boolean check(String username) {
		System.out.println("jsp����4��ֵ��" + username);
		boolean exist = false;
		Connection con = null;
		ResultSet rs = null;
		try {
			con = DB.getMySqlConn();
			String sql = "select * from ruser where username='" + username
					+ "'";
			Statement st=DB.getStatement(con);
			rs = DB.getResultSet(st, sql);
			while (rs.next()) {
				exist = true;
			}
		} catch (Exception e) { 
			e.printStackTrace();
		} finally {
			DB.close(con);
			DB.close(rs);
		}
		System.out.println("�����˷��أ�"+exist);
		return exist;
	}
}
