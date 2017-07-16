<%@ page language="java" pageEncoding="gbk"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insert page="layout.jsp">
	<tiles:put name="header" value="header.jsp"></tiles:put>
	<tiles:put name="tree" value="treeTest.html"></tiles:put>
	<tiles:put name="content" value="content.jsp"></tiles:put>
	<tiles:put name="footer" value="footer.jsp"></tiles:put>
</tiles:insert>

