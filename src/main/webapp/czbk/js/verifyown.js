
// 用户校验的方法
// 这个方法将使用XMLHTTPRequest对象来进行Ajax的异步数据交互

var xmlHttp;
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
	// xmlHttp.open("GET", "ajaxServer?name=" + name, true);
	// 4，发送数据，开始和服务器端进行交互
	// xmlHttp.send(null);

	// post请求方式,需要自己设置http的请求头
	xmlHttp.open("POST", "ajaxServer", true);
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.send("name=" + name);
}
function callBack() {
	// 5，接受响应数据
	// 判断xmlHttp状态是已经交互完成，以及浏览器状态为正常
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			document.getElementById("result").innerHTML = xmlHttp.responseText;
		}
	}
}
