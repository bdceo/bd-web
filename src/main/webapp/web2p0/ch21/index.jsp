<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
	<head>
		<title>blog</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="StyleSheet" type="text/css" href="style/style.css">
		<script language="javascript" src="js/index.js" type="text/javascript"></script>
	</head>
	<body onload="loadRequest()">
		<div class="base">
		<form name="loginForm" action="">
		<table height="45" cellspacing="0" cellpadding="0" width="750" border="0">
			<tbody>
				<tr>
					<td align="middle">
						登录名：
						<input class="input01" id="uname" tabindex="1" size="15" name="uname">
						密码：
						<input class="input01" id="psw" tabindex="2" type="password" size="15" name="psw">
						验证码：
						<input class="input01" id="checkwd" style="WIDTH: 60px" tabindex="3" size="15" name="checkwd">
						<img height="20" src="image.jsp" width="51" align="absMiddle" alt="">
						<img src="images/bk_button01.gif" align="absMiddle" value="提交" name="bt" onclick="userCheck()" alt="">

						<a class="a02" href="regist.jsp" target="_blank"><b>新博客注册</b></a>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		
		<table border="1" width="750" bordercolor="#000000">
			<tr>
				<td width="40%" valign="top">
					<table height="25" cellspacing="0" cellpadding="0" width="206" border="0">
						<tbody>
							<tr>
								<td class="td01 ft01 b">
									<b><font color="#FF0000">博客排行</font></b>
								</td>
							</tr>
						</tbody>
					</table>
					<table cellspacing="0" cellpadding="0" width="208" border="0">
						<tbody>

							<tr>
								<td>
									<table cellspacing="0" cellpadding="0" width="208" border="0">
										<tbody>
											<tr>
												<td colspan="2" height="5"></td>
											</tr>

											<tr>
											</tr>
										</tbody>
										<tbody id="blogList"></tbody>
										<tr></tr>

										<tbody></tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<!-- 一周人气排行 end -->
				</td>
				<td width="*" valign="top">
					<table>
						<td colspan="2">
							<font color="#FF0000"><b>最新文章</b></font>
						</td>
						<tr>
						</tr>
						<tbody id="articleList"></tbody>
						<tr></tr>
					</table>
				</td>
			</tr>
		</table>
		</div>
	</body>
</html>
