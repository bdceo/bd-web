define(function(require, exports) {

	// 通过 require 引入依赖
	var $ = require("jquery");
	console.log($("#hello").html());

	// 引入依赖
	var bdu = require("bdu");
	bdu.hello();
	bdu.bye();

	// 暴露接口
	exports.main = function() {
		console.log("main start...");
	}
});