package com.bdsoft.web2p0.ch26;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonManager {

	public PersonManager() {
	}

	public boolean addPerson(ListForm listForm) throws SQLException {
		ConnectBean db;
		boolean check;
		String sql;
		db = new ConnectBean();
		check = false;
		sql = (new StringBuilder(
				"insert into person(name,sex,work,address) values('")).append(
				listForm.getName()).append("','").append(listForm.getSex())
				.append("','").append(listForm.getWork()).append("','").append(
						listForm.getAddress()).append("')").toString();
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			check = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return check;
	}

	public boolean delPerson(ListForm listForm) throws SQLException {
		ConnectBean db;
		boolean check;
		String sql;
		db = new ConnectBean();
		check = false;
		sql = (new StringBuilder("delete from person where id=")).append(
				listForm.getId()).toString();
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			check = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return check;
	}

	public boolean delAll() throws SQLException {
		ConnectBean db;
		boolean check;
		String sql;
		db = new ConnectBean();
		check = false;
		sql = "delete from person";
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			check = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return check;
	}

	public List getList() throws SQLException {
		ConnectBean db;
		List list;
		String sql;
		db = new ConnectBean();
		list = new ArrayList();
		sql = "select id,name,sex,work,address from person  order by id";
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			Person bean;
			for (ResultSet rs = stmt.executeQuery(sql); rs.next(); list
					.add(bean)) {
				bean = new Person();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setSex(rs.getString(3));
				bean.setWork(rs.getString(4));
				bean.setAddress(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	public List searchList(String name) throws SQLException {
		ConnectBean db;
		List list;
		String sql;
		db = new ConnectBean();
		list = new ArrayList();
		sql = "select id,name,sex,work,address from person where name like '%"
				+ name + "%' order by id";
		try {
			Connection con = db.getConnection();
			Statement stmt = con.createStatement();
			Person bean;
			for (ResultSet rs = stmt.executeQuery(sql); rs.next(); list
					.add(bean)) {
				bean = new Person();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setSex(rs.getString(3));
				bean.setWork(rs.getString(4));
				bean.setAddress(rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
}