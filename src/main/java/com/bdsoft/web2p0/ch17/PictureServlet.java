package com.bdsoft.web2p0.ch17;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdsoft.global.utils.DB;

public class PictureServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("cate");// 获得请求中cate的值
		// 定义查询数据库的SQL语句
		String sql = "select * from album where active_status='Y' and album_category='"
				+ category.toUpperCase() + "'";

		Connection conn = null;// 声明Connection对象
		Statement stmt = null;// 声明Statement对象
		ResultSet rs = null;// 声明ResultSet对象
		Vector vData = new Vector();
		response.setContentType("text/xml");// 设置返回数据类型为xml格式
		java.io.PrintWriter out = response.getWriter();
		try {
			// 创建Connection对象
			conn = DB.getMySqlConn();
			// 创建Statement对象
			stmt = conn.createStatement();
			// 执行SQL语句，返回记录集
			rs = stmt.executeQuery(sql);
			// 定义AblumEO实体对象
			AlbumEO album;
			while (rs.next()) {// 循环记录集
				album = new AlbumEO();
				album.setAlbumID(rs.getInt("ALBUM_ID"));
				album.setAlbumName(rs.getString("ALBUM_NAME"));
				album.setAlbumURL(rs.getString("ALBUM_URL"));
				album.setAlbumDescription(rs.getString("ALBUM_DESC"));
				album.setAlbumCategory(rs.getString("ALBUM_CATEGORY"));
				album.setActiveStatus(rs.getString("ACTIVE_STATUS"));
				vData.add(album);// 获取数据库中的数据，添加到向量中
			}
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			out.print(parasToXML(vData));// 调用parasToXML()方法
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 最后关必记录集，Connection对象
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException sqle) {
			}
		}
	}

	public String parasToXML(Vector v) {// 该方法将数据转化成XML格式输出
		StringBuffer buf = new StringBuffer();
		buf.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		buf.append("<pictures>");
		for (int i = 0; i < v.size(); i++) {
			AlbumEO album = (AlbumEO) v.get(i);
			buf.append("<item>");
			buf.append("<name>" + album.getAlbumName() + "</name>");
			buf.append("<url>" + album.getAlbumURL() + "</url>");
			buf.append("<description>" + album.getAlbumDescription()
					+ "</description>");
			buf.append("</item>");
		}
		buf.append("</pictures>");
		//System.out.println(buf.toString());
		return buf.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
