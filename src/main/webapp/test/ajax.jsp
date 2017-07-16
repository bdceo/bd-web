<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%> 
<html>
	<head>
		<title>ajax测试</title>
	</head>
	<script language="javascript"> 
  var xmlHttp;  
  function createXMLHttpRequest() {
    if (window.ActiveXObject) {
      xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } 
    else if (window.XMLHttpRequest) {
      xmlHttp = new XMLHttpRequest();
    }
  } 
  var xhr;
  function createXML(){
  	if(window.ActiveXObject){
  		try{
  			xhr=new ActiveXObject("Msxml2.XMLHTTP");
  		}catch(e){
  			xhr=new ActiveXOjbect("Micrsoft.XMLHTTP");
  		}
  	}else{
  		xhr=new XMLHttpRequest();
  	}
  }
 
  function loadCls(){	
    createXMLHttpRequest();
    xmlHttp.onreadystatechange=proCls;    
    xmlHttp.open("POST","load.do?ope=loadClass",true);
    xmlHttp.send(null);  
    
  }
  function proCls(){ 	
    var result;  
    debugger;
    if(xmlHttp.readyState==4&&xmlHttp.status==200){
      result=xmlHttp.responseXML.getElementsByTagName("cls");      
      var data=xmlHttp.responseXML;
      while (document.all.cls.options.length>0){ 
          document.all.cls.removeChild(document.all.cls.childNodes[0]);
        } 
      for(var i=0;i<result.length;i++){
        var option =document.createElement("OPTION");
   		option.text=result[i].childNodes[0].childNodes[0].nodeValue;         
        option.value=result[i].childNodes[1].childNodes[0].nodeValue;         
        document.all.cls.options.add(option); 
      }
    }
  }
  function loadStu(){
    var cid = document.all.cls.value; 
    createXMLHttpRequest(); 
    xmlHttp.onreadystatechange = proStu; 
    xmlHttp.open("POST","load.do?ope=loadStu&cid="+cid,true); 
    xmlHttp.send(null);
  } 
  function proStu() { 
    var result;
    if(xmlHttp.readyState==4&&xmlHttp.status==200) { 
        result = xmlHttp.responseXML.getElementsByTagName("stu"); 
        while (document.all.stu.options.length>0){ 
          document.all.stu.removeChild(document.all.stu.childNodes[0]);
        } 
        for(var i=0;i<result.length;i++){
          var option = document.createElement("OPTION");
          option.text = result[i].childNodes[0].childNodes[0].nodeValue; 
          option.value = result[i].childNodes[1].childNodes[0].nodeValue; 
          document.all.stu.options.add(option); 
        }
      }
    }
    function test(){
    	alert("ddds");		
    }
   
</script>
	<body onLoad="test()">
		<input type="button" onClick="loadCls();" value="加载数据" name="dd" />
		请选择班级：
		<select id="cls" onChange="loadStu();">
			<option value="">
				选择班级
			</option>
		</select>
		学生有：
		<select id="stu">
			<option value="">
				暂无学生
			</option>
		</select>
	</body>
</html>
