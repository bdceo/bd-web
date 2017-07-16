//去掉字符串中的空格
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, ""); 
}

//函数传入的值是页面元素的id号组成的数组，函数的作用是将对应元素的value值清空
function clearValues(arr) {
	var aArr = arr;
	if (aArr instanceof Array) {
		if (aArr.length > 0) {
			for (var i =0; i <aArr.length; i++)
			{
				if (document.getElementById(aArr[i]))
				{
					document.getElementById(aArr[i]).value = "";
				}
			}
		}
	}
}

//返回根据传入的id得到对应对象
function getElById(id) {
	return document.getElementById(id);
}

//显示与隐藏
function displays(id,type){
	if (document.getElementById(id)) {
		document.getElementById(id).style.display = type;
	}
}