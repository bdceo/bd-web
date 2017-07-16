<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户名检查</title>
		<script>
 	
 	//设一个变量
 	
 	var XMLHttpReq=false;
 		//创建一个XMLHttpRequest对象
 		function createXMLHttpRequest(){
			if(window.XMLHttpRequest){ //Mozilla 
				XMLHttpReq=new XMLHttpRequest();
			}else if(window.ActiveXObject){
				try{
					XMLHttpReq=new ActiveXObject("Msxml2.XMLHTTP");
				}catch(e){
					try{
						XMLHttpReq=new ActiveXObject("Microsoft.XMLHTTP");
					}catch(e){}
				}
			}
		}
 		//发送请求函数
 		function send(url){
 			createXMLHttpRequest();
 			XMLHttpReq.open("GET",url,true);
 			XMLHttpReq.onreadystatechange=proce;   //指定响应的函数
 			XMLHttpReq.send(null);  //发送请求
 		}
 		function proce(){
 			if(XMLHttpReq.readyState==4){ //对象状态
 				if(XMLHttpReq.status==200){//信息已成功返回，开始处理信息
	 				var res=XMLHttpReq.responseXML.getElementsByTagName("content")[0].firstChild.data;
	 				window.alert(res);
 				}else{
 					window.alert("所请求的页面有异常");
 				}
 			}
 		}
 		//身份验证 
 		function check(){
 			var name=document.getElementById("name").value;
			if(name==""){
				alert("请输入姓名");
				return false;
			}else{
				send('/login?name='+name);
			}
 		}
 					
 		</script>
	</head>

	<body>
		<table>
			<form action="login" method="post">
			<tr>
				<td>
					姓名:&nbsp;
					<input id="name" type="text" name="name" />
					<p>
						<input type="button" value="检测!" onClick="check()" />
				</td>
			</tr>
			</form>
		</table>
	</body>
</html>
