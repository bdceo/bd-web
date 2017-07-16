var req;
var url;

function startup() {
	document.forms[0].subscriptionID.focus = true;
}

function init() {
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var url = "/library";
	req.open("POST", url, true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
}

function validate(formObj) {
	init();
	req.onreadystatechange = subscriptionValidator;
	alert(formObj.subscriptionID.value);
	req.send("subscriptionID=" + formObj.subscriptionID.value);
}

function displayList(field) {
	init();
	titles.innerHTML = " ";
	req.onreadystatechange = listHandler;
	req.send("select=" + escape(field));
}

function displayTitles(formObj) {
	init();
	var index = formObj.list.selectedIndex;
	var val = formObj.list.options[index].value;
	req.onreadystatechange = titlesHandler;
	req.send("list=" + val);
}

function subscriptionValidator() { 
	if (req.readyState == 4) {
		if (req.status == 200) {
			var messageObj = req.responseXML.getElementsByTagName("message")[0];
			var message = messageObj.childNodes[0].nodeValue;
			var msg=document.getElementById("msg");
			if (message == "true") {
				msg.innerHTML = "此类型图书存在";
				document.forms[0].order.disabled = false;
			} else {
				msg.innerHTML = "此类型图书不存在";
				document.forms[0].order.disabled = true;
			}
		}
	}
}


function titlesHandler() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var titles = document.getElementById("titles");
			var indexObj = req.responseXML.getElementsByTagName("index")[0];
			var index = indexObj.childNodes[0].nodeValue;
			
		
			var temp = "<select name=\"titles\" multiple>";

			for (var i=0; i<index; i++) {
				var listObj = req.responseXML.getElementsByTagName("list")[i];
				temp = temp + "<option value=" + i +">" + listObj.childNodes[0].nodeValue + "</option>";
			}

			temp = temp + "</select>";
			titles.innerHTML = temp;
			
		}
	}
}

function listHandler() {
	var prefix;
	if (req.readyState == 4) {
		if (req.status == 200) {
			var list = document.getElementById("list");
			var authorOption = document.getElementById("select")
			if (authorOption.checked) {
				prefix = "A";
			} else {
				prefix = "P";
			}
			var list = document.getElementById("selectionList");
			var indexObj = req.responseXML.getElementsByTagName("index")[0];
			var index = indexObj.childNodes[0].nodeValue;
			var temp = "<select name=\"list\" onchange=\"displayTitles(this.form)\">";
			for (var i=0; i<index; i++) {
				var listObj = req.responseXML.getElementsByTagName("list")[i];
				temp = temp + "<option value=" + prefix + i +">" + listObj.childNodes[0].nodeValue + "</option>";
			}

			temp = temp + "</select>";
			list.innerHTML = temp;
		}
	}
}


