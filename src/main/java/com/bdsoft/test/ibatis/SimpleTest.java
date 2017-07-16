package com.bdsoft.test.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List; 
public class SimpleTest {

//	private static SqlMapClient sqlMapper;
//
//	static {
//		try {
//			Reader reader = Resources
//					.getResourceAsReader("com/code/ibatis/SqlMapConfig.xml");
//			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
//			reader.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static List selectAllAcounts() {
//		try {
//			return sqlMapper.queryForList("selectAllAccounts", Account.class);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static Account selectAccountById(int id) {
//		try {
//			return (Account) sqlMapper.queryForObject("selectAccountById", id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	public static void insertAccount(Account account) {
//		try {
//			sqlMapper.insert("insertAccount", account);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void updateAccount(Account account) {
//		try {
//			sqlMapper.update("updateAccount", account);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void deleteAccount(int id) {
//		try {
//			sqlMapper.delete("deleteAccountById", id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
