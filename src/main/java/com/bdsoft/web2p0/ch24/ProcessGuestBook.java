package com.bdsoft.web2p0.ch24;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessGuestBook extends HttpServlet {

	private final int PAGENUM = 5;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String sPage = request.getParameter("page");
		int page = 1;
		if (sPage != null) {
			page = Integer.parseInt(sPage);
		}
		int pageList = (page - 1) * PAGENUM;
		HttpSession session = request.getSession(true);
		String status = null;
		if (session.getAttribute("user") != null) {
			status = String.valueOf(session.getAttribute("user"));
		} else {
			status = "user";
		}

		// 登陆
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("login")) {
			DatabaseConnector dc = new DatabaseConnector();
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			String sqlStr = "select pass from user where user = '" + user + "'";

			ResultSet rs = null;

			try {
				rs = dc.executeQuery(sqlStr);
				while (rs.next()) {
					String realPass = rs.getString("pass");
					if (realPass != null) {
						if (realPass.equals(pass)) {
							session.setAttribute("user", "admin");
							status = "admin";
						} else {
							session.setAttribute("user", "user");
							status = "fail";
						}

					} else {
						session.setAttribute("user", "user");
						status = "fail";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					dc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 添加
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("add")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String qq = request.getParameter("qq");
			String upage = request.getParameter("upage");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String addTime = sdf.format(new Date());
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String ip = request.getRemoteAddr();

			String sqlStr = "Insert Into messageboard (`title`,`content`,`addTime`,`name`,`qq`,`email`,`page`,`ip`) values ('"
					+ title
					+ "','"
					+ content
					+ "','"
					+ addTime
					+ "','"
					+ name
					+ "','"
					+ qq
					+ "','"
					+ email
					+ "','"
					+ upage
					+ "','"
					+ ip
					+ "')";
			DatabaseConnector dc = new DatabaseConnector();
			try {
				dc.executeUpdate(sqlStr);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					dc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 回复
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("reply")
				&& session.getAttribute("user").equals("admin")) {
			String replyId = request.getParameter("replyId");
			String replyContent = request.getParameter("replyContent");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String replyTime = sdf.format(new Date());

			String sqlStr = "Update messageboard Set replyContent = '"
					+ replyContent + "',replyTime = '" + replyTime
					+ "' Where id = '" + replyId + "'";
			DatabaseConnector dc = new DatabaseConnector();
			try {
				dc.executeUpdate(sqlStr);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					dc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 删除
		if (request.getParameter("action") != null
				&& request.getParameter("action").equals("del")
				&& session.getAttribute("user").equals("admin")) {
			String id = request.getParameter("id");

			String sqlStr = "Delete From messageboard Where id = '" + id + "'";

			DatabaseConnector dc = new DatabaseConnector();
			try {
				dc.executeUpdate(sqlStr);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					dc.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 分页
		DatabaseConnector dc = new DatabaseConnector();
		String sqlStr = "Select Count(id) From messageboard";
		ResultSet rs = null;
		int total = 0;
		try {
			rs = dc.executeQuery(sqlStr);
			while (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		int totalPage = 0;
		if (total % PAGENUM != 0) {
			totalPage = total / PAGENUM + 1;
		} else {
			totalPage = total / PAGENUM;
		}
		int upPage = 0;
		int nextPage = 0;
		if (page > 1) {
			upPage = page - 1;
		} else {
			upPage = 1;
		}
		if (page >= totalPage) {
			nextPage = totalPage;
		} else {
			nextPage = page + 1;
		}

		response.setHeader("Content-Type", "text/xml;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		/*
		 * XML的格式如下: <?xml version="1.0" encoding="UTF-8" ?> <messages> <pages></pages>
		 * <uppage></uppage> <nextpage></nextpage> <totalpage></totalpage>
		 * <status></status> <message> <id></id> <title></title> <content></content>
		 * <addTime></addTime> <replyTime></replyTime> <name></name> <qq></qq>
		 * <email></email> <page><page> <replyContent></replyContent> <ip></ip>
		 * <message> </messages>
		 */
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<messages>");
		sb.append("<pages>").append(page).append("</pages>");
		sb.append("<uppage>").append(upPage).append("</uppage>");
		sb.append("<nextpage>").append(nextPage).append("</nextpage>");
		sb.append("<totalpage>").append(totalPage).append("</totalpage>");
		sb.append("<status>").append(status).append("</status>");

		// 查询留言
		sqlStr = "Select id,title,content,addTime,name,ip,page,email,qq,replyTime,replyContent From messageboard Order By id Desc limit "
				+ pageList + ", " + PAGENUM;

		try {
			rs = dc.executeQuery(sqlStr);
			while (rs.next()) {
				sb.append("<message>");
				sb.append("<id>").append(rs.getInt("id")).append("</id>");
				sb.append("<title>").append(rs.getString("title")).append(
						"</title>");
				sb.append("<content>").append(rs.getString("content")).append(
						"</content>");
				sb.append("<addTime>").append(rs.getString("addTime")).append(
						"</addTime>");
				sb.append("<replyTime>").append(rs.getString("replyTime"))
						.append("</replyTime>");
				sb.append("<name>").append(rs.getString("name")).append(
						"</name>");
				sb.append("<qq>").append(rs.getInt("qq")).append("</qq>");
				sb.append("<email>").append(rs.getString("email")).append(
						"</email>");
				sb.append("<page>").append(rs.getString("page")).append(
						"</page>");
				if (rs.getString("replyContent") != null)
					sb.append("<replyContent>").append(
							rs.getString("replyContent")).append(
							"</replyContent>");
				else
					sb.append("<replyContent>").append("</replyContent>");
				sb.append("<ip>").append(rs.getString("ip")).append("</ip>");
				sb.append("</message>");
			}
			sb.append("</messages>");
			PrintWriter out = response.getWriter();
			out.write(sb.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				dc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
