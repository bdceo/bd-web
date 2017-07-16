<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">

<title>新闻管理主页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<script language="javascript" src="script/common.js"></script>
<script src='dwr/interface/NewsFormDAO.js'></script>
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>
<SCRIPT type="text/javascript">
    var myrowid;
    function add(){
	    htmlurl="add_news.html";
		var newwin=window.open(htmlurl,'','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=1,resizable=0,top=2,width=460,height=400');
		return false;
    }
    
    function modifyMe(row){
	    htmlurl="/newsOption.do?method=typeme&newsid="+row.cells[0].innerHTML;
		var newwin=window.open(htmlurl,'','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=1,resizable=0,top=2,width=460,height=400');
		return false;
    }
    
    function deleteNews(row){
    	myrowid = row.rowIndex;  	
    	NewsFormDAO.deleteNews(row.cells[0].innerHTML,delFun);
    }
    
    function delFun(data){
	   	if (data!=0){
		   	alert("删除成功!");
		   	var mytable = document.getElementById("newsTab");
			mytable.deleteRow(myrowid);
	   	}else{
		   	alert("删除失败!");
	   	}
    }
    function searchNews(data){
	   	if (data!=0){
		   	alert("删除成功!");
		   	var mytable = document.getElementById("newsTab");
			mytable.deleteRow(myrowid);
	   	}else{
		   	alert("删除失败!");
	   	}
    }
    </SCRIPT>
</head>

<body   bgcolor="#C6F4D6">
<center>
<h1>简易新闻管理系统</h1>
</center>
<jsp:include page="toolbar.html" />
<TABLE width="100%" id="newsTab"  border="1" cellpadding="5" cellspacing="0" bgcolr="#ffffff">
	<TR  bgcolr="#ffffff">
		<td align="center" nowrap>编号</td>
		<td align="center" nowrap>新闻标题</td>
		<td align="center" nowrap>时间</td>
		<logic:equal name="logonType" value="yes">
			<td class="title1" align="center" nowrap>操作</td>
		</logic:equal>
	</TR>
	<logic:present name="listNews" scope="session">
		<logic:iterate id="mylist" name="listNews" scope="session"
			type="com.bdsoft.web2p0.ch22.struts.form.NewsForm">
			<tr>
				<td align="center" nowrap><bean:write name="mylist"
					property="newsId" /></td>
				<td align="left" nowrap><a
					href="/newsOption.do?method=typenews&newsid=<bean:write name="mylist" property="newsId"/>"><bean:write
					name="mylist" property="title" /></a></td>
				<td align="center" nowrap><bean:write name="mylist"
					property="createDate" /></td>
				<logic:equal name="logonType" value="yes">
					<td align="center" nowrap><input type="button" value="修改"
						onclick="modifyMe(this.parentNode.parentNode);"> <input
						type="button" value="删除"
						onClick="deleteNews(this.parentNode.parentNode);"></td>
				</logic:equal>
			</tr>
		</logic:iterate>
	</logic:present>
</TABLE>
</body>
</html>
