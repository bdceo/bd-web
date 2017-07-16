
var lastCartUpdate = 0;

function addToCart(itemCode) {
	var itemNum = document.getElementById(itemCode).value.trim();
	if (itemNum == "" || isNaN(itemNum) || itemNum < 1) {
		alert("Please input a valid number!");
	} else {
		var xmlHttp = newXMLHttpRequest();
		xmlHttp.onreadystatechange = getReadyStateHandler(xmlHttp, addUpdate);
		xmlHttp.open("POST", "/cart", true);
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttp.send("action=add&item="+itemCode+"&count="+itemNum);
	}
}

String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, ""); 
}

function removeFromCart(itemCode){
	var xmlHttp = newXMLHttpRequest();
	xmlHttp.onreadystatechange = getReadyStateHandler(xmlHttp, removeUpdate);
	xmlHttp.open("POST", "/cart", true);
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xmlHttp.send("action=remove&item="+itemCode);
}

function addUpdate(cartXML) {
	var hasTB = false;
	var cartTbodyE = document.getElementById("cartTbody");

	var cart = cartXML.getElementsByTagName("cart")[0];
	var generated = cart.getAttribute("generated");
	if (generated > lastCartUpdate) {
	  	lastCartUpdate = generated;
		var item = cart.getElementsByTagName("item")[0];
		var name = item.getElementsByTagName("name")[0].firstChild.nodeValue;
		var quantity = item.getElementsByTagName("quantity")[0].firstChild.nodeValue;
		var itemCode = item.getAttribute("code");
		if (cartTbodyE.rows.length > 0) {
			for(var i = 0; i < cartTbodyE.rows.length; i++) {
				if (cartTbodyE.rows[i].childNodes[0].childNodes[0].nodeValue == name) {
					cartTbodyE.rows[i].childNodes[1].childNodes[0].nodeValue = quantity;
					hasTB = true;
					break;
				}
			}
		}
		if (!hasTB) {
			var newTr = document.createElement("tr");
			var newTdName = document.createElement("td");
			var newTdQuan = document.createElement("td");
			var newTdButton = document.createElement("td");
			newTdButton.innerHTML = "<button onclick='removeFromCart(\""+itemCode+"\")'>从购物车删除</button>";
			newTdName.innerHTML = name;
			newTdQuan.innerHTML = quantity;
			newTr.appendChild(newTdName);
			newTr.appendChild(newTdQuan);
			newTr.appendChild(newTdButton);
			cartTbodyE.appendChild(newTr);
		}
	}
 	document.getElementById("total").innerHTML = cart.getAttribute("total");
}

function removeUpdate(cartXML) {
	var cartTbodyE = document.getElementById("cartTbody");

	var cart = cartXML.getElementsByTagName("cart")[0];
	var generated = cart.getAttribute("generated");
	if (generated > lastCartUpdate) {
		var item = cart.getElementsByTagName("item")[0];
		var name = item.getElementsByTagName("name")[0].firstChild.nodeValue;
		if (cartTbodyE.rows.length > 0) {
			for(var i = 0; i < cartTbodyE.rows.length; i++) {
				if (cartTbodyE.rows[i].childNodes[0].childNodes[0].nodeValue == name) {
					cartTbodyE.removeChild(cartTbodyE.rows[i]);
					break;
				}
			}
		}
	}
 	document.getElementById("total").innerHTML = cart.getAttribute("total");
}
