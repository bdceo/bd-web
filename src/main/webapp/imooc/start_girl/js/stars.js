// 定义一个星星绘制相关的类
var starObj = function(){
	this.x;
	this.y;	
	
	this.picNo;
	this.timer;
	
	// 随机位移
	this.xSpd;
	this.ySpd;
}

starObj.prototype.init = function(){
	this.x = Math.random() * 600 + 100 ; // Math.random() 返回[0,1]
	this.y = Math.random() * 300 + 150;
	
	this.picNo = Math.floor(Math.random() * 7); // 0.3,0.6 >> 1
	this.timer = 0;
	
	this.xSpd = Math.random() * 3 - 1.5; // [1.5, 1.5]
	this.ySpd = Math.random() * 3 - 1.5; 
}

starObj.prototype.update = function(){
	this.x += this.xSpd * deltaTime * 0.004;
	this.y += this.ySpd * deltaTime * 0.004;	
	
	// 超出范围，重生
	if(this.x < 100 || this.x > (700-7) ){
		this.init();
		return;
	}
	if(this.y < 150 || this.y > (450-7) ){
		this.init();
		return;
	}
	
	this.timer += deltaTime;
	if(this.timer > 50){
		this.picNo += 1;
		this.picNo %= 7;
		this.timer = 0;
	}
//	this.picNo += 1;
//	if(this.picNo >= 7){
//		this.picNo = 0;
//	}
}

starObj.prototype.draw = function(){
	// drawImage(img, sx, sy, swidth, sheight, x, y, width, height);
//	ctx.drawImage(starPic, this.x , this.y);
//	ctx.drawImage(starPic, 0, 0, 7, 7, this.x , this.y, 7, 7);
//	ctx.drawImage(starPic, 21, 0, 7, 7, this.x , this.y, 7, 7);
	// picNo 图片像素7的倍数更新，改变星星的大小显示
//	ctx.drawImage(starPic, this.picNo * 7, 0, 7, 7, this.x , this.y, 7, 7);
	
	// save() , save,restore成对出现，之内的代码只在当前代码段内生效
	ctx.save();
	
	// globalAlpha 全局透明度
	ctx.globalAlpha = life; // [0, 1]
	
	// drawImage()
	ctx.drawImage(starPic, this.picNo * 7, 0, 7, 7, this.x , this.y, 7, 7);
	
	// restore()
	ctx.restore();
}

// 绘制多个星星
function drawStars(){
	for(var i = 0; i < num; i++){
		stars[i].update();
		stars[i].draw();
	}
}
// 鼠标在图片上显示星星
function aliveUpdate(){
//	console.log(switchy);
	if(switchy){
		life += 0.03 * deltaTime * 0.05;
		if(life > 1){
			life = 1;
		}
	}else{
		life -= 0.03 * deltaTime * 0.05;
		if(life < 0){
			life = 0;
		}
	}
}

// 绘制一个星星
function drawStar(){
	ctx.drawImage(starPic, 300, 400);
}

