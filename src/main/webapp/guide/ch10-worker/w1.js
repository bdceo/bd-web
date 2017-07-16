// JavaScript Document
onmessage = function(event){
	var cap = 1000;
	var intArray = new Array(cap); 
	for(var i=0; i<cap; i++){
		intArray[i] = parseInt(Math.random()*cap);
	}
	
	var wk = new Worker("w2.js");
	wk.postMessage(JSON.stringify(intArray));
	
	wk.onmessage = function(event){
		postMessage(event.data);
	};
};