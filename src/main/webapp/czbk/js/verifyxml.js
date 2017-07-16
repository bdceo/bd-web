var xmlHttp;
// �û�У��ķ���
// ���������ʹ��XMLHTTPRequest����������Ajax���첽���ݽ���
function verify() {
	// 0��ʹ��dom�ķ�ʽ��ȡ�ı����е�ֵ
	var name = document.getElementById("userName").value;
	// 1������XMLHTTPRequest����
	if (window.XMLHttpRequest) {// Firefox,Mozillar,IE7-8,Opera,Safari
		xmlHttp = new XMLHttpRequest();
		// ���ĳЩ�ض��汾��Mozillar�������bug��������
		if (xmlHttp.overrideMimeType) {
			xmlHttp.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {// IE6����
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
	// ȷ��xmlHttp�����Ƿ񴴽��ɹ�
	if (!xmlHttp) {
		alert("XMLHttpRequest���󴴽�ʧ�ܣ�");
		return;
	}
	// 2��ע��ص�����,ֻ��Ҫ����������Ҫ������
	xmlHttp.onreadystatechange = callBack;
	// 3������������Ϣopen(get/post,url,true/false)
	// xmlHttp.open("GET", "AjaxXmlServlet?name=" + name, true);
	// 4���������ݣ���ʼ�ͷ������˽��н���
	// xmlHttp.send(null);

	// post����ʽ,��Ҫ�Լ�����http������ͷ
	xmlHttp.open("POST", "AjaxXmlServlet", true);
	xmlHttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");
	xmlHttp.send("name=" + name);
}
function callBack() {
	// 5��������Ӧ����
	// �ж�xmlHttp״̬���Ѿ�������ɣ��Լ������״̬Ϊ����
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
			var data = xmlHttp.responseXML;
			if (data) {
				// <message>msg</message>,����getElementByTagName��ȡ�ڵ�,��������
				var nodes = data.getElementsByTagName("message");			
				if (nodes.length > 0) {
					var dis = document.getElementById("result");
					var msg = nodes[0].firstChild.nodeValue;
					//dis.innerHTML = msg;
					dis.textContent=msg;
				} else {
					alert("xml���ݸ�ʽ����ԭʼ�ļ�������Ϊ��" + xmlHttp.responseText);
				}
			} else {
				alert("�������ݴ���");
			}
		}
	}
}
