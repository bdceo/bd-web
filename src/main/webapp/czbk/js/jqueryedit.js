$(document).ready(function() {
	var tds=$("td");
	tds.click(tdClick);
});
function tdClick(){
		var td=$(this);
		//取出当前td中的内容，保存到临时变量中
		var text=td.text();
		//清空td里的内容
		td.html("");//td.empty();
		//建立一个文本框，也就是input元素
		var input=$("<input>");
		//设置文本框的值
		input.attr("value",text);
		input.keyup(function(event){
			var myEvent=event||window.event;
			var kcode=myEvent.keyCode;
			if(kcode==13){
				var inputNode=$(this);
				var inputText=inputNode.val();
				var tdNode=inputNode.parent();
				tdNode.html(inputText);
				tdNode.click(tdClick);
			}
		}); 
		//将文本框加入到td中
		td.append(input);
		//添加选中文本内容事件
		var inputDom=input.get(0);
		inputDom.select();
		//移除td的click事件
		td.unbind("click");
}