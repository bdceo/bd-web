function verify() {
	// ��������������⣺1��ҳ��˷�����������һ��encodeURI����������ʹ��str = new
	// String(str.getBytes("ISO8859-1"), "UTF-8");
	//var url = "ajaxServer?name=" + encodeURI($("#userName").val());
	// 2��ҳ���������encodURI,��������ʹ��str=URLDecoder.decode(str,"UTF-8");
	
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