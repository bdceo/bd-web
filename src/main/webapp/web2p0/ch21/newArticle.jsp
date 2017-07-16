<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.bdsoft.web2p0.ch21.*"%>
<%
	Blog loginBlog = (Blog)session.getAttribute(Constants.LOGIN_USER_KEY);
	Blog visitBlog = (Blog)session.getAttribute(Constants.VISIT_BLOG_KEY);
	
	if(loginBlog == null){
		response.sendRedirect("main.jsp");
	}
	else if((loginBlog.getId() != visitBlog.getId())){
		response.sendRedirect("main.jsp");
	}
	else{
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>发表新文章</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
		<script language="javascript" src="js/newArticle.js" type="text/javascript"></script>
	</head>
	<body>
		<table border="1" width="550" bordercolor="#FF9900">
			<tr>
				<td width="100%">
					<p align="left">
						<b><font color="#FF0000">发表新文章</font></b>
					</p>
				</td>
			</tr>
			<tr>
				<td width="100%">
					<table cellspacing="2" cellpadding="0" width="98%" align="center" border="0">
						<tbody>
							<form name="articleForm" action="">

							<tr>
								<td class="redfont" nowrap width="10%" height="30">
									日志标题
								</td>
								<td>
									<input class="text" id="entrytitle" title="entrytitle" size="75" name="entrytitle">
								</td>
							</tr>
							<tr>
								<td class="redfont" height="30">
									是否选择文章分类
								</td>
								<td width="90%">
									<input type="checkbox" name="sortOk" onclick="refreshList()">
								</td>
							</tr>
							<tr>
							</tr>
							<tr>
								<td class="redfont" height="30">
									日志分类
								</td>
								<td width="90%">
									<select class="text" id="category" name="category"></select>
									&nbsp; <a></a>
								</td>
							</tr>
							<tr>
								<td class="redfont" valign="top" height="30">
									日志内容
								</td>
								<td>
									<textarea name="entrycontent" rows="10" cols="50"></textarea>

								</td>
							</tr>
							</form>
						</tbody>

					</table>
				</td>
			</tr>
			<tr>
				<td width="100%" align="center">
					<input class="button-submit" id="save" type="submit" value="发布日志" name="save" onclick="saveRequest()">
					&nbsp;

				</td>
			</tr>



		</table>
	</body>
</html>
<%}%>
