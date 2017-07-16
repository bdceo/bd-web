//处理页面
function pageContents(contentsXML) {
	var messages = contentsXML.getElementsByTagName("words")[0];
	var message = messages.getElementsByTagName('word');
	var container = getElById("wordsContainer");
	
	var num = messages.getAttribute("num");
	getElById("num").value=num;
	
	for(var i=0;i<message.length;i++){
		var word = message[i].childNodes[0].nodeValue;
		var vp = document.createElement("p");
		vp.innerHTML = word;
		container.insertBefore(vp, container.firstChild);
	}
}

//返回nodeValue
function getNodeValue(root,tagName,i){
	var value;
	if(root[i].getElementsByTagName(tagName)[0].childNodes[0]){
		value = root[i].getElementsByTagName(tagName)[0].childNodes[0].nodeValue;
	}else{
		value = '';	
	}
	return value;
}

//返回根据传入的id得到对应对象
function getElById(id) {
	return document.getElementById(id);
}

//发言
function send(){
	var talkto = document.getElementById("talkto").value;
	var act = document.getElementById("act").value;
	var words = document.getElementById("words").value;
	var num = document.getElementById("num").value;
	
	if(words==""){
		alert('发言不能为空');
		return;
	}
	active("deal.jsp", {talkto:encodeURIComponent(talkto), act:encodeURIComponent(act), words:encodeURIComponent(words), num:encodeURIComponent(num)}, "post", pageContents, 'xml');
}

function refresh() {
	window.setInterval("refres()",2000);
}

function refres() {
	var num = document.getElementById("num").value;
	active("deal.jsp", {num:encodeURIComponent(num)}, "post", pageContents, 'xml');
}
