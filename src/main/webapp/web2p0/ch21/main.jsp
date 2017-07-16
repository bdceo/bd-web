﻿<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.bdsoft.web2p0.ch21.*"%>
<%@ page import="java.util.*"%>
<%
	List articleList = (List)session.getAttribute(Constants.ARTICLE_LIST_KEY);
	Article article = null;
	Integer tpage=(Integer)session.getAttribute(Constants.CUR_PAGEID_KEY);
	int pageId=tpage.intValue();
	Integer tSortId=(Integer)session.getAttribute(Constants.CUR_SORTID_KEY);
	int sortId=tSortId.intValue();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>显示主页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
	</head>
	<body>
		<table border="1" width="550" bordercolor="#000000">

			<tr>
				<td width="100%">
					<p align="right">
						<b><font color="#FF0000"><a href="newArticle.jsp">发表文章</a></font></b>
					</p>
				</td>
			</tr>

			<%if(articleList != null ){
			System.out.println(articleList.size());
       for(int i = 0;i < articleList.size();i++)
       {  
       		article = (Article)articleList.get(i);
      %>



			<tr>
				<td width="100%">
					<b><font color="#FF0000"><%=article.getTitle()%></font></b>
					<p>
						<b><font color="#FF0000"><%=article.getContent()%></font></b>
					</p>
					<p align="right">
						<b><font color="#FF0000"><a href="/showFeedback?articleid=<%=article.getId()%>">查看评论</a></font></b>
					</p>
				</td>
			</tr>

			<%	
         }
      }	%>


			<tr>
				<td width="100%">
					<p align="center">
						| <font color="#999999"> <a href="/blogOperate?pageid=<%=pageId-1%>">上页</a></font> | <a href="/blogOperate?pageid=<%=pageId+1%>">下页</a> |
					</p>
				</td>
			</tr>
		</table>
	</body>
</html>