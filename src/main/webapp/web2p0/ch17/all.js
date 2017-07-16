
function createAjaxObj() {
	var httprequest = false;
	if (window.XMLHttpRequest) { // if Mozilla, Safari etc
		httprequest = new XMLHttpRequest();
		if (httprequest.overrideMimeType) {
			httprequest.overrideMimeType("text/xml");
		}
	} else {
		if (window.ActiveXObject) { // if IE
			try {
				httprequest = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				try {
					httprequest = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) {
				}
			}
		}
	}
	return httprequest;
}
var ajaxObject;
function getPictures(category) {
	ajaxObject = createAjaxObj();
	ajaxObject.onreadystatechange = function () {
		changStateFunction(category);
	};
	var submitURL = "/picture?cate=" + category;
	ajaxObject.open("GET", submitURL, true);
	ajaxObject.send(null);
	var elmt = document.getElementById("container");
	elmt.innerHTML = "Loading";
}
function changStateFunction(category) {
	if (ajaxObject.readyState == 4) {
		if (ajaxObject.status == 200) {
			parasData(category);
		}
	}
}
function parasData(category) {
	var xmlData = ajaxObject.responseXML;
	var pictures = xmlData.getElementsByTagName("item");
	var result = "";
	for (var i = 0; i < pictures.length; i++) {
		var name = pictures[i].getElementsByTagName("name")[0].firstChild.nodeValue;
		var src = pictures[i].getElementsByTagName("url")[0].firstChild.nodeValue;
		var description = pictures[i].getElementsByTagName("description")[0].firstChild.nodeValue;
		result += "<a href=\"\"><img src=\"images/" + src + "\" alt=\"" + description + "\">" + name + "</a>";
	}
	var elmt = document.getElementById("container");
	elmt.innerHTML = result;
}
function switchStyle(file1, file2) {
	var cssfile = document.getElementsByTagName("link")[0];
	if (cssfile.getAttribute("href") == file1) {
		cssfile.setAttribute("href", file2);
	} else {
		cssfile.setAttribute("href", file1);
	}
}

