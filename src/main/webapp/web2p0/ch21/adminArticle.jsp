<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>Blog文章管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
		<script language="javascript" src="js/adminArticle.js" type="text/javascript"></script>
		<base target="contents">
	</head>
	<body text="#FCD447" onload="loadRequest()">

		<table border="1" width="550" height="73" bordercolor="#000000">
			<tr>
				<td width="74%" valign="top" height="14">
					<font color="#FF0000"><b>Blog文章管理</b></font>
				</td>
			</tr>
			<tr>
				<td width="74%" valign="top" height="14">
					<font color="#FF0000"><b>文章分类</b></font>
					<select id="sort" onchange="sortChange()">
					</select>
				</td>
			</tr>

			<tr>
				<td width="74%" valign="top" height="13">
					<font color="#FF0000">
						<table border="1" width="100%" bordercolor="#000000" align="center">
							<tr>
								<td width="25%" align="center">
									<b>文章名称</b>
								</td>
								<td width="25%" align="center">
									<b>发表时间</b>
								</td>
								<td width="50%" colspan="2" align="center">
									<b>操作</b>
								</td>
							</tr>
							<tbody id="articleList"></tbody>
						</table> <b></b></font>
				</td>
			</tr>

		</table>

	</body>
</html>
