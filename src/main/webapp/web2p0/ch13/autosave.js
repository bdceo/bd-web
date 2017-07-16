// 首先设置全局变量
// 要保存的内容对象FormContent
var FormContent = null;
// 显示返回信息的对象
var AutoSaveMsg = null;
// 用户名
var memName = null;
// 自动保存时间间隔
var AutoSaveTime=null;
// 计时器对象
var AutoSaveTimer=null;

function init() {
	AutoSaveMsg=document.getElementById("AutoSaveMsg");
	memName=document.getElementById("memName").value;
	FormContent=document.getElementById("message");
	AutoSaveTime=10000;
	// 首先设置一次自动保存状态
	SetAutoSave();
}

// 自动保存函数
function AutoSave() {
    // 如果内容或用户名为空，则不进行处理，直接返回
    if(!FormContent.value||!memName) return;
    // 创建AJAXRequest对象
    var ajaxobj=new AJAXRequest();
    ajaxobj.url="autosave.jsp";
    ajaxobj.content="action=AutoSave&memname="+memName+"&postcontent="+FormContent.value;
    ajaxobj.callback=function(xmlObj) {
        // 显示反馈信息
        AutoSaveMsg.innerHTML=xmlObj.responseText;
    }
    ajaxobj.send();
}


// 设置自动保存状态函数
function SetAutoSave() {
    // 是否自动保存？
    if(document.getElementById("Draft_AutoSave").checked==true)
        // 是，设置计时器
        AutoSaveTimer=setInterval("AutoSave()",AutoSaveTime);
    else
        // 否，清除计时器
        clearInterval(AutoSaveTimer);
}

function AutoSaveRestore() {// 恢复最后保存的草稿
     AutoSaveMsg.innerHTML="正在恢复，请稍候……"
    // 如果用户名为空，则不进行处理，直接返回
    if(!memName) return;
    // 创建AJAXRequest对象
    var ajaxobj=new AJAXRequest();
    ajaxobj.url="autosave.jsp";
    ajaxobj.content="action=Restore&memname="+memName;
    ajaxobj.callback=function(xmlObj) {
        // 显示反馈信息
     if(xmlObj.responseText!="") {
         // 恢复草稿
         var s=xmlObj.responseText.replace(/^[\n|\r\n]*|[\n|\r\n]*$/g,'');//去掉首尾空行
         FormContent.innerText=s;
          // 提示用户恢复成功
        AutoSaveMsg.innerHTML="恢复成功";
        }
    }
    ajaxobj.send();
}



function Save() {
    // 如果内容或用户名为空，则不进行处理，直接返回
    if(!FormContent.value||!memName) return;
    // 创建AJAXRequest对象
    var ajaxobj=new AJAXRequest();
    ajaxobj.url="autosave.jsp";
    ajaxobj.content="action=Save&memname="+memName+"&postcontent="+FormContent.value;
    ajaxobj.callback=function(xmlObj) {
        // 显示反馈信息
        AutoSaveMsg.innerHTML=xmlObj.responseText;
    }
    ajaxobj.send();
}