/**
 *	List数据结构，同java中类似，注意的立面有一个equals_rule是用来定义命名规则的
 *
 *	1.查看用户是否存在，针对数组
 *	2.删除指定用户，针对数组
 *	3.添加用户，针对数组
 */

function List(){
	this.aElement;
	if (arguments.length == 0) {
		this.aElement = new Array();
	}else{
		this.aElement = arguments[0];
	}
	return this;
}

List.prototype = {
		"remove" : function(element){
			var index = this.indexOf(element);
			if(index != -1){
				for(var i = index;i < this.aElement.length -1; i++){
					this.aElement[i] = this.aElement[i + 1];
				}
				this.aElement.splice(this.aElement.length -1,1);
			}			
		},
		"clear" : function(){
			this.aElement.splice(0,this.aElement.length);
		},
		"add" : function(element){
			if(!this.contain(element)){
				this.aElement[this.aElement.length] = element;
			}
		},
		"contain" : function(element){
			return this.indexOf(element) != -1;
		},
		"indexOf" : function(element){
			var index = -1;
			for(var i = 0 ; i < this.aElement.length; i++){
				if(this.equalsRule(this.aElement[i],element)){
					index = i;
					break;
				}
			}
			return index;
		},
		"toArray" : function(){
			return this.aElement;
		},
		//深度拷贝
		"copy" : function(list){
			list.clear();
			var arr = this.aElement;
			for(var ele in arr){				
				var obj = new Object();
				for(var a in arr[ele]){
					obj[a] = arr[ele][a];					
				}				
				list.add(obj);					
			}
		},
		/*
		//将list变成一个json数组 [{"user_id":1...},{...}] 
		"toJson" : function(){
			var arr = this.aElement;
			var json;
			json = "["; 
			for(var index in arr){
				json += "{"
				for(var key in arr[index]){
					var value = arr[index][key];
					if(typeof(value) == 'number')
						json += "\""+key+"\":"+value+",";
					if(typeof(value) == 'string')
						json += "\""+key+"\":\""+value+"\",";
				}
				json = json.substring(0,json.length-1);
				json += "},"
			}
			json = json.substring(0,json.length-1);
			json += "]";
			return json;
		},
		*/
		//依赖于jquery-json.js
		"toJson" : function(){
			var arr = this.aElement;
			var json = $.toJSON(arr);
			json = eval(json);
			return json;
		},
		//如果是比价其他字段，可以修改此方法
		"get" : function(id){
			var obj = {"id" : id};
			var index = this.indexOf(obj);
			if(index != -1){
				return this.aElement[index];
			}else{
				return null;
			}			
		},
		//比较规则,可以在覆盖此方法
		"equalsRule" : function(e1,e2){
			return e1.id == e2.id
		}
		
	}
	
	//group,user都是List,注意该类是依赖于DcsUserGroup里面字段数量的，如果它发生改动，类也需要做相应的调整
	function XList(group,user){
		this.group = group;
		this.user = user;		
	}
	XList.prototype = {
		"getFieldLength" : function(obj){
			var length = 0;
			for(var o in obj){
				length++;
			}
			return length;
		},
		//listx为最先打印的
		//这个数组每个成员 id ,name , desc, type
		//group 只有五个字段，而user大于5个字段
		"toArray" : function(){
			var arrx = this.group.toArray();
			var arry = this.user.toArray();
			var arrz = new Array(arrx.length + arry.length);
			var index = 0 ;

			for(var g in arrx){
				arrz[index++] = {"id":g.user_group_id,"name":g.group_name,"desc":"","type":"group"};
			}
			for(var u in arry){
				arrz[index++] = {"id":u.user_id,"name":u.user_name,"desc":"","type":"user"};
			}
			return arrz;
		},
		"add" : function(obj){
			var length = this.getFieldLength(obj);
			if(length!=5){
				//user
				user.add(obj);
			}else{
				//group
				group.add(obj);
			}
		},
		"remove" : function(obj){
			var length = this.getFieldLength(obj);
			if(length!=5){
				//user
				user.remove(obj);
			}else{
				//group
				group.remove(obj);
			}
		},
		"clear" : function(){
			this.group.clear();	
			this.user.clear();	
		}
	}
	
	


