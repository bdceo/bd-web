// ��ʾ����Ԫ�ص�����
var highlightindex = -1;
$(document).ready(function() {
	var wordInput = $("#word");
	var autoNode = $("#auto");
	var timeOutId;
	var wordInputOffset = wordInput.offset();// ������λ������
	// ȷ���������λ��
	autoNode.hide().css("border", "1px black solid")
			.css("position", "absolute").width(wordInput.width() + 5).css(
					"left", wordInputOffset.left + "px").css("top",
					wordInputOffset.top + wordInput.height() + 5 + "px");
	wordInput.keyup(function(event) {// �����ı����еļ����¼�
				var autoNodes = autoNode.children("div");// ��ȫ���������ʾ
				var myEvent = event || window.event;
				var keyCode = myEvent.keyCode;
				// ���µ�����ĸ��,�˸��del��
				if (keyCode >= 65 && keyCode <= 90 || keyCode == 8
						|| keyCode == 46) {
					var word = $(this).val();
					if (word != "") {
						//���ϴ�δ��ɵ���ʱ��������ȡ��
						clearTimeout(timeOutId);
						//���ڷ������˽��н����ӳ�500ms
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
											// �����������ڵ��¼�
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
				} else if (keyCode == 38 || keyCode == 40) {// ���뵼����ʱ
					if (keyCode == 38) {// ����
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
					if (keyCode == 40) {// ����
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
				} else if (keyCode == 13) {// ���»س�ʱ
					if (highlightindex != -1) {
						var comText = autoNodes.eq(highlightindex).text();
						autoNode.hide("slow");
						highlightindex = -1;
						wordInput.val(comText);
					} else {
						alert("��̨���ݴ�����...");
						autoNode.hide();
						wordInput.get(0).blur();
					}
				}
			});
	$(":button").click(function() {
				alert("��̨���ݴ�����...");
			});
});
