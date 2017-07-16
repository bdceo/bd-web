//创建并返回一个XMLHttpRequest对象实例
function newXMLHttpRequest() {
	var xmlHttp;
	//在非IE浏览器中创建一个XMLHttpRequest对象实例
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	}
	//在IE浏览器中创建一个XMLHttpRequest对象实例
	else if (window.ActiveXObject) {
	    try {
			//在IE较新版本中创建一个XMLHttpRequest对象实例
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");  
	    } catch (e1) {
			//创建ActiveXObject失败
			try {
				//在IE较老版本中创建一个XMLHttpRequest对象实例
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				//无法创建一个XMLHttpRequest对象实例
				xmlHttp = false;
			}
		}
	}
	return xmlHttp;
}

//返回一个函数，当前请求完成后，将服务器返回的XML传给对应函数处理
function getReadyStateHandler(req, responseHandler, resType) {
	//返回一个匿名函数监听XMLHttpRequest对象实例
	return function () {
		//如果请求的状态时"完成"
		if (req.readyState == 4) {
			//检查是否从服务器得到一个成功的响应
			if (req.status == 200) {
				if (resType.toUpperCase() == "TEXT") {
					//传递服务器返回的text给处理函数
					responseHandler(req.responseText);
				} else {
					//传递服务器返回的XML给处理函数
					responseHandler(req.responseXML);
				}
			} else {
				//发生HTTP的问题
				alert("HTTP error "+req.status+": "+req.statusText);
			}
		}
	}
}

//将传入的json类型数据转化为String类型返回
function jsonToString(jsonData) {
	if(typeof(jsonData)=="undefined"||jsonData==null){
		return "";
	}
	var result=new Array();
	for(attr in jsonData){
		result.push(attr+"="+jsonData[attr]);
	}
	return result.join("&");
}

//向服务器发送请求
function active(url, params, methodType, dealMethod, resType) {
	var contentType = null;
	if (!methodType || methodType.toUpperCase() == "GET") {
		methodType = "GET";
		url = url + "?" + jsonToString(params) + "&timeStamp=" + new Date().getTime();
		params=null;
	}
	if (methodType.toUpperCase() == "POST") {
		methodType = "POST";
		contentType = "application/x-www-form-urlencoded";
		params = jsonToString(params) + "&timeStamp=" + new Date().getTime();
	}
	//实例化一个XMLHttpRequest对象
	var xmlHttp = newXMLHttpRequest();
	//当状态被改变的时候，你可以做你想做的
	xmlHttp.onreadystatechange = getReadyStateHandler(xmlHttp, dealMethod, resType);
	//设置到服务器的连接
	xmlHttp.open(methodType, url);
	if (contentType) {
		xmlHttp.setRequestHeader("Content-Type", contentType);
	}
	//发送请求给服务器
	xmlHttp.send(params);
}