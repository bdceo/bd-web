
// 定义用户名校验的方法
function verify() {
	// 1,获取文本框中的内容
	// document.getElementById("id");--dom方式
	// jQuery方式的查找，参数中的#加上id属性就可以找到一个节点。
	// jQuery的方法返回的都是jquery的对象，可以继续在上面执行其他的jquery方法
	var jqueryObj = $("#userName");
	// 直接通过方法读取value值
	var userName = jqueryObj.val();

	// 2,将文本框中的数据发送给服务器端的servlet
	// 使用jQuery的XMLHttpRequest对象请求的封装
	$.ajax({
				type : "POST",
				url : "AjaxXmlServlet",
				data : "name=" + userName,
				dataType : "xml",
				success : callback
			});

}
// 回调函数
function callback(data) {
	// 3,接受服务器端返回的数据
	// 需要将data这个dom对象中的数据解析出来
	// 首先要将dom中的对象转换成jQuery对象
	var jqueryObj = $(data);
	//获取message节点
	var message = jqueryObj.children();
	//获取文本内容
	var text=message.text();
	// 4,将服务器端返回的数据动态的显示在页面上
	$("#result").html(text);
}