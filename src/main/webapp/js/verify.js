String.prototype.getBytes = function() {    
    var cArr = this.match(/[^\x00-\xff]/ig);    
    return this.length + (cArr == null ? 0 : cArr.length);    
}
// 重写trim方法
String.prototype.trim = function () {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
// 传入id，使文本框极其内容获得焦点
function fs(id) {
	var obj = document.getElementById(id);
	var range = obj.createTextRange();
	range.moveStart("character", 0);
	range.select();
}
// 传入id，获得页面元素的值 
function getVal(id) {
	return document.getElementById(id).value.trim();
}
//验证输入为正整数
function isInt(val) {
	if(val==null||val==""||val.length==0){
		return false;
	}
	var reg = /^[0-9]+\d*$/;
	return reg.test(val);
}
//格式化成两位小数
function formatFloat(src, pos) {
	return Math.round(src * Math.pow(10, pos)) / Math.pow(10, pos);
}
// 验证E-mail的合法性
function isEmail(email) {
	if (email.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1) {
		return true;
	} else {
		return false;
	}
}
// 验证邮编
function ispcode(pc) {
	var reg = /[1-9]\d{5}(?!\d)/;
	return reg.test(pc);
}
// 验证日期格式：1988-05-17
function isDate(dt) {
	var reg = /\d{4}-\d{1,2}-\d{1,2}/;
	if (dt.match(reg) == null) {
		return false;
	}
	return true;
}
//判断时间先后 2010年04月08日 14时
function checkDate(be,af){
	var flag=true;
	if(be==""||af==""){
		return flag;
	}else{	 
		var dbe = new Date(be.substring(0,4),be.substring(5,7),be.substring(8,10),be.substring(12,14),00,00);
		var daf = new Date(af.substring(0,4),af.substring(5,7),af.substring(8,10),af.substring(12,14),00,00); 
		if(Date.parse(dbe) - Date.parse(daf)>=0){
			return false;	
		}
	}
	return flag;
}
// 验证固定电话-手机的合法性
function isTel(tel) {
	var reg = /13\d{9}\b|15[0-9]\d{8}\b|18[0156789]\d{8}\b|010[- ]?[1-9]\d{7}\b|02\d[- ]?[1-9]\d{7}\b|0[3-9]\d{2}[- ]?[1-9]\d{6,7}\b/;
	if (tel.match(reg) == null) {
		return false;
	}
	return true;
}
// 验证是否是数字类型，可以包含小数点儿
function isNumber(oNum) {
	if (!oNum) {
		return false;
	}
	var strP = /^\d+(\.\d+)?$/;
	if (!strP.test(oNum)) {
		return false;
	}
	try {
		if (parseFloat(oNum) != oNum) {
			return false;
		}
	}
	catch (ex) {
		return false;
	}
	return true;
}
// 检查上传文件的类型,传入上传组件框中的文本
function checkFileType(s) {
	s = s.substr(s.lastIndexOf(".") + 1).toLowerCase();
	if (s != "gif" && s != "jpg" && s != "jpeg" && s != "jpe" && s != "jfif" && s != "png") {
		return false;
	} else {
		return true;
	}
}
// 检查输入中是否存在中文
function checkChinese(inputvalue) {
	for (var i = 0; i < inputvalue.length; i++) {
		if (inputvalue.charCodeAt(i) > 255) {
			return false;
		}
	}
	return true;
}
