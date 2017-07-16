<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page  contentType="text/html;charset=UTF-8" %>

<HTML>
	<HEAD>
		<TITLE>聊天室</TITLE>
		<link href="style/style.css" rel="stylesheet" type="text/css" />
	</HEAD>
	<BODY>
		<FORM action="applyok.jsp" method="POST" name="register">
		<TABLE border="2" width="270"> 
		     <tr><th>注册新用户信息</th></tr>
		     <TR>
			      <TD>头像: 
		  		  	  <IMG SRC="images/face0.gif" WIDTH="32" HEIGHT="32" BORDER="0">
		  		  	  <INPUT TYPE="radio" name="face" value=0 checked>
	  	  			  <IMG SRC="images/face1.gif" WIDTH="32" HEIGHT="32" BORDER="0">
	  	  			  <INPUT TYPE="radio" NAME="face" value=1>
					  <IMG SRC="images/face2.gif" WIDTH="32" HEIGHT="32" BORDER="0">
					  <INPUT TYPE="radio" NAME="face" value=2>
					  <IMG SRC="images/face3.gif" WIDTH="32" HEIGHT="32" BORDER="0">
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  <INPUT TYPE="radio" NAME="face" value=3>
					  <IMG SRC="images/face4.gif" WIDTH="32" HEIGHT="32" BORDER="0">
					  <INPUT TYPE="radio" NAME="face" value=4>
					  <IMG SRC="images/face5.gif" WIDTH="32" HEIGHT="32" BORDER="0">
					  <INPUT TYPE="radio" NAME="face" value=5>
		          </TD>
			</TR>
		    <TR>
			      <TD>呢称:
		              <INPUT type="text" name="nick" style="width:120px;" maxlength="12" />
		              <span style="color:red;">*</span>
				  </TD>
		    </TR>
			<TR>
			      <TD>密码:
					  <input type="password" name="code" style="width:120px;" maxlength="12" /> 
					  <span style="color:red;">*</span>
				  </TD>
		    </TR>
			<TR>
			      <TD>性别:
		              <INPUT type="radio" value="0" name="sex" />男 
		              <INPUT type="radio" value="1" name="sex" />女
		              <INPUT type="radio" value="2" name="sex" />保密
		          </TD>
			</TR>
			<TR>
			      <TD>QQ:
				      <INPUT type="text" style="width:120px;" name="qq" />
				  </TD>
			</TR>
			<TR>
			      <TD>email: 
				      <INPUT type="text" style="width:120px;" name="email" /> 
		          </TD>
			</TR>
			<TR>
			      <TD>
			    	   带<span style="color:red;">*</span>号为必须填写项目
				  </TD>
			</TR>
			<TR>
			      <TD align="center">
					  <INPUT type="submit" value="开始注册">
		          </TD>
			</TR>
		</TABLE>
		</FORM>
	</BODY>
</HTML>
