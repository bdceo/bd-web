//处理页面
function pageContents(contentsXML) {
	var messages = contentsXML.documentElement; 
	var message = messages.getElementsByTagName('message'); 
	var strcontent = ""; 
	
	var pages = messages.getElementsByTagName("pages")[0].childNodes[0].nodeValue;
	var uppage = messages.getElementsByTagName("uppage")[0].childNodes[0].nodeValue;
	var nextpage = messages.getElementsByTagName("nextpage")[0].childNodes[0].nodeValue;
	var totalpage = messages.getElementsByTagName("totalpage")[0].childNodes[0].nodeValue;
	var status = messages.getElementsByTagName("status")[0].childNodes[0].nodeValue;
	
	var id,title,content,addTime,replyTime,name,qq,email,upage,ip,replyContent;
	
	for(var i=0;i<message.length;i++){
		id = getNodeValue(message,'id',i);
		title = getNodeValue(message,'title',i);
		content = getNodeValue(message,'content',i);
		addTime = getNodeValue(message,'addTime',i);
		replyTime = getNodeValue(message,'replyTime',i);
		name = getNodeValue(message,'name',i);
		qq = getNodeValue(message,'qq',i);
		email = getNodeValue(message,'email',i);
		upage = getNodeValue(message,'page',i);
		replyContent = getNodeValue(message,'replyContent',i);
		ip = getNodeValue(message,'ip',i);

		strcontent += "<div class='message'>";
			strcontent += "<div class='message_title_content'>留言主题：" + title + "<\/div>";
			strcontent += "<div class='message_title_time'>时间：" + addTime + "<\/div>";
			strcontent += "<div class='message_cell'>";
				strcontent += "<div class='message_content'>";
					strcontent += "<div class='message_content_name'>留言人：" + name + "<\/div>";
					strcontent += "<div class='message_content_content'>内容：" + content + "<\/div>";
				strcontent += "<\/div>";
			strcontent += "<\/div>";
			if (replyContent != "")
			{
				strcontent += "<div class='reply_cell'>";
					strcontent += "<div class='reply_content'>";
						strcontent += "<div class='reply_title_name'>管理员回复: <\/div>";
						strcontent += "<div class='reply_title_time'>时间: " + replyTime + "<\/div>";
						strcontent += "<div class='reply_content_content'>" + replyContent + "<\/div>";
					strcontent += "<\/div>";
				strcontent += "<\/div>";
			}
			strcontent += "<div class='message_info'>";
				strcontent += "<div class='message_info_div'>";
					if (status == 'admin')
					{
						strcontent += "<div class='message_info_reply' onclick=\"toReply(" + id + "," + pages + ")\">回复<\/div>";
						strcontent += "<div class='message_info_del' onclick=\"active('processguestbook.do', {action:'del', id:" + id + ", page:" + pages + "}, 'POST', pageContents, 'xml')\">删除</div>";
						document.getElementById("user_lable").innerHTML="欢迎您，管理员";
					} else {
						document.getElementById("user_lable").innerHTML="欢迎您，用户";
					}
					strcontent += "<div class='message_info_ip'>IP:" + ip + "<\/div>";
					strcontent += "<div class='message_info_qq'>QQ:" + qq + "<\/div>";
					strcontent += "<a class='message_info_mail' href='mailto:" + email + "'>Mail<\/a>";
					strcontent += "<a class='message_info_homepage' href='" + upage + "' target='_blank'>Homepage<\/a>";
				strcontent += "<\/div>";
			strcontent += "<\/div>";
		strcontent += "<\/div>";
		strcontent += "<div class ='sepa_div'><\/div>";
	}
	document.getElementById("mesContent").innerHTML = strcontent;
	document.getElementById("pages").value = pages;
	document.getElementById("uppage").value = uppage;
	document.getElementById("nextpage").value = nextpage;
	document.getElementById("totalpage").value = totalpage;
	document.getElementById("pagenum").innerHTML = pages+"/"+totalpage+" 页";
	if (status == "fail") {
		alert("对不起，您没有权限！");	
	}

	displays("loading", "none");
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


//翻页
function actionpage(type){
	if(type=='uppage'){
		var page = document.getElementById("uppage").value;
	}else if(type=='nextpage'){
		var page = document.getElementById("nextpage").value;	
	}else if(type=='totalpage'){
		var page = document.getElementById("totalpage").value;	
	}
	active("/processGuestBook", {page:page}, "POST", pageContents, 'xml');
} 

//登陆
function login(){
	var user = document.getElementById("user").value.trim();
	var pass = document.getElementById("pass").value.trim();

	var pages = document.getElementById("pages").value;
	if (user == "") {
		alert('用户名不能为空');
	} else if (pass == "") {
		alert('密码不能为空');
	} else {
		active("/processGuestBook", {action:"login", page:pages, user:encodeURIComponent(user), pass:encodeURIComponent(pass)}, "POST", pageContents, 'xml');
		clearValues(["user", "pass"]);
		displays('login','none');
	}
}

//添加留言
function add(){
	var name = document.getElementById("name").value.trim();
	var email = document.getElementById("email").value;
	var qq = document.getElementById("qq").value;
	var upage = document.getElementById("upage").value;
	var title = document.getElementById("title").value.trim();
	var content = document.getElementById("content").value.trim();
	
	if(name==""){
		alert('昵称不能为空');
		return;
	}
	if(title==""){
		alert('标题不能为空');
		return;
	}
	if(content==""){
		alert('内容不能为空');
		return;
	}
	active("/processGuestBook", {action:"add", name:encodeURIComponent(name), email:encodeURIComponent(email), qq:encodeURIComponent(qq), upage:encodeURIComponent(upage), title:encodeURIComponent(title), content:encodeURIComponent(content), page:1}, "post", pageContents, 'xml');
	clearValues(["name", "email", "qq", "upage", "title", "content"]);
	displays('add','none');
}

function toReply (id,pages) {
	displays('reply','block');
	document.getElementById("replyId").value = id;
	document.getElementById("replyPage").value = pages;
}

//回复
function reply () {
	var replyId = document.getElementById("replyId").value;
	var replyPage = document.getElementById("replyPage").value;
	var replyContent = document.getElementById("replyContent").value;
	active("/processGuestBook", {action:"reply", replyId:replyId, page:replyPage, replyContent:encodeURIComponent(replyContent)}, "POST", pageContents, 'xml');
	clearValues(["replyContent"]);
	displays('reply','none');
} 
