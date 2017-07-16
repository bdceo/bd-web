var xmlHttp;
var noPwd="请输入登录密码";
var noName="请输入用户名";
var noAccPwd="请输入确认密码";
var noPwd2="确认密码和密码不一致";
var nocdName="请输入歌曲名字";
var nocdCom="请输入备注";
var nocdSinger="请输入歌手名字";
var nocdType="请选择歌曲风格";
var noOldPwd="请输入原始密码";
var noNewPwd="请输入新密码";
var noAccNewPwd="请输入确认新密码";
var newPwd2="新密码和确认密码不一致";
var isRemove="你确定要删除么？";
var isOut="您确定要退出系统吗？";
function createXMLHttpRequest(){
	if (window.ActiveXObject){
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}else if (window.XMLHttpRequest){
		xmlHttp = new XMLHttpRequest();
	}
	if (xmlHttp.overrideMimeType){
    	xmlHttp.overrideMimeType('text/xml');
  	}
}
function setQueryString(){
	var param="";
	for(var i=0;i<arguments.length;i++){
		param+=arguments[i]+'='+encodeURI(arguments[i+1]);
		if(i!=arguments.length-2){
			param+="&";
			i++;
		}else{
			break;
		}		
	}
	return param;
}

function regPage(){
	window.location="register.jsp";
}

function goIndex(){
	window.navigate('index.jsp');
}

function goLogin(){
	window.navigate('logon.jsp');
}

function goAdd(){
	window.navigate('newproduct.jsp');
}

function goSelect(){
	window.navigate('query.jsp');
}

function goChenge(){
	window.navigate('modpwd.jsp');
}

function goMod(id){
	this.id=id;
	options='dialogheight:300px;dialogwidth:250px;edge:raised;center:yes;help:no;resizable:no;status:no;';
	var editForm=window.showModalDialog("modproduct.jsp",window,options);
}

function logonsys(userName,userPwd){
	if(userName==''){
		alert(noName);
		return;
	}else if (userPwd==''){
		alert(noPwd);
		return;
	}
	isLogin(userName,userPwd);
}

function isLogin(userName,userPwd){
	var param=setQueryString('userName',userName,'userPwd',userPwd);
	createXMLHttpRequest();
	xmlHttp.open('POST','/checkservlet',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=loginCallBack;
	xmlHttp.send(param);
}
function loginCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          	var msg=xmlHttp.responseText;
          	alert(msg);
          	if(msg.indexOf('成功')!=-1) {
          		goIndex();
          	}
		}
	}
}

function userReg(userName,userPwd,accPwd){
	if(userName==""){
		alert(noName);
		return false;
	}else if(userPwd==""){
		alert(noPwd);
		return false;
	}else if(accPwd==""){
		alert(noAccPwd);
		return false;
	}else if(accPwd!=userPwd){
		alert(noPwd2);
		return false;
	}
	toReg(userName,userPwd);
}
function toReg(userName,userPwd){
	var param=setQueryString('userName',userName,'userPwd',userPwd);
	createXMLHttpRequest();
	alert('2');
	xmlHttp.open('POST','/regSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=regCallBack;
	xmlHttp.send(param);
}
function regCallBack(){
  if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          var msg=xmlHttp.responseText;
          alert(msg);
          if(msg.indexOf('成功')!=-1){
          }
		}
	}
}

function insertCDs(cdName,cdCom,cdSinger,cdType){
	if(cdName==""){
		alert(nocdName);
		return false;
	}else if(cdCom==""){
		alert(nocdCom);
		return false;
	}else if(cdSinger==""){
		alert(nocdSinger);
		return false;
	}else if(cdType==""){
		alert(nocdType);
		return false;
	}
	toAddMusic(cdName,cdCom,cdSinger,cdType);
}
function toAddMusic(cdName,cdCom,cdSinger,cdType){
	var param=setQueryString('cdName',cdName,'cdCom',cdCom,'cdSinger',cdSinger,'cdType',cdType);
	createXMLHttpRequest();
	xmlHttp.open('POST','/newSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=toAddMusicCallBack;
	xmlHttp.send(param);
}
function toAddMusicCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          	var msg=xmlHttp.responseText;
          	alert(msg);
		}
	}
}

var page=1;
var selectValue="";
var pagecount=1;
var action="";
function setPageCount(){
	var pageTag=document.getElementById('pageCount');
	pagecount=pageTag.innerText=getPageCount();
	document.getElementById('page').innerText=page;
}
function getPageCount(){
	var res=xmlHttp.responseXML;
	return res.getElementsByTagName('Count')[0].firstChild.nodeValue;
}
function selectCDs(page,action){
	this.action=action;
	if(page!=0)
		this.page=page;
	else
		page=1;
	if(page>pagecount){
		this.page=page=pagecount;
	}
	if(action=='last')
	this.page=page=pagecount;
	if(action=='frist')	this.page=page=1;
	toselectMusic(page,action);
}
function toselectMusic(page,action){
	var param=setQueryString('page',page,'selectValue',selectValue,'action',action);
	createXMLHttpRequest();
	xmlHttp.open('POST','/querySvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=searchMusicCallBack;
	xmlHttp.send(param);
}
function searchMusicCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){			 
          	var msg=xmlHttp.responseText;
          	clearRestls();
          	setHeader();
         	setResults();
         	setPageCount();
		}
	}
}

function setHeader(){
	var row=document.createElement('tr');
	var cell=createCellth('序号');
	row.appendChild(cell);
	var cell=createCellth('歌名');
	row.appendChild(cell);
	var cell=createCellth('歌手');
	row.appendChild(cell);
	var cell=createCellth('备注');
	row.appendChild(cell);
	var cell=createCellth('风格');
	row.appendChild(cell);
	var cell=createCellth('操作');
	row.appendChild(cell);
	document.getElementById('results').appendChild(row);
}

function createTable(cdName,cdCom,cdSinger,cdType,cdId){
	var row=document.createElement('tr');
	var cell=createCelltd(cdId);
	row.appendChild(cell);
	cell=createCelltd(cdName);
	row.appendChild(cell);
	cell=createCelltd(cdSinger);
	row.appendChild(cell);
	cell=createCelltd(cdCom);
	row.appendChild(cell);
	cell=createCelltd(cdType);
	row.appendChild(cell);
	row.appendChild(addOption(cdId));
	document.getElementById('results').appendChild(row);
}
function addOption(cdid){
	var edit=document.createElement('A');
	edit.setAttribute('href','javascript:goMod('+cdid+')');
	edit.appendChild(document.createTextNode('[修改] '));
	var cell=document.createElement('td');
	cell.appendChild(edit);
	var del=document.createElement('A');
	del.appendChild(document.createTextNode('[删除]'));
	del.setAttribute('href','javascript:del('+cdid+')');
	cell.appendChild(del);
	return cell;
	
}

function createCellth(text){
	var cell=document.createElement('th');
	var textNode=document.createTextNode(text);
	cell.appendChild(textNode);
	return cell;
}
function createCelltd(text){
	var cell=document.createElement('td');
	var textNode=document.createTextNode(text);
	cell.appendChild(textNode);
	return cell;
}
function clearRestls(){
	var doc=document.getElementById('results');
	while(doc.childNodes.length>0){
		doc.removeChild(doc.childNodes[0]);
	}
}
function setResults(){
	var res=xmlHttp.responseXML;
	var prop=null;
	var cdName,cdCom,cdSinger,cdType,cdId;
	var props=res.getElementsByTagName('mycd');
	for(var i=0;i<props.length;i++)	{
		prop=props[i];
		cdName=prop.getElementsByTagName('cdName')[0].firstChild.nodeValue;
		cdCom=prop.getElementsByTagName('cdCom')[0].firstChild.nodeValue;
		cdSinger=prop.getElementsByTagName('cdSinger')[0].firstChild.nodeValue;
		cdType=prop.getElementsByTagName('cdType')[0].firstChild.nodeValue;
		cdId=prop.getElementsByTagName('ID')[0].firstChild.nodeValue;
		createTable(cdName,cdCom,cdSinger,cdType,cdId);
	}
}

function chengePwd(oldPwd,newPwd,accNewPwd){
	if(oldPwd==""){
		alert(noOldPwd);
		return false;
	}else if(newPwd==""){
		alert(noNewPwd);
		return false;
	}else if(accNewPwd==""){
		alert(noAccNewPwd);
		return false;
	}else if(newPwd!=accNewPwd){
		alert(newPwd2);
		return false;
	}
	modPwd(newPwd,oldPwd);
}
function modPwd(newPwd,oldPwd){
	var param=setQueryString('newPwd',newPwd,'oldPwd',oldPwd);
	createXMLHttpRequest();
	xmlHttp.open('POST','/pwdSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=modPwdCallBack;
	xmlHttp.send(param);
}
function modPwdCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          	var msg=xmlHttp.responseText;
          	alert(msg);
		}
	}
}

var id;
function getCDs(id){
	toGetCD(id);
}

function toGetCD(id){
	var param=setQueryString('id',id);
	createXMLHttpRequest();
	xmlHttp.open('POST','/updateSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=getCDsCallBack;
	xmlHttp.send(param);
}

function getCDsCallBack(){
  if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
			setCDInfo();
		}
	}
}
function setCDInfo(){
	var res=xmlHttp.responseXML;
	var prop=null;
	var cdName,cdCom,cdSinger,cdType,cdId;
	var props=res.getElementsByTagName('mycd');
	for(var i=0;i<props.length;i++){
		prop=props[i];
		cdName=prop.getElementsByTagName('cdName')[0].firstChild.nodeValue;
		cdCom=prop.getElementsByTagName('cdCom')[0].firstChild.nodeValue;
		cdSinger=prop.getElementsByTagName('cdSinger')[0].firstChild.nodeValue;
		cdType=prop.getElementsByTagName('cdType')[0].firstChild.nodeValue;
		cdId=prop.getElementsByTagName('ID')[0].firstChild.nodeValue;
		doSet(cdName,cdCom,cdSinger,cdType,cdId);
	}
}

function doSet(cdName,cdCom,cdSinger,cdType,cdId){
	cdIdform.value=cdId;
	cdNameform.value=cdName;
	cdCompanyform.value=cdCom;
	cdAlbumform.value=cdSinger;
	for(i=0;i<cdTypeform.childNodes.length;i++)	{
		if(cdTypeform.childNodes[i].tagName=='OPTION'){
			if(cdTypeform.childNodes[i].innerText==cdType){
				cdTypeform.value=cdTypeform.childNodes[i].value;
			}
		}
	}
}

function updateCDs(id,cdName,cdCom,cdSinger,cdType){
	if(cdName==""){
		alert(nocdName);
		return false;
	}else if(cdCom==""){
		alert(nocdCom);
		return false;
	}else if(cdSinger==""){
		alert(nocdSinger);
		return false;
	}else if(cdType==""){
		alert(nocdType);
		return false;
	}
	modMusic(id,cdName,cdCom,cdSinger,cdType);
}

function modMusic(id,cdName,cdCom,cdSinger,cdType){
	var param=setQueryString('id',id,'cdName',cdName,'cdCom',cdCom,'cdSinger',cdSinger,'cdType',cdType,'action','updata');
	createXMLHttpRequest();
	xmlHttp.open('POST','/updateSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=modMusicCallBack;
	xmlHttp.send(param);
}

function modMusicCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          var msg=xmlHttp.responseText;
          alert(msg);
          window.dialogArguments.selectCDs(page,action);
		}
	}
}

function del(id){
	if(confirm(isRemove)){
		todel(id);
	}
}
function todel(id){
	var param=setQueryString('id',id);
	createXMLHttpRequest();
	xmlHttp.open('POST','/delSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=delCallBack;
	xmlHttp.send(param);
}
function delCallBack(){
  	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200){
          	var msg=xmlHttp.responseText;
          	alert(msg);
          	selectCDs(page,action);
		}
	}
}

function out(){
	if(confirm(isOut)){
		logout();
	}
}
function logout(){
	var param=setQueryString('action','out');
	createXMLHttpRequest();
	xmlHttp.open('POST','/actionSvlt',true);
	xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange=outCallBack;
	xmlHttp.send(param);
}
function outCallBack(){
	if(xmlHttp.readyState==4){
		if(xmlHttp.status==200)	{
          	var msg=xmlHttp.responseText;
          	alert(msg);
          	goLogin();
		}
	}
}