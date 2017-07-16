package com.bdsoft.web2p0.ch22.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdsoft.web2p0.ch22.base.DBConnection;
import com.bdsoft.web2p0.ch22.struts.form.NewsForm;

public class NewsFormDAO {
	protected DBConnection conn = new DBConnection();

	public int insertNews(NewsForm nf) {
		int num = 0;
		String sql = "insert into news(createdate,title,content) values('"
				+ nf.getCreateDate() + "','" + nf.getTitle() + "','"
				+ nf.getContent() + "')";
		num = conn.executeUpdate(sql);
		conn.close();
		return num;
	}

	public List<NewsForm> queryAll() {
		ArrayList<NewsForm> list = new ArrayList();
		String sql = "select * from news";
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				NewsForm nf = new NewsForm();
				nf.setNewsId(String.valueOf(rs.getInt("newsid")));
				nf.setCreateDate(rs.getString("createdate"));
				nf.setTitle(rs.getString("title"));
				nf.setContent(rs.getString("content"));
				list.add(nf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}

	public int deleteNews(int id) {
		int num = 0;
		String sql = "delete from news where newsid=" + id;
		num = conn.executeUpdate(sql);
		conn.close();
		return num;
	}

	public NewsForm selectNews(int id) {
		NewsForm nf = new NewsForm();
		String sql = "select * from news where newsid=" + id;
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				nf.setNewsId(String.valueOf(rs.getInt("newsid")));
				nf.setTitle(rs.getString("title"));
				nf.setContent(rs.getString("content"));
				nf.setCreateDate(rs.getString("createdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return nf;
	}

	public int modifyNews(NewsForm nf) {
		int num = 0;
		String sql = "update news set title='" + nf.getTitle() + "',content='"
				+ nf.getContent() + "',createdate='" + nf.getCreateDate()
				+ "' where newsid=" + nf.getNewsId();
		num = conn.executeUpdate(sql);
		conn.close();
		return num;
	}

	public List<NewsForm> queryPage(int page, int pagesize) {

		ArrayList<NewsForm> list = new ArrayList();
		String sql = "select * from (select rownum rid,newsid,title,content,createdate from news) ttt where ttt.rid<="
				+ pagesize
				+ "*"
				+ page
				+ " and ttt.rid>"
				+ pagesize
				+ "*("
				+ page + "-1)";
		int spage = 0;
		int epage = 10;
		spage = pagesize * (page - 1);
		epage = pagesize * page;
		sql = "select newsid,title,content,createdate from news order by newsid limit "
				+ spage + "," + epage;
		System.out.println(sql);
		ResultSet rs = conn.executeQuery(sql);
		try {
			while (rs.next()) {
				NewsForm nf = new NewsForm();
				nf.setNewsId(String.valueOf(rs.getInt("newsid")));
				nf.setCreateDate(rs.getString("createdate"));
				nf.setTitle(rs.getString("title"));
				nf.setContent(rs.getString("content"));
				list.add(nf);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return list;
	}

	public int newsCount() {
		int num = 0;
		String sql = "select count(*) from news";
		ResultSet rs = conn.executeQuery(sql);
		try {
			if (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return num;
	}
}
