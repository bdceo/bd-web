package com.bdsoft.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bdsoft.global.utils.DBUtil;

public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat();
		Date d = new Date();
		System.out.println(sdf.format(d));
		String sdate = "2008-01-01 08:30:59";
		Timestamp ts = new Timestamp(System.currentTimeMillis());// Timestamp.valueOf(sdate);
		System.out.println(ts + "\n----------------------------------");
		String sql = "insert into dt values(null,?,?)";
		Connection con = DBUtil.getCon();
		// ResultSet rs = DB.getRs(con, sql);
		PreparedStatement ps = con.prepareStatement(sql);
		try {
			ps.setString(1, "jdi");
			// ps.setTime(2, null);
			ps.setTimestamp(2, ts);
			ps.execute();
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ps.close();
			con.close();
		}
	}
}
