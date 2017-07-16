var can;
var ctx;

var w;
var h;

var girlPic = new Image();
var starPic = new Image();

var num = 100;
var stars = [];

var lastTime;// 上次刷新时间 
var deltaTime; // 最近两次刷新时间间隔

var switchy = false;
var life = 0;

function init(){
	can = document.getElementById("canvas");
	ctx = can.getContext("2d");
	
	w = can.width;
	h = can.height;
	
	document.addEventListener("mousemove", mousemove, false);
	
	girlPic.src = "src/girl.jpg";
	starPic.src = "src/star.png";
	
	for(var i = 0; i < num; i++){
		var obj = new starObj();
		stars.push(obj);
		stars[i].init();
	}
	
	lastTime = Date.now(); // 开始刷新
	
	gameloop(); 
}
// 页面加载完初始化
document.body.onload = init;

// 绘制canvas背景
function gameloop(){
	// 根据当前机器的性能，自动定时调用，所以不需要指定时间，高效于setTimeout，setInterval
	// 已通过commonFunctions.js 进行个浏览器适配封装
	window.requestAnimFrame(gameloop);
	
	// 记录刷新时间
	var now = Date.now();
	deltaTime = now - lastTime;
	lastTime = now;
	//console.log(deltaTime);
	
	drawBackground();
	drawGirl();
//	drawStar();
	drawStars();
	aliveUpdate();
}
//绘制背景
function drawBackground(){
	ctx.fillStyle = "#393350";
	ctx.fillRect(0, 0, w, h);		
}
//绘制图片
function drawGirl(){
	// drawImage(img, x, y);
	// x轴坐标正方向向右，y轴坐标正方向向下，(0,0)在canvas左上角
	ctx.drawImage(girlPic, 100, 150, 600, 300);	
}
// 监测鼠标移动事件，是否在图片范围内
function mousemove(e){
	if(e.offsetX || e.layerX){
		var px = (e.offsetX == undefined) ? e.layerX : e.offsetX;
		var py = (e.offsetY == undefined) ? e.layerY : e.offsetY;
		
		// 判断是否在图片范围内
		if(px > 100 && px < 700 && py > 150 && py < 450){
			switchy = true;
		}else{
			switchy = false;
		}
//		console.log(switchy); 
	} 
}



