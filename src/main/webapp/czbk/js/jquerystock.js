var obj;
var sid;
$(document).ready(function() {
	var stockNode = $("#stock").css("border", "1px solid black").width("100px")
			.css("position", "absolute").css("z-index", "4").css("background-color","#fafafa");
	stockNode.hide();
	check();//加载股票信息
	var as = $("a");
	as.mouseover(function(event) {
				var aNode = $(this);
				var divNode = aNode.parent();
				sid = divNode.attr("id");
				dis();
				// 控制弹出框的位置
				//var offset = aNode.offset();
				//stockNode.css("left", offset.left + "px").css("top",
				//		offset.top + aNode.height() + "px");
				
				// 出现在鼠标的旁边
				var myEvent=event||windows.event;
				stockNode.css("left", myEvent.clientX+5 + "px").css("top",
						myEvent.clientY +5+ "px");
				stockNode.show();
			});
	as.mouseout(function() {
				stockNode.hide();
			});	
	setInterval(check, 1000);
});

function check() {
	$.get("stock", null, function(data) {
				obj = eval(data);
				var szzs = obj["3000012"];// obj.3000012
				var pufy = obj["2000920"];
				var sp1 = $("#3000012").children("span");
				sp1.html(szzs.now);
				if (szzs.now > szzs.yes) {
					sp1.css("color", "red");
				} else {
					sp1.css("color", "green");
				}
				var sp2 = $("#2000920").children("span");
				sp2.html(pufy.now);
				if (pufy.now > pufy.yes) {
					sp2.css("color", "red");
				} else {
					sp2.css("color", "green");
				}
				dis();
			});
}
function dis() {
	var stock = obj[sid];
	for (var property in stock) {
		if (property != "name") {
			$("#" + property).children("span").html(stock[property]);
		}
	}
}