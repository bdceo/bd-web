function init() {
     setInterval(upd(), 1000);
    applicationCache.addEventListener("updateready", function() {
        if (confirm("本地缓存已被更新,需要刷新画面来获取应用程序最新版本，是否刷新？")) {
        // (3) 手工更新本地缓存
            applicationCache.swapCache();
            // 重载画面
            location.reload();
        }
    }, true);
	
    var msg=document.getElementById("msg");
    applicationCache.addEventListener("checking", function() {
        msg.innerHTML+="checking<br/>";
    }, true);
    applicationCache.addEventListener("noupdate", function() {
        msg.innerHTML+="noupdate<br/>";
    }, true);
    applicationCache.addEventListener("downloading", function() {
        msg.innerHTML+="downloading<br/>";
    }, true);
    applicationCache.addEventListener("progress", function() {
        msg.innerHTML+="progress<br/>";
    }, true);
    applicationCache.addEventListener("updateready", function() {
        msg.innerHTML+="updateready<br/>";  
    }, true);
    applicationCache.addEventListener("cached", function() {
        msg.innerHTML+="cached<br/>";          
    }, true);
    applicationCache.addEventListener("error", function() {
	msg.innerHTML+="error<br/>"; 
    }, true);
}
function upd(){
	// 手工检查是否有更新
    applicationCache.update();
}