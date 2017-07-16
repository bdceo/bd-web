<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>留言板</title>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/ajax.js"></script>
		<script type="text/javascript" src="js/tools.js"></script>
		<script type="text/javascript" src="js/guestbook.js"></script>
	</head>

	<body onload="active('/processGuestBook', null, 'POST', pageContents, 'xml')">
		<div class="base">
			<div class="top">留言板</div>
			<div class="center">
				<div class="cen_title">
					<div class="area_inner">
						<a href="#" onclick="displays('login','block')">管理员登陆</a>
						<a href="#" onclick="displays('add','block')">留言</a>
						<div id="user_lable">欢迎您，用户</div>
					</div>
				</div>
				<div class="sepa_div"></div>
				<div class="cen_inner">
					<div id="loading">Loading...</div>
					<div id="mesContent" style="width:100%"></div>
				</div>
				<div class="cen_bottom">
					<div class="area_inner">
						<div id="pagenum"></div>
						<a href="#" onclick="actionpage('totalpage')">尾页</a>
						<a href="#" onclick="actionpage('nextpage')">下一页</a>
						<a href="#" onclick="actionpage('uppage')">上一页</a>
						<a href="#" onclick="active('/processGuestBook', null, 'POST', pageContents, 'xml')">首页</a>
					</div>
				</div>
			</div>
		</div>

		<input type="hidden" id="nextpage">
		<input type="hidden" id="pages">
		<input type="hidden" id="uppage">
		<input type="hidden" id="totalpage">

		<!-- 管理员登陆 -->
		<div class="popup" id="login">
			<div class="popupdivcover"></div>
			<div class="popupdivshow">
				<div class="popupdivshowarea">
					<div class="popupdiv" style="width:200px;">
						<div class="popupdivtitle">
							<div style="width:85%;">管理员登录</div>
							<div onclick="displays('login','none')" style="width:15%;cursor:pointer;">关闭</div>
						</div>
						<div class="popupdivcell">
							<div style="width:35%;">用户名：</div>
							<input type="text" id="user" style="width:100px;">
						</div>
						<div class="popupdivcell">
							<div style="width:35%;">密 码：</div>
							<input type="password" id="pass" style="width:100px;">
						</div>
						<input type="button" value="提 交" onclick="login()" style="margin-left:50px;" />
						<input type="button" value="重 置" onclick="clearValues(['user','pass'])" />
					</div>
				</div>
			</div>
		</div>

		<!-- 回复 -->
		<div class="popup" id="reply">
			<div class="popupdivcover"></div>
			<div class="popupdivshow">
				<div class="popupdivshowarea">
					<div class="popupdiv" style="width:300px;">
						<div class="popupdivtitle">
							<div style="width:90%;">管理员回复</div>
							<div onclick="displays('reply','none')" style="width:10%;cursor:pointer;">关闭</div>
						</div>
						<div style="border:1px solid #FFFFFF;">
							<textarea cols="33" rows="6" id="replyContent"></textarea>
						</div>
						<input type="button" value="提 交" onclick="reply()" style="margin-left:100px;" />
						<input type="button" value="重 置" onclick="clearValues(['replyContent'])" />
						<input type="hidden" id="replyId">
						<input type="hidden" id="replyPage">
					</div>
				</div>
			</div>
		</div>

		<!-- 留言 -->
		<div class="popup" id="add">
			<div class="popupdivcover"></div>
			<div class="popupdivshow">
				<div class="popupdivshowarea">
					<div class="popupdiv" style="width:320px;">
						<div class="popupdivtitle">
							<div style="width:90%;">留言</div>
							<div onclick="displays('add','none')" style="width:10%;cursor:pointer;">关闭</div>
						</div>
						<div class="popupdivcell">
							<div style="width:20%;">昵 称：</div>
							<input type="text" id="name" size="20" maxlength="20"><span class="color_red">*</span>
						</div>
						<div class="popupdivcell">
							<div style="width:20%;">邮 箱：</div>
							<input type="text" id="email" size="20" maxlength="20">
						</div>
						<div class="popupdivcell">
							<div style="width:20%;">Q Q：</div>
							<input type="text" id="qq" size="20" maxlength="10">
						</div>
						<div class="popupdivcell">
							<div style="width:20%;">主 页：</div>
							<input type="text" id="upage" size="20" maxlength="60">
						</div>
						<div class="popupdivcell">
							<div style="width:20%;">标 题：</div>
							<input type="text" id="title" size="20" maxlength="60"><span class="color_red">*</span>
						</div>
						<div style="border:1px solid #FFFFFF;">
							<div style="width:20%;float:left;">内 容：</div>
							<textarea cols="26" rows="4" id="content"></textarea><span class="color_red">*</span>
						</div>
						<input type="button" value="提 交" onclick="add()" style="margin-left:100px;" />
						<input type="button" value="重 置" onclick="clearValues(['name','email','qq','upage','title','content'])" />
					</div>
				</div>
			</div>
		</div>
	</body>
</html>