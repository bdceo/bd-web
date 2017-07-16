<%@ page language="java"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Ajax分页</title>
<script language="javascript" src="function/ajax.js"></script>
<script language="javascript">
	//页面加载，获取第一页
	function winload() {	
		send_request("/pager?currentPage=1");
	}
	//页面跳转
	function goToPage(page) {
		send_request("/pager?currentPage="+page);
	}
</script>
</head>
<body onload="winload();">
<table width="500" border="0" cellspacing="0" cellpadding="4">
  <tr>
    <td align="center">书籍列表</td>
  </tr>
</table>
<table width="500" border="0" cellspacing="0" cellpadding="4">
  <tr>
    <td align="center" height="200" valign="top">
		<label id="newslist"></label>
		</td>
  </tr>
</table>
<table width="500" border="0" cellspacing="0" cellpadding="4">
  <tr>
    <td align="center">
		<label id="firstPage"><a href="javascript:void(0)" onClick="goToPage('1')">第一页</a></label>
		<label id="prePage">上一页</label>
		<label id="nextPage">下一页</label>
		<label id="lastPage">最末页</label>
		</td>
  </tr>
</table>
</body>
</html>
