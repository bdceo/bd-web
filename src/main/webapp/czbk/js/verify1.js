
// �����û���У��ķ���
function verify() {
	// 1,��ȡ�ı����е�����
	// document.getElementById("id");--dom��ʽ
	// jQuery��ʽ�Ĳ��ң������е�#����id���ԾͿ����ҵ�һ���ڵ㡣
	// jQuery�ķ������صĶ���jquery�Ķ��󣬿��Լ���������ִ��������jquery����
	var jqueryObj = $("#userName");
	//ͨ����ȡ�����Զ���ýڵ��ֵ
	jqueryObj.attr("value");
	//ֱ��ͨ��������ȡvalueֵ
	var userName=jqueryObj.val();

	// 2,���ı����е����ݷ��͸��������˵�servlet
	//ʹ��jQuery��XMLHttpRequest��������ķ�װ
	$.get("ajaxServer?name="+userName,null,callback);
	
	
}
//�ص�����
function callback(data){
	//alert("�������˵����ݷ����ˣ�");
	// 3,���ܷ������˷��ص�����
	alert(data);
	
	// 4,���������˷��ص����ݶ�̬����ʾ��ҳ����
	//$("#result").append(data);
	$("#result").html(data);
}