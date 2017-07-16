<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.bdsoft.web2p0.ch21.*"%>
<%@ page import="java.util.*"%>

<%
	Blog blog = (Blog)session.getAttribute(Constants.VISIT_BLOG_KEY);
	List sortList = (List)session.getAttribute(Constants.SORT_LIST_KEY);
	Sort sort = null;
	List linkList = (List)session.getAttribute(Constants.LINK_LIST_KEY);
	Links link = null;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>主菜单</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
		<base target="main">
	</head>
	<body>
		<table cellspacing="0" cellpadding="0" width="750" background="images/bk_11.jpg" border="0">
			
		</table>

		<table border="1" width="750" bordercolor="#000000" height="450">

			<tr>
				<td width="137" valign="top" height="73">
					<table border="1" width="141%" bordercolor="#000000" height="69">
						<tr>
							<td width="100%" height="17">
								<b><font color="#FF0000">导航栏</font></b>
							</td>
						</tr>
						<tr>
							<td width="100%" height="17">
								<p align="center">
									<a href="/blogOperate?sortid=0&amp;pageid=0" target="main">个人首页</a>
								</p>
							</td>
						</tr>
						<tr>
							<td width="50%" height="17">
								<p align="center">
									<a href="blogAdminMain.jsp" target="_parent">个人管理</a>
								</p>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="137" valign="top" height="67">
					<table border="1" width="140%" bordercolor="#000000">
						<tr>
							<td width="100%">
								<b><font color="#FF0000">文章分类</font></b>
							</td>
						</tr>

						<tr>
							<td width="100%">
								<p align="center">
									<a href="/blogOperate?sortid=0&amp;pageid=0" target="main">所有文章</a>
								</p>
							</td>
						</tr>

						<%if(sortList != null ){

       for(int i = 0;i < sortList.size();i++)
       {  
       		sort = (Sort)sortList.get(i);
      %>


						<tr>
							<td width="100%">
								<p align="center">
									<a href="/blogOperate?sortid=<%=sort.getId()%>&amp;pageid=0" target="main"><%=sort.getName()%></a>
								</p>
							</td>
						</tr>

						<%
         }
      }	%>

					</table>
				</td>
			</tr>
			<tr>
				<td width="137" valign="top" height="73">
					<table border="1" width="140%" bordercolor="#000000">
						<tr>
							<td width="100%">
								<b><font color="#FF0000">我的链接</font></b>
							</td>
						</tr>


						<%if(linkList != null ){

       for(int i = 0;i < linkList.size();i++)
       {  
       		link = (Links)linkList.get(i);
      %>



						<tr>
							<td width="100%">
								<p align="center">
									<a href="<%=link.getUrl()%>" target="_blank"><%=link.getName()%></a>
								</p>
							</td>
						</tr>

						<%
         }
      }	%>



					</table>

				</td>
			</tr>
			<tr>
				<td width="137" valign="top" align="center" height="17">
					<font color="red">网页计数器:<%=blog.getVisitcount()%></font>
				</td>
			</tr>
		</table>
	</body>
</html>
