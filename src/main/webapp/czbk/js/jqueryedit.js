$(document).ready(function() {
	var tds=$("td");
	tds.click(tdClick);
});
function tdClick(){
		var td=$(this);
		//ȡ����ǰtd�е����ݣ����浽��ʱ������
		var text=td.text();
		//���td�������
		td.html("");//td.empty();
		//����һ���ı���Ҳ����inputԪ��
		var input=$("<input>");
		//�����ı����ֵ
		input.attr("value",text);
		input.keyup(function(event){
			var myEvent=event||window.event;
			var kcode=myEvent.keyCode;
			if(kcode==13){
				var inputNode=$(this);
				var inputText=inputNode.val();
				var tdNode=inputNode.parent();
				tdNode.html(inputText);
				tdNode.click(tdClick);
			}
		}); 
		//���ı�����뵽td��
		td.append(input);
		//���ѡ���ı������¼�
		var inputDom=input.get(0);
		inputDom.select();
		//�Ƴ�td��click�¼�
		td.unbind("click");
}