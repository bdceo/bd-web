<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<html:html lang="true">
<head>
	<title>动态显示Tree</title>
	<link rel="StyleSheet" type="text/css" href="dtree.css">
	<script type="text/javascript" src="dtree.js"></script>
</head>
<body>
	<html:form action="/getTree.do" method="post">
		<html:submit value="显示"></html:submit>
	</html:form>
	<logic:present name="list" scope="request">
		<div class="dtree">
			<script type="text/javascript">
          d = new dTree('d');
          d.add('ROOT_MENU',-1,'管理系统');          
        </script>
			<logic:iterate id="n" name="list">
				<script type="text/javascript">
				  d.add('${n.rightCode}','${n.rightParentCode}','${n.rightText}','${n.rightUrl}','${n.rightTip}'，'${n.rightType}');      
				</script>
			</logic:iterate>
			<script type="text/javascript">
          document.write(d);    
        </script>
		</div>
	</logic:present>
</body>
</html:html>
