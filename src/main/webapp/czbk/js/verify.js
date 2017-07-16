function verify() {
	// 解决中文乱码问题：1，页面端发出的数据做一次encodeURI，服务器端使用str = new
	// String(str.getBytes("ISO8859-1"), "UTF-8");
	//var url = "ajaxServer?name=" + encodeURI($("#userName").val());
	// 2，页面端坐两次encodURI,服务器端使用str=URLDecoder.decode(str,"UTF-8");
	
	var url = "ajaxServer?name=" + encodeURI(encodeURI($("#userName").val()));
	url = convertUrl(url);
	$.get(url, null, function(data) {
				$("#result").html(data);
			});
}

function convertUrl(url) {
	var dt = new Date().valueOf();
	if (url.indexOf("?") > 0) {
		return url + "&t=" + dt;
	} else {
		return url + "?t=" + dt;
	}
}