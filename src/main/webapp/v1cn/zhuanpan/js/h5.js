
google.load("jquery", "1.3.1");
google.setOnLoadCallback(function()
{
	var rolling = false;
	var perAng = 30;
	var startAng = 180;
	var stopAng = 180;
	var totalAng = 0;
	var vc = 0; 
	
	$("#resetBtn").click(function(){
		resetAll();
	});
	$("#startBtn").click(function() {
		if(rolling){// pause or stop rolling
			rolling = false;
			var interHandler = $(".zhizhen").data("intervalHandle");
			clearInterval(interHandler);
			$(".zhizhen").stop().animate({rotate:"+=" + stopAng + "deg"} ,3000 ,"easeOutCubic",function(){
				totalAng += stopAng;
				calcTotalAng();
				startWork(totalAng/30,vc);
			});
		}else{// start rolling
			if(vc<4){
				resetRolling();
				rolling = true;
				totalAng = 0;
				vc++;
				
				$(".zhizhen").data("rotaAng", perAng);
				startRolling($(".zhizhen"));
			}else{
				alert("不要太贪玩儿哦！够4次了。");
			}
		}
	});
	
	function startRolling(obj){
		obj.stop().animate({rotate: "+=" + startAng + "deg"}, 1500, "easeInCubic", function(){
			totalAng += startAng;
			var interHandler = setInterval(function(){
				obj.animate({rotate: "+=" + obj.data("rotaAng") + "deg"},0);
				totalAng += perAng;
				calcTotalAng();
			},80);
			obj.data("intervalHandle",interHandler);
		});
	}
	
	function calcTotalAng(){
		totalAng = (totalAng>=360)?(totalAng - 360):totalAng;
	}	
	
	function resetRolling(){
		if(totalAng != 0){
			$(".zhizhen").animate({rotate: "+=" + (360-totalAng) + "deg"},0);
		}
	}
	
	function startWork(num,i){
		var t = num==0 ? 12 : num;
		$("#v"+i).val(t);
		var interHandler = setInterval(function(){
	        var ms = (new Date()).getTime();
	        var bs = parseInt($("#v"+i).val());
	        $("#r"+i).empty().val(ms + (bs * 4444));
		},500);
		$("#v"+i).data("intervalHandle",interHandler);
	}
	
	function resetAll(){
		vc = 0;
		for(var i=1; i<5; i++){
			clearInterval($("#v"+i).data("intervalHandle"));
			$("#v"+i).val("");
			$("#r"+i).val("");
		}
	}
});