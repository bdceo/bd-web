
var xmlHttp;
function newXMLHttpRequest() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e1) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e2) {
					xmlHttp = false;
				}
			}
		}
	}
	return xmlHttp;
}
function getReadyStateHandler(req, responseXmlHandler) {
	return function () {
		if (req.readyState == 4) {
			if (req.status == 200) {
				responseXmlHandler(req.responseXML);
			} else {
				alert("HTTP error " + req.status + ": " + req.statusText);
			}
		}
	};
}

