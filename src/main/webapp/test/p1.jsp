<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<html>
	<head>
		<title>My JSP 'p1.jsp' starting page</title>
		<script src="../dwr/interface/JUserCheck.js"></script>
		<script src="../dwr/engine.js"></script>
		<script src="../dwr/util.js"></script>
	</head>
	<script type="text/javascript">
		function checkUserExists(octl){
			var uname=octl.value;
			alert(uname);
			JUserCheck.check(uname,backCall);
		}
		function backCall(isExist){
		alert(isExist);
			if(isExist=="1"){
				alert("用户存在了！");
			}
			else if(isExist=="0"){
				alert("用户名可用！");
			}
		}		
	</script>
	<body>
		<form method="post" action="p2.jsp">
			输入一个数字：
			<input name="num">
			<br>
			<input type="submit">
		</form>
		<input type="text" name="uname" onBlur="return checkUserExists(this);">
	</body>
</html>
