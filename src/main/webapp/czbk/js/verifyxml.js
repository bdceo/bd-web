var xmlHttp;
// 用户校验的方法
// 这个方法将使用XMLHTTPRequest对象来进行Ajax的异步数据交互
function verify() {
	// 0，使用dom的方式获取文本框中的值
	var name = document.getElementById("userName").value;
	// 1，创建XMLHTTPRequest对象
	if (window.XMLHttpRequest) {// Firefox,Mozillar,IE7-8,Opera,Safari
		xmlHttp = new XMLHttpRequest();
		// 针对某些特定版本的Mozillar浏览器的bug进行修正
		if (xmlHttp.overrideMimeType) {
			xmlHttp.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {// IE6以下
		var activexName = ["MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
		for (var i = 0; i < activexName.length; i++) {
			try {
				xmlHttp = new ActiveXObject(activexName[i]);
				break;
			} catch (e) {
				continue;
			}
		}
	}
	// 确认xmlHttp对象是否创建成功
	if (!xmlHttp) {
		alert("XMLHttpRequest对象创建失败！");
		return;
	}
	// 2，注册回调函数,只需要函数名，不要加括号
	xmlHttp.onreadystatechange = callBack;
	// 3，设置连接信息open(get/post,url,true/false)
	// xmlHttp.open("GET", "AjaxXmlServlet?name=" + name, true);
	// 4，发送数据，开始和服务器端进行交互
	// xmlHttp.send(null);

	// post请求方式,需要自己设置http的请求头
	xmlHttp.open("POST", "AjaxXmlServlet", true);
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.send("name=" + name);
}
function callBack() {
	// 5，接受响应数据
	// 判断xmlHttp状态是已经交互完成，以及浏览器状态为正常
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var data = xmlHttp.responseXML;
			if (data) {
				// <message>msg</message>,利用getElementByTagName获取节点,返回数组
				var nodes = data.getElementsByTagName("message");			
				if (nodes.length > 0) {
					var dis = document.getElementById("result");
					var msg = nodes[0].firstChild.nodeValue;
					//dis.innerHTML = msg;
					dis.textContent=msg;
				} else {
					alert("xml数据格式出错，原始文件的内容为：" + xmlHttp.responseText);
				}
			} else {
				alert("返回数据错误！");
			}
		}
	}
}
