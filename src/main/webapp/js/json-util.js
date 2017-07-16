
//转换为json  
function $parseJson(str) {
	try {
		eval("var obj=" + str);
		return obj;
	}
	catch (e) {
		return null;
	}
}

//数组转换为字符串  
function $ArrayToString(arr) {
	var separator = ",";//separator 为分隔符  
	for (var i = 0; i < arr.length; i++) {
		arr[i] = $toJsonString(arr[i]);
	}
	return arr.join(separator);
}
//json转换为字符串  
function $toJsonString(obj) {
	var isArray = obj instanceof Array;
	var r = [];
	for (var i in obj) {
		var value = obj[i];
		if (typeof value == "string") {
			value = "\"" + value + "\"";
		} else {
			if (value != null && typeof value == "object") {
				value = $toJsonString(value);
			}
		}
		r.push((isArray ? "" : i + ":") + value);
	}
	if (isArray) {
		return "[" + r.join(",") + "]";
	} else {
		return "{" + r.join(",") + "}";
	}
}

