
var xmlHttp;
function createXMLHttpRequest() {
	if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
}
function addNew() {
	var arg0, arg1, arg2, arg3, arg4, arg5;
	arg0 = document.all.userName.value;
	arg1 = document.all.password.value;
	arg2 = document.all.department.value;
	arg3 = document.all.headship.value;
	arg4 = document.all.sex.value;
	arg5 = document.all.old.value;
	var newuser = new User(arg0, arg1, arg2, arg3, arg4, arg5);
	var userAsJSON = JSON.stringify(newuser);
	createXMLHttpRequest();
	xmlHttp.open("POST", "AddUser", true);
	xmlHttp.onreadystatechange = process;
	xmlHttp.send(userAsJSON);
}
function process() {
	var user, arg0, arg1, arg2, arg3, arg4, arg5;
	if (xmlHttp.readyState == 4) {
		if (xmlHttp.status == 200) {
				//user = JSON.parse(xmlHttp.responseText);
			var data = xmlHttp.responseText;
			alert(data);
			var obj=eval('(' + data + ')');		 
			var users=obj.uss;
			alert(users.length);
			for(var i=0;i<users.length;i++){
				user=users[i];
				//alert(user.name);
				arg0 = user.name;
				arg1 = user.pwd;
				arg2 = user.dp;
				arg3 = user.head;
				arg4 = user.sex;
				arg5 = user.old;
				updateTable(arg0, arg1, arg2, arg3, arg4, arg5);	
			}
		}
	}
}
function User(userName, password, department, headship, sex, old) {
	this.userName = userName;
	this.password = password;
	this.department = department;
	this.headship = headship;
	this.sex = sex;
	this.old = old;
}
function updateTable(arg0,arg1,arg2,arg3,arg4,arg5){
	    //�ڱ��ĩβ����һ��
	    document.all.userTable.insertRow(-1);
	    //ȡ�õ�ǰ��������
		var rows = document.all.userTable.rows.length;
		//�������һ�еı�����Ϊ��ɫ
		document.all.userTable.rows[rows-1].bgColor="#ffffff";
		//�������һ�еĶ��뷽ʽ��Ϊˮƽ����
		document.all.userTable.rows[rows-1].align="center";
		//�ڲ����һ���в�������
		document.all.userTable.rows[rows-1].insertCell(-1);
		document.all.userTable.rows[rows-1].insertCell(-1);
		document.all.userTable.rows[rows-1].insertCell(-1);
		document.all.userTable.rows[rows-1].insertCell(-1);
		document.all.userTable.rows[rows-1].insertCell(-1);
		document.all.userTable.rows[rows-1].insertCell(-1);
		//������������������õ�������	
		document.all.userTable.rows[rows-1].cells[0].innerText=arg0;
		document.all.userTable.rows[rows-1].cells[1].innerText=arg1;
		document.all.userTable.rows[rows-1].cells[2].innerText=arg2; 
		document.all.userTable.rows[rows-1].cells[3].innerText=arg3;
		document.all.userTable.rows[rows-1].cells[4].innerText=arg4;
		document.all.userTable.rows[rows-1].cells[5].innerText=arg5; 			
 	}

