var xmlHttp; 
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { // Mozilla �����
		xmlHttp = new XMLHttpRequest();
		if (xmlHttp.overrideMimeType) {
			xmlHttp.overrideMimeType("text/xml");
		}

	} else if (window.ActiveXObject) { // IE�����
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
}
function login() {
	var a = document.getElementById("name").value;
	var b = document.getElementById("pwd").value;
	var yz = document.getElementById("yanzheng").value;
	var c = "false";
	if (document.getElementById("checkbox").checked == true) {
		c = "true";
	}
	createXMLHttpRequest();
	if (!xmlHttp) {
		alert("XMLHttpRequest���󴴽�ʧ�ܣ�");
		return;
	}
	xmlHttp.open("post", "index.do", true);
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			if ("true" == xmlHttp.responseText) {
				window.location.href = " docs/bangdan.do?op=Bangdan";
			}
			if ("false" == xmlHttp.responseText) {
				document.getElementById("error").style.display = "block";
				document.all.name.value = "";
				document.all.pwd.value = "";
				// document.all.name.focus();
				document.getElementById("error").innerHTML = '<br><h4><font  color="red">�û������������</font></h4>';

			}
			if ("yz" == xmlHttp.responseText) {
				document.getElementById("error").style.display = "block";
				document.all.name.value = "";
				document.all.pwd.value = "";
				// document.all.name.focus();
				document.getElementById("error").innerHTML = '<br><h4><font  color="red">��֤���������������</font></h4>';
			}

		} else {

		}
	}
	xmlHttp.send("op=LoginIf&name=" + a + "&pwd=" + b + "&ifzhong=" + c
			+ "&yanzheng=" + yz);
}