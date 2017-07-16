package com.bdsoft.web2p0.ch27.bean;

import java.sql.*;

import java.util.*;

public class ConnectBean {
	private Connection conn = null;
	private ResultSet res = null;
	private java.sql.PreparedStatement prepar = null;
	// private java.sql.CallableStatement proc = null;
	public static int PAGECOUNT;

	public ConnectBean() {
		try {
			conn = DriverManager.getConnection("proxool.DatabasePool");
			// System.out.println("��ݿ�l�ӳɹ���");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public UserBean checkUsersLogin(String userName, String userPwd) {
		UserBean ub = null;
		if (!checkParameter(userName + userPwd)) {
			userName = "null";
			userPwd = "null";
		}
		try {
			String sql = "select count(*) from admin where userName=? and userPwd=?";
			prepar = conn.prepareStatement(sql);
			prepar.setString(1, userName);
			prepar.setString(2, userPwd);
			res = prepar.executeQuery();
			if (res.next()) {
				if (res.getInt(1) > 0) {
					ub = this.getUser(userName);
				} else {
					ub = null;
				}
			}
		} catch (Exception e) {
			ub = null;
			e.printStackTrace();
		}
		return ub;
	}

	public UserBean getUser(String userName) {
		UserBean ub = new UserBean();
		String sql = "select * from admin where userName=?";
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setString(1, userName);
			res = prepar.executeQuery();
			while (res.next()) {
				ub.setUserName(res.getString("userName"));
				ub.setUserPwd(res.getString("userPwd"));
				ub.setUserId(res.getLong("userId"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return ub;
	}

	public boolean checkParameter(String para) {
		int flag = 0;
		flag += para.indexOf("'") + 1;
		flag += para.indexOf(";") + 1;
		flag += para.indexOf("1=1") + 1;
		flag += para.indexOf("|") + 1;
		flag += para.indexOf("<") + 1;
		flag += para.indexOf(">") + 1;
		if (flag != 0) {
			// System.out.println("�ύ�˷Ƿ��ַ�!!!");
			return false;
		}
		return true;
	}

	public ArrayList selectCDBean(String selectValue, int page, int count) {
		ArrayList list = new ArrayList();
		if (!checkParameter(selectValue)) {
			selectValue = "";
		}
		int start = (page - 1) * count;
		int end = page * count - 1;
		String sql = "select * from musicinfo where CDname like '%"
				+ selectValue + "%' limit " + start + "," + end;
		// System.out.println(sql);
		try {
			prepar = conn.prepareStatement(sql);
			res = prepar.executeQuery();
			while (res.next()) {
				ProductBean cb = new ProductBean();
				cb.setCdAlbum(res.getString("CDalbum"));
				cb.setCdCompany(res.getString("CDcompany"));
				cb.setCdName(res.getString("CDname"));
				cb.setCdId(res.getLong("CDid"));
				cb.setCdType(getMusicType(res.getInt("CDtypeId")));
				list.add(cb);
			}
			PAGECOUNT = 10;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public String getMusicType(int cdtypeId) {
		try {

			java.sql.PreparedStatement prepar1 = conn
					.prepareStatement("select display from musictype where CDtypeId=?");
			prepar1.setLong(1, cdtypeId);
			ResultSet res1 = prepar1.executeQuery();
			res1.next();
			return res1.getString("display");
		} catch (SQLException ex) {
			return null;
		}

	}

	public boolean setMusicBean(ProductBean cb) {
		if (!checkParameter(cb.getCdName() + cb.getCdCompany()
				+ cb.getCdAlbum() + cb.getCdType())) {
			return false;
		}
		boolean flag = false;
		String sql = "update musicinfo set CDname=?,CDcompany=?,CDalbum=?,CDtypeId=? where CDid=?";
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setString(1, cb.getCdName());
			prepar.setString(2, cb.getCdCompany());
			prepar.setString(3, cb.getCdAlbum());
			prepar.setInt(4, Integer.parseInt(cb.getCdType()));
			prepar.setLong(5, cb.getCdId());
			int result = prepar.executeUpdate();
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public ProductBean getMusicBean(long id) {

		ProductBean cb = new ProductBean();
		String sql = "select * from musicinfo where CDid=?";
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setLong(1, id);
			res = prepar.executeQuery();
			while (res.next()) {
				cb.setCdAlbum(res.getString("CDalbum"));
				cb.setCdCompany(res.getString("CDcompany"));
				cb.setCdName(res.getString("CDname"));
				cb.setCdId(res.getLong("CDid"));
				cb.setCdType(getMusicType(res.getInt("CDtypeId")));

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cb;
	}

	public boolean deleteMusicBean(long id) {
		boolean flag = false;
		String sql = "delete from musicinfo where CDid=?";
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setLong(1, id);
			int result = prepar.executeUpdate();
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean addMusicBean(ProductBean cb) {
		boolean flag = false;
		if (!checkParameter(cb.getCdName() + cb.getCdCompany()
				+ cb.getCdAlbum() + cb.getCdType())) {
			return false;
		}
		String sql = "insert into musicinfo(CDname,CDcompany,CDalbum,CDtypeId) values(?,?,?,?)";
		try {
			this.prepar = conn.prepareStatement(sql);
			prepar.setString(1, cb.getCdName());
			prepar.setString(2, cb.getCdCompany());
			prepar.setString(3, cb.getCdAlbum());
			prepar.setInt(4, Integer.parseInt(cb.getCdType()));
			int result = prepar.executeUpdate();
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean setUserBean(UserBean ub) {
		boolean flag = false;
		String sql = "update admin set userPwd=? where userId=?";
		try {
			if (!checkParameter(ub.getUserPwd())) {
				return false;
			}
			this.prepar = conn.prepareStatement(sql);
			prepar.setString(1, ub.getUserPwd());
			prepar.setLong(2, ub.getUserId());
			int result = prepar.executeUpdate();
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean addUserBean(UserBean ub) {
		boolean flag = false;
		String sql = "insert into admin values(?,?)";
		if (!checkParameter(ub.getUserPwd() + ub.getUserName())) {
			return false;
		}
		if (hasUser(ub.getUserName())) {
			return false;
		}
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setString(1, ub.getUserName());
			prepar.setString(2, ub.getUserPwd());
			int result = prepar.executeUpdate();
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (Exception ex) {
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	public boolean hasUser(String userName) {
		boolean flag = true;
		String sql = "select count(*) from admin where userName=?";
		try {
			prepar = conn.prepareStatement(sql);
			prepar.setString(1, userName);
			res = prepar.executeQuery();
			res.next();
			int result = res.getInt(1);
			if (result > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			flag = true;
		}

		return flag;
	}

	public void Close() {
		try {
			if (res != null) {
				res.close();
			}
			if (prepar != null) {
				prepar.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// System.out.println("��ݿ�t�ӹرճɹ���");
	}
}
