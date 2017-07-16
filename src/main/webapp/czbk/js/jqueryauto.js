// 表示高亮元素的索引
var highlightindex = -1;
$(document).ready(function() {
	var wordInput = $("#word");
	var autoNode = $("#auto");
	var timeOutId;
	var wordInputOffset = wordInput.offset();// 输入框的位置属性
	// 确定弹出框的位置
	autoNode.hide().css("border", "1px black solid")
			.css("position", "absolute").width(wordInput.width() + 5).css(
					"left", wordInputOffset.left + "px").css("top",
					wordInputOffset.top + wordInput.height() + 5 + "px");
	wordInput.keyup(function(event) {// 处理文本框中的键盘事件
				var autoNodes = autoNode.children("div");// 补全框的所有提示
				var myEvent = event || window.event;
				var keyCode = myEvent.keyCode;
				// 按下的是字母键,退格或del键
				if (keyCode >= 65 && keyCode <= 90 || keyCode == 8
						|| keyCode == 46) {
					var word = $(this).val();
					if (word != "") {
						//对上次未完成的延时操作进行取消
						clearTimeout(timeOutId);
						//对于服务器端进行交互延迟500ms
						timeOutId = setTimeout(function() {
							$.post("auto", {
										key : word
									}, function(data) {
										var jqueryObj = $(data);
										var wordNodes = jqueryObj.find("word");
										autoNode.empty();
										wordNodes.each(function(i) {
											var wordNode = $(this);
											var newDiv = $("<div>").attr("id",
													i);
											newDiv.html(wordNode.text())
													.appendTo(autoNode);
											// 增加鼠标高亮节点事件
											newDiv.mouseover(function() {
												if (highlightindex != -1) {
													autoNodes
																.eq(highlightindex)
															.css(
																	"background-color",
																	"red");
												}
												highlightindex = $(this)
														.attr("id");
												$(this).css("background-color",
														"red");
											});
											newDiv.mouseout(function() {
														highlightindex = $(this)
																.attr("id");
														$(this)
																.css(
																		"background-color",
																		"white");
													});
											newDiv.click(function() {
														var comText = $(this)
																.text();
														autoNode.hide("slow");
														highlightindex = -1;
														wordInput.val(comText);
													});
										});
										if (wordNodes.length > 0) {
											autoNode.show("slow");
										} else {
											autoNode.hide("slow");
											highlightindex = -1;
										}
									}, "xml");
						}, 500);
					} else {
						autoNode.hide("slow");
						highlightindex = -1;
					}
				} else if (keyCode == 38 || keyCode == 40) {// 输入导航键时
					if (keyCode == 38) {// 向上
						if (highlightindex != -1) {
							autoNodes.eq(highlightindex).css(
									"background-color", "white");
							highlightindex--;
						} else {
							highlightindex = autoNodes.length - 1;
						}
						if (highlightindex == -1) {
							highlightindex = autoNodes.length - 1;
						}
						autoNodes.eq(highlightindex).css("background-color",
								"red");
					}
					if (keyCode == 40) {// 向下
						if (highlightindex != -1) {
							autoNodes.eq(highlightindex).css(
									"background-color", "white");
						}
						highlightindex++;
						if (highlightindex == autoNodes.length) {
							highlightindex = 0;
						}
						autoNodes.eq(highlightindex).css("background-color",
								"red");
					}
				} else if (keyCode == 13) {// 按下回车时
					if (highlightindex != -1) {
						var comText = autoNodes.eq(highlightindex).text();
						autoNode.hide("slow");
						highlightindex = -1;
						wordInput.val(comText);
					} else {
						alert("后台数据处理中...");
						autoNode.hide();
						wordInput.get(0).blur();
					}
				}
			});
	$(":button").click(function() {
				alert("后台数据处理中...");
			});
});
