<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<title>评论系统</title>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script src="js/prototype.js" type="text/javascript"></script>
		<script src="js/talks.js" type="text/javascript"></script>
	</head>
	<SCRIPT type="text/javascript">
		function loadComment(){
			getComments("/web2p0/ch19/data/comment.xml");
		}
	</SCRIPT>

	<body onload="loadComment();">
		<div id="cinfoDiv" style="display: none;">
			<h2>
				信息提示
			</h2>
			<p id="cinfomsg">
			</p>
		</div>
		<table id="process-indicator"
			style="display: none; z-index: 100; width: 300px;">
			<tr>
				<td>
					<img src="images/loading.gif" />
					<p>
						正在处理中
					</p>
				</td>
			</tr>
		</table>
		<center>
			<div id="comment">
				<div style="display: none; top: 100px; left: 200px;" id="locateDiv1">

				</div>
				<div id="comment-bar">
					你喜欢非洲吗?
				</div>
				<div id="comment-form">
					<form onsubmit="return false;" name="cform">
						昵称:
						<input type="text" id="nn" name="nn" />
						<input type="radio" id="existy" name="exist" value="yes" />
						喜欢
						<input type="radio" id="existn" name="exist" value="no" />
						不喜欢
						<br />
						<textarea name="reason" style="width: 480px; height: 100px;"
							id="reason"></textarea>
						<button id="btnsubmit" class="button"
							onclick="addComment('/comment');">
							发表你的看法
						</button>
						<input type="reset" id="btnreset" class="button" />
					</form>
				</div>
			</div>

			<div id="comment-lists"></div>
		</center>
	</body>
</html>
