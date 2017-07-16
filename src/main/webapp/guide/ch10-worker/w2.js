// JavaScript Document
onmessage = function(event){ 
	var returnStr = "";
	var intArray = JSON.parse(event.data);
	for(var i=0; i<intArray.length; i++){
		if( (parseInt(intArray[i]) % 3) == 0){
			if(returnStr != ""){
				returnStr += ";";
			}
			returnStr += intArray[i];
		}
	}
	postMessage(returnStr);
	close();// 关闭子线程
};