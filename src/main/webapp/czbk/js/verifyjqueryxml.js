
// �����û���У��ķ���
function verify() {
	// 1,��ȡ�ı����е�����
	// document.getElementById("id");--dom��ʽ
	// jQuery��ʽ�Ĳ��ң������е�#����id���ԾͿ����ҵ�һ���ڵ㡣
	// jQuery�ķ������صĶ���jquery�Ķ��󣬿��Լ���������ִ��������jquery����
	var jqueryObj = $("#userName");
	// ֱ��ͨ��������ȡvalueֵ
	var userName = jqueryObj.val();

	// 2,���ı����е����ݷ��͸��������˵�servlet
	// ʹ��jQuery��XMLHttpRequest��������ķ�װ
	$.ajax({
				type : "POST",
				url : "AjaxXmlServlet",
				data : "name=" + userName,
				dataType : "xml",
				success : callback
			});

}
// �ص�����
function callback(data) {
	// 3,���ܷ������˷��ص�����
	// ��Ҫ��data���dom�����е����ݽ�������
	// ����Ҫ��dom�еĶ���ת����jQuery����
	var jqueryObj = $(data);
	//��ȡmessage�ڵ�
	var message = jqueryObj.children();
	//��ȡ�ı�����
	var text=message.text();
	// 4,���������˷��ص����ݶ�̬����ʾ��ҳ����
	$("#result").html(text);
}