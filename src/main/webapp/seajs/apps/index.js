define(function(require, exports) {
	var util = require("../common/utils.js");

	exports.init = function() {
		util.log(Date.now());
		
		$(".hide").each(function(){
			$(this).hide();
		});
		
		$(".check_buy").each(function(){
			var id = $(this).attr("id")
			console.log(id);
			
			$(this).html(id);
		});
		
		$(".show").click(function(){
			var gid = $(this).attr("gid");
			console.log("show:"+gid);
			
			$("#show_"+gid).hide();
			$("#hide_"+gid).show();
		});

		$(".hide").click(function(){
			var gid = $(this).attr("gid");
			console.log("hide:"+gid);
			
			$("#show_"+gid).show();
			$("#hide_"+gid).hide();
		});
	};
});