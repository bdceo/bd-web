
//http://hi.baidu.com/hack_lei/blog/item/fb853a31c67c121debc4af11.html

// 水果分类及属性定义:索引,赔率,名称
var elem = [{"id":0,"pl":50,"gl":1/20,"name":"猕猴桃","img":"images\/shuiguo_76.png","on_img":"images\/shuoguo_76.png"},
			{"id":1,"pl":40,"gl":1/20,"name":"香橙", "img":"images\/shuiguo_73.png","on_img":"images\/shuoguo_73.png"},
			{"id":2,"pl":30,"gl":1/20,"name":"葡萄", "img":"images\/shuiguo_70.png","on_img":"images\/shuoguo_70.png"},
			{"id":3,"pl":25,"gl":2/20,"name":"荔枝", "img":"images\/shuoguo_50.png","on_img":"images\/shuiguo_50_50.png"},
			{"id":4,"pl":20,"gl":3/20,"name":"草莓", "img":"images\/shuoguo_57.png","on_img":"images\/shuiguo_50_57.png"},
			{"id":5,"pl":15,"gl":3/20,"name":"鸭梨", "img":"images\/shuoguo_55.png","on_img":"images\/shuiguo_50_55.png"},
			{"id":6,"pl":10,"gl":4/20,"name":"香蕉", "img":"images\/shuoguo_60.png","on_img":"images\/shuiguo_50_60.png"},
			{"id":7,"pl":5, "gl":5/20,"name":"苹果", "img":"images\/shuoguo_53.png","on_img":"images\/shuiguo_50_53.png"}];
// 水果机分布,左上角第一个开始,对应category中的id
var eleQueue  = [{"id":0,"refe":7},
 			     {"id":1,"refe":6},
				 {"id":2,"refe":5},
 				 {"id":3,"refe":4},
				 {"id":4,"refe":3},
				 
				 {"id":5,"refe":6},				 
				 {"id":6,"refe":4},
				 {"id":7,"refe":7},
				 {"id":8,"refe":2},
				 {"id":9,"refe":7},
				 
				 {"id":10,"refe":6},
				 {"id":11,"refe":5},				 
				 {"id":12,"refe":7},
				 {"id":13,"refe":5},
				 {"id":14,"refe":6},
				 
				 {"id":15,"refe":3},				 
				 {"id":16,"refe":7},
				 {"id":17,"refe":0},
				 {"id":18,"refe":1},
				 {"id":19,"refe":4}];
// 用户分数
var userScore;
// 一圈总共多少个水果
var sumEle;
// 当前选中的水果
var curEle;
// 1,押注;2,旋转
var curState;
// 押注项
var eleBet = [];
var normal_ = 400, fast_ = 70, slow_ = 600;
var normal_t = 0, fast_t = 0, slow_t = 0; 
var media;
// 第一次加载页面，初始化。。。
function init(){
	userScore = 100;
	$("#totalScore").val(userScore);
	curState = 1; 
	
	sumEle = eleQueue.length; 
	curEle = eleQueue[parseInt(Math.random() * (sumEle-1))];
	$("#i"+curEle.id).attr("src", elem[curEle.refe].on_img);
	
	media = document.getElementById("media");	
}
var ih;// 定时器
// 开始选水果
function startRolling(){
	if(curState > 1 ) return;
	if(checkBet()){
		curState = 2;
		calcRollingTime(); 
		$("#winScore").empty().val(0);
		ih = setInterval("fruitRolling()", normal_);
		setTimeout("rollingFaster()",normal_t);  
	}else{
		alert("请先押注。。。");
	}
}
// 计算转动时间
function calcRollingTime(){
	normal_t = Math.random() * 3 * 1000;
	var r = Math.random() * 5;
	while(r <= 3){
		r = Math.random() * 5;
	}
	fast_t = r * 1000;
	while(!(r>=2 && r<5)){
		r = Math.random() * 5;
	}
	slow_t = r * 1000;
}
// 水果机转动
function fruitRolling(){
	// 当前变暗
	var index = parseInt(curEle.id);
	$("#i"+index).attr("src", elem[curEle.refe].img);
	
	// 下一个变亮
	index++;
	if(index > 19) index = 0;
	curEle = eleQueue[index];
	$("#i"+index).attr("src", elem[curEle.refe].on_img);
	// 播放声音
	media.play();
}
// 加快
function rollingFaster(){
	clearInterval(ih); 
	ih = setInterval("fruitRolling()", fast_);	
	setTimeout("rollingSlower()",fast_t);			
}
// 减速
function rollingSlower(){
	clearInterval(ih); 
	ih = setInterval("fruitRolling()", slow_);	
	setTimeout("stopRolling()",slow_t);		
}
// 停止
function stopRolling(){
	clearInterval(ih);	
	// 是否压中
	var id = curEle.refe;// 当前停止的水果
	var ic = 0;
	var bs = eleBet.length;
	for(var i = 0; i < bs; i++){
		if(eleBet[i].id == id){
			ic = eleBet[i].ct;
			break;
		}
	}
	if(ic > 0){
		var add = ic * elem[id].pl;
		$("#winScore").empty().val(add);
		focusAnimal(curEle);
		alert("恭喜，压中！！！");
		addScore(add);
	}
	resetBet();
}
// 分数相关： 加分/减分
function addScore(s){
	userScore += s;$("#totalScore").val(userScore);
} 
function redScore(s){
	userScore -= s;$("#totalScore").val(userScore);
}
// 选中后闪动效果
function focusAnimal(curEle){
	ih = setInterval(function(){		
		$("#i"+curEle.id).attr("src", elem[curEle.refe].img);
		$("#i"+curEle.id).attr("src", elem[curEle.refe].on_img);
	},200);
	setTimeout(function(){
		clearInterval(ih);		
	},2000);
}
// 加压
function addBet(i){
	if(curState > 1) return;
	if(userScore == 0){
		alert("没钱啦！！！");
	}
	var o = parseInt($("#e"+i).val());
	// 冒泡效果
	$("#e"+i).val(++o);
	redScore(1);// 总分减1
}
// 是否有押注
function checkBet(){
	var f = false;
	for(var i = 0 ;i < elem.length; i++){
		if($("#e"+i).val() != "0"){
			f = true; 
			eleBet.push({"id":i,"ct":$("#e"+i).val()});
		}
	}
	return f;
}
// 清空所有押注
function resetBet(){
	$(".ib").empty().val(0);
	eleBet = [];
	curState = 1;
}