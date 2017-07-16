$(document).ready(function() {
			var uas = $("ul > a");
			uas.click(function() {
						var ua = $(this);
						var lis = ua.nextAll("li");
						lis.toggle("slow");
					});
			$("li > a").click(function() {
						$("#content").load($(this).attr("id"));
					});
		});
function change1() {
	var uls = $("ul");
	uls.click(function() {
				var ulNode = $(this);
				var lis = ulNode.children("li");
				lis.toggle("slow");
			});
}
function change2() {
	var uas = $("ul > a");
	uas.click(function() {
				var ua = $(this);
				var lis = ua.nextAll("li");
				lis.toggle("slow");
			});
}