<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<table width="100%">
	<tr>
		<td>
		<div align="right"><logic:notEqual name="nowpage" value="1">
			<a href="/newsOption.do?method=findpage&page=1&pageType=first">最前页</a>
		</logic:notEqual> <logic:notEqual name="currentBar" value="1">
			<a
				href="/newsOption.do?method=findpage&currentBar=${currentBar}&barType=pre">上十页</a>
		</logic:notEqual> <logic:iterate id="mylist" name="pageList" scope="session">

			<a
				href="/newsOption.do?method=findpage&page=<bean:write name="mylist"/>">
			<font
				color='<logic:equal name="nowpage" value="${mylist}">red</logic:equal>'><bean:write
				name="mylist" /></font></a>
		</logic:iterate> <logic:notEqual name="currentBar" value="${barcount}">
			<a
				href="/newsOption.do?method=findpage&currentBar=${currentBar}&barType=next">下十页</a>
		</logic:notEqual> <logic:notEqual name="nowpage" value="${pagecount}">
			<a
				href="/newsOption.do?method=findpage&page=${pagecount}&pageType=last">最后页</a>
		</logic:notEqual></div>
		</td>
	</tr>
</table>
