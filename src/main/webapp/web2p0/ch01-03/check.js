var http_request = false ;

function send_request(){
	var loginname=document.getElementById("userName").value;
	url="../ch03/check.jsp?userName="+loginname;
	http_request = false ;
	if(window.XMLHttpRequest){
		http_request = new XMLHttpRequest();
		if(http_request.ovverideMimeType){
			http_request.ovverideMimeType('text/xml');
		}
	}
	else if(window.ActiveXObject){
		try{
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){}
		}
	}
	if(!http_request){
		return false ;
	}
	http_request.onreadystatechange = callback;
	http_request.open("GET",url,true);
	http_request.send(null);
}

function callback(){ 
	if(http_request.readyState == 4){
		if(http_request.status == 200 ){
			displays();
		}else{
			alert(http_request.statusText);	
		}
	}else{
		document.getElementById("div").style.display = "";
	}
}
function displays(){
	var div = document.getElementById("div");
	div.innerHTML = http_request.responseText ;	
}
function docheck(){
	var loginname=document.getElementById("userName").value;
	if(loginname==""){
		document.getElementById("div").style.display = "none";
		return false;
	}else{
		document.getElementById("div").innerHTML = "<img src='../images/ajax-loader.gif'>";
		//document.getElementById("div").style.display = "block";
		send_request();	
	}
}