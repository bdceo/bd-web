
var XMLHttpReq = false;
//创建XMLHttpRequest对象       
function createXMLHttpRequest() {
	if(window.XMLHttpRequest) { //Mozilla 浏览器
		XMLHttpReq = new XMLHttpRequest();
	}
	else if (window.ActiveXObject) { // IE浏览器
		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}
}

function send_request(url){
	createXMLHttpRequest();
	XMLHttpReq.open("GET", url, true);
	XMLHttpReq.onreadystatechange = populateList;//指定响应函数
	XMLHttpReq.send(null);  // 发送请求
}

//将所获取的书籍列表填充到页面的相应位置
function populateList() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
			var doc = XMLHttpReq.responseXML;
			var currentPage = doc.getElementsByTagName("currentPage")[0].firstChild.data;
			var totalPage = doc.getElementsByTagName("totalPage")[0].firstChild.data;
			var prePage = parseInt(currentPage) - 1;
			var nextPage = parseInt(currentPage) + 1;
			var newslist = doc.getElementsByTagName("news");
			var innerHTML = "";
			if ((newslist != null) && (newslist.length != 0)) {
				innerHTML += "<table width=\"100%\" cellpadding=\"2\" cellspacing=\"0\" border=\"0\">\r\n";
				innerHTML += "<tr><td width='10%' height='25'>ID</td><td width='65%'>\u4e66\u540d</td><td width='25%'>\u4f5c\u8005</td></tr>";
				for (var i = 0; i < newslist.length; i++) {
					var news = newslist[i];
					var id = news.getAttribute("id");
					var title = (news.childNodes[0].firstChild == null) ? "" : news.childNodes[0].firstChild.data;
					var submittime = (news.childNodes[1].firstChild == null) ? "" : news.childNodes[1].firstChild.data;
					innerHTML += "<tr>";
					innerHTML += "<td width='10%' height='25'>" + id + "</td>";
					innerHTML += "<td width='65%' height='25'>" + title + "</td>";
					innerHTML += "<td width='25%' height='25'>" + submittime + "</td>";
					innerHTML += "</tr>";
				}
				innerHTML += "</table>\r\n";
			} else {
				innerHTML += "\u6682\u65f6\u6ca1\u6709\u4efb\u4f55\u4e66\u7c4d";
			}
			//window.alert(currentPage+"|"+nextPage+"|"+prePage+"|"+totalPage);
			document.getElementById("newslist").innerHTML = innerHTML;
			document.getElementById("prePage").innerHTML = "<a href=\"javascript:void(0)\" onClick=\"goToPage('" + prePage + "')\">\u4e0a\u4e00\u9875</a>";
			document.getElementById("nextPage").innerHTML = "<a href=\"javascript:void(0)\" onClick=\"goToPage('" + nextPage + "')\">\u4e0b\u4e00\u9875</a>";
			document.getElementById("lastPage").innerHTML = "<a href=\"javascript:void(0)\" onClick=\"goToPage('" + totalPage + "')\">\u6700\u672b\u9875</a>";
			//window.alert(currentPage);
		} else { //页面不正常
			alert("\u60a8\u6240\u8bf7\u6c42\u7684\u9875\u9762\u6709\u5f02\u5e38\u3002");
		}
	}
}

// 处理返回文本格式信息的函数
function processTextResponse() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
			//alert(XMLHttpReq.responseText);
			//alert("Text文档响应。");
		} else { //页面不正常
			//alert("您所请求的页面有异常。");
		}
	}
}

//处理返回的XML格式文档的函数
function processXMLResponse() {
	if (XMLHttpReq.readyState == 4) { // 判断对象状态
		if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
			//alert(XMLHttpReq.responseXML);
			//alert("XML文档响应。");
		} else { //页面不正常
			//alert("您所请求的页面有异常。");
		}
	}
}
