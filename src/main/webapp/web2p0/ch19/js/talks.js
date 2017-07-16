var Browser = {};
Browser.isMozilla = (typeof document.implementation != "undefined") && (typeof document.implementation.createDocument != "undefined") && (typeof HTMLDocument != "undefined");
Browser.isIE = window.ActiveXObject ? true : false;
Browser.isFirefox = (navigator.userAgent.toLowerCase().indexOf("firefox") != -1);
Browser.isSafari = (navigator.userAgent.toLowerCase().indexOf("safari") != -1);
Browser.isOpera = (navigator.userAgent.toLowerCase().indexOf("opera") != -1);

String.prototype.trim=function(){return this.replace(/^s+|s+$/g,"");};

function addComment(url){
	var nn=$F("nn");
	var rsn=$F("reason");
	var atti=false;
	var rbgroup=document.cform.elements["exist"];
	for(i=0;i<rbgroup.length;i++){
	  if(rbgroup[i].checked) {atti=rbgroup[i].value;break;};
	}
	//alert(atti);
	var locateTop=$("locateDiv1").parentNode.offsetTop+100;
	var locateLeft=$("locateDiv1").parentNode.offsetLeft+150;
	var alertMsg="";
	if(!atti)
	  alertMsg+="<br/>请表明你的态度!";
	if(nn.trim()=="")
	  alertMsg+="<br/>昵称不能为空!"
	if(rsn.trim()=="")
	  alertMsg+="<br/>请写下你的理由!";
	
	var cinfomsg=$("cinfomsg");
	if(alertMsg!=""){
	  cinfomsg.className="failure";
	  cinfomsg.innerHTML=alertMsg;
	  showDialog($("cinfoDiv"),locateTop,locateLeft);
	  return;
	}else{
	  cinfomsg.className="success";
	  cinfomsg.innerHTML="数据处理中...";
	
	  showDialog($("cinfoDiv"),locateTop,locateLeft);
	}
	
	var pars="nn="+nn+"&atti="+atti+"&rsn="+rsn;
	//var http=Ajax.getTransport();
	//var contentType = "text/html;charset=UTF-8";
	//http.open("POST",url,true);
	//http.setRequestHeader("Content-Type", contentType);
	//http.onreadystatechange=function(){
	  //   if (http.readyState == 4){
	    //  if (http.status==200){
	      //   afterAdd(http);
	         //alert("OK");
	       //}
	     //}
	  //}
	//http.send(pars);
	
	var a=new Ajax.Request(url,{method:'post',parameters:pars,onSuccess:function(res){
			afterAdd(res);
		}
	});
}

function afterAdd(request){
	hideDialog();
	var atti=false;
	var rbgroup=document.cform.elements["exist"];
	for(i=0;i<rbgroup.length;i++){
	  if(rbgroup[i].checked) {atti=rbgroup[i].value;break;};
	}
	var nn=$F("nn");
	var rsn=$F("reason");
	generateCommentList(atti,nn,request.responseText,rsn)
	$("nn").value="";
	$("reason").value="";
}

function generateCommentList(atti,nn,date,rsn){
	var commentLists=$("comment-lists");
	
	var commentlist=document.createElement("div");
	commentlist.className="comment-list";
	
	var observerInfo=document.createElement("div");
	observerInfo.className="observer-info";
	
	var attitude=(atti=="yes")?"喜欢":"不喜欢";
	var info=document.createTextNode("评论者:"+nn+" 观点:"+attitude+" "+date);
	observerInfo.appendChild(info);
	
	var observerComment=document.createElement("div");
	observerComment.className="observer-comment";
	
	var reason=document.createTextNode(rsn);
	observerComment.appendChild(reason);
	
	commentlist.appendChild(observerInfo);
	commentlist.appendChild(observerComment);
	
	if(commentLists.hasChildNodes()){
	   
	  var tmp=commentLists.firstChild;
	  commentLists.insertBefore(commentlist,tmp);
	}else{
	  commentLists.appendChild(commentlist);
	}

}

function getComments(url){
	Element.show("process-indicator");
	Element.makePositioned("process-indicator");
	var top = document.body.scrollTop + 200;
	var left = "";
	if ($("process-indicator").style.width) {
	    left =window.document.body.scrollWidth/2-100;
	} else {
	left = parseInt(document.body.clientWidth / 2);
	}
	var style = {top:top + "px", left:left + "px"};
	Element.setStyle("process-indicator", style);
	//加个随机数,去除缓存影响
	var pars="rd=rd_"+parseInt(Math.random()*10000);
	
	var http=Ajax.getTransport();
	//var contentType = "text/html;charset=UTF-8";
	http.open("POST",url,true);
	//http.setRequestHeader("Content-Type", contentType);
	http.onreadystatechange=function(){
	     if (http.readyState == 4){
	      if (http.status==200){
	         afterGetComments(http);
	         //alert("OK");
	       }
	     }
	  }
	http.send(pars);
}

function afterGetComments(request){
	//提示框
	Element.hide("process-indicator");
	var xmldata=request.responseXML;
	var comments=xmldata.getElementsByTagName("comment");
	if(!comments){alert("暂无评论");return;}
	var len=comments.length;
	for(var i=0;i<len;i++){
	  var atti=comments[i].getAttribute("attitude");
	  var nn=comments[i].getElementsByTagName("nikename")[0].firstChild.nodeValue;
	  var rsn=comments[i].getElementsByTagName("data")[0].firstChild.nodeValue;
	  var date=comments[i].getElementsByTagName("pubdate")[0].firstChild.nodeValue;
	  generateCommentList(atti,nn,date,rsn)
	}
}



var lastDialog=null;
function showDialog(dialog,offsetTop,offsetLeft){
    if (lastDialog) lastDialog.style.display="none";
    dialog.style.top=offsetTop+"px";
    dialog.style.left=offsetLeft+"px";
    dialog.style.display="";
    lastDialog=dialog;
    document.onmousedown=toHideDialog
}
function toHideDialog(event){
    if (!lastDialog) {document.onclick=null;return;}
    var obj=null;
    if(Browser.isIE) obj=window.event.srcElement;
    else obj=event.target;
    hideDialog();
}
function hideDialog(){
    if (lastDialog) lastDialog.style.display="none";
    lastDialog=null
    document.onmousedown=null;
}


