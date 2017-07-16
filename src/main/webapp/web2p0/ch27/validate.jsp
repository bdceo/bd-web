<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty sessionScope.user}">
	<jsp:forward page="logon.jsp">
		<jsp:param name="name" value="123" />
	</jsp:forward>
</c:if>
