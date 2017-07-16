function showwin() {
	var winNode = $("#win");
	// jquery¸Ä±äcssÄÚÈÝ
	// winNode.css("display","block");
	// winNode.show("slow");
	$("#win").fadeIn(1500);
}

function hide() {
	var winNode = $("#win");
	// winNode.css("display","none");
	// winNode.hide("slow");
	winNode.fadeOut(1500);
}

