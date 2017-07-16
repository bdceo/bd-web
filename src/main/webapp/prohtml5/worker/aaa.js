// JavaScript Document
function messageHandler(e){
	postMessage("Worker 说：" + e.data + " too");		
}
addEventListener("message", messageHandler, true);