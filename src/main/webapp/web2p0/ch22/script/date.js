var bMoveable=true;	
var _VersionInfo=""	
var strFrame;	
document.writeln('<div style="position:absolute;left:20px;top:-22px"><iframe id=thanksDateLayer src="javascript:true"  frameborder="0" width="145" height="215" scrolling="no" style="position: absolute; width: 145px; height: 215px; z-index: 9998; display: none"></iframe></div>');
strFrame='<style>';
strFrame+='INPUT.button{BORDER-RIGHT: #2E90B5 1px solid;BORDER-TOP: #2E90B5 1px solid;BORDER-LEFT: #2E90B5 1px solid;';
strFrame+='BORDER-BOTTOM: #2E90B5 1px solid;BACKGROUND-COLOR: #fff8ec;font-family:锟斤拷锟斤拷;}';
strFrame+='TD{FONT-SIZE: 9pt;font-family:锟斤拷锟斤拷;}';
strFrame+='</style>';
strFrame+='<script>';
strFrame+='var datelayerx,datelayery';
strFrame+='var bDrag';
strFrame+='function document.onmousemove()';
strFrame+='{if(bDrag && window.event.button==1)';
strFrame+='	{var DateLayer=parent.document.all.thanksDateLayer.style;';
strFrame+='		DateLayer.posLeft += window.event.clientX-datelayerx';
strFrame+='		DateLayer.posTop += window.event.clientY-datelayery;}}';
strFrame+='function DragStart()	';
strFrame+='{var DateLayer=parent.document.all.thanksDateLayer.style;';
strFrame+='	datelayerx=window.event.clientX;';
strFrame+='	datelayery=window.event.clientY;';
strFrame+='	bDrag=true;}';
strFrame+='function DragEnd(){';
strFrame+='	bDrag=false;}';
strFrame+='</script>';
strFrame+='<div style="z-index:9999;position: absolute; left:0; top:0;" onselectstart="return false"><span id=tmpSelectYearLayer  style="z-index: 9999;position: absolute;top: 3; left: 19;display: none"></span>';
strFrame+='<span id=tmpSelectMonthLayer  style="z-index: 9999;position: absolute;top: 3; left: 78;display: none"></span>';
strFrame+='<table border=1 cellspacing=0 cellpadding=0 width=142 height=160 bordercolor=#2E90B5 bgcolor=#2E90B5 >';
strFrame+='  <tr ><td width=142 height=23  bgcolor=#FFFFFF><table border=0 cellspacing=1 cellpadding=0 width=140  height=23>';
strFrame+='      <tr align=center ><td width=16 align=center bgcolor=#2E90B5 style="font-size:12px;cursor: hand;color: #ffffff" ';
strFrame+='        onclick="parent.thanksPrevM()" title="锟斤拷前锟斤拷 1 锟斤拷" ><b >&lt;</b>';
strFrame+='        </td><td width=60 align=center style="font-size:12px;cursor:default"';
strFrame+='onmouseover="style.backgroundColor=\'#EF0401\'" onmouseout="style.backgroundColor=\'white\'" ';
strFrame+='onclick="parent.tmpSelectYearInnerHTML(this.innerText.substring(0,4))" title="锟斤拷锟斤拷锟斤拷锟窖★拷锟斤拷锟斤拷"><span id=thanksYearHead></span></td>';
strFrame+='<td width=48 align=center style="font-size:12px;cursor:default" onmouseover="style.backgroundColor=\'#EF0401\'" ';
strFrame+=' onmouseout="style.backgroundColor=\'white\'" onclick="parent.tmpSelectMonthInnerHTML(this.innerText.length==3?this.innerText.substring(0,1):this.innerText.substring(0,2))"';
strFrame+='        title="锟斤拷锟斤拷锟斤拷锟窖★拷锟斤拷路锟�"><span id=thanksMonthHead ></span></td>';
strFrame+='        <td width=16 bgcolor=#2E90B5 align=center style="font-size:12px;cursor: hand;color: #ffffff" ';
strFrame+='         onclick="parent.thanksNextM()" title="锟斤拷锟� 1 锟斤拷" ><b >&gt;</b></td></tr>';
strFrame+='    </table></td></tr>';
strFrame+='  <tr ><td width=142 height=18 >';
strFrame+='<table border=1 cellspacing=0 cellpadding=0 bgcolor=#2E90B5 ' + (bMoveable? 'onmousedown="DragStart()" onmouseup="DragEnd()"':'');
strFrame+=' BORDERCOLORLIGHT=#CCB27D BORDERCOLORDARK=#FFFFFF width=140 height=20  style="cursor:' + (bMoveable ? 'move':'default') + '">';
strFrame+='<tr  align=center valign=bottom><td style="font-size:12px;color:#FFFFFF" >锟斤拷</td>';
strFrame+='<td style="font-size:12px;color:#FFFFFF" >一</td><td style="font-size:12px;color:#FFFFFF" >锟斤拷</td>';
strFrame+='<td style="font-size:12px;color:#FFFFFF" >锟斤拷</td><td style="font-size:12px;color:#FFFFFF" >锟斤拷</td>';
strFrame+='<td style="font-size:12px;color:#FFFFFF" >锟斤拷</td><td style="font-size:12px;color:#FFFFFF" >锟斤拷</td></tr>';
strFrame+='</table></td></tr>';
strFrame+='  <tr ><td width=142 height=120 >';
strFrame+='    <table border=1 cellspacing=2 cellpadding=0 BORDERCOLORLIGHT=#CCB27D BORDERCOLORDARK=#FFFFFF bgcolor=#fff8ec width=140 height=120 >';
var n=0; for (j=0;j<5;j++){ strFrame+= ' <tr align=center >'; for (i=0;i<7;i++){
strFrame+='<td width=20 height=20 id=thanksDay'+n+' style="font-size:12px"  onclick=parent.thanksDayClick(this.innerText,0)></td>';n++;}
strFrame+='</tr>';}
strFrame+='      <tr align=center >';
for (i=35;i<39;i++)strFrame+='<td width=20 height=20 id=thanksDay'+i+' style="font-size:12px"  onclick="parent.thanksDayClick(this.innerText,0)"></td>';
strFrame+='        <td colspan=3 align=right ><span onclick=parent.closeLayer() style="font-size:12px;cursor: hand"';
strFrame+='          title="' + _VersionInfo + '"><u>锟截憋拷</u></span>&nbsp;</td></tr>';
strFrame+='    </table></td></tr><tr ><td >';
strFrame+='        <table border=0 cellspacing=1 cellpadding=0 width=100%  bgcolor=#FFFFFF>';
strFrame+='          <tr ><td  align=left><input  type=button class=button value="<<" title="锟斤拷前锟斤拷 1 锟斤拷" onclick="parent.thanksPrevY()" ';
strFrame+='             onfocus="this.blur()" style="font-size: 12px; height: 20px"><input  class=button title="锟斤拷前锟斤拷 1 锟斤拷" type=button ';
strFrame+='             value="< " onclick="parent.thanksPrevM()" onfocus="this.blur()" style="font-size: 12px; height: 20px"></td><td ';
strFrame+='              align=center><input  type=button class=button value=锟斤拷锟斤拷 onclick="parent.thanksToday()" ';
strFrame+='             onfocus="this.blur()" title="锟斤拷前锟斤拷锟斤拷" style="font-size: 12px; height: 20px; cursor:hand"></td><td ';
strFrame+='              align=right><input  type=button class=button value=" >" onclick="parent.thanksNextM()" ';
strFrame+='             onfocus="this.blur()" title="锟斤拷锟� 1 锟斤拷" class=button style="font-size: 12px; height: 20px"><input ';
strFrame+='              type=button class=button value=">>" title="锟斤拷锟� 1 锟斤拷" onclick="parent.thanksNextY()"';
strFrame+='             onfocus="this.blur()" style="font-size: 12px; height: 20px"></td>';
strFrame+='</tr></table></td></tr></table></div>';

window.frames.thanksDateLayer.document.writeln(strFrame);
window.frames.thanksDateLayer.document.close();	

var outObject;
var outButton;	
var outDate="";		
var startDate;		
var endDate;
var odatelayer=window.frames.thanksDateLayer.document.all;		

function setday(tt,obj,startday,endday) 
{   
	if (arguments.length >  4){alert("锟皆诧拷锟金！达拷锟诫本锟截硷拷锟侥诧拷锟斤拷太锟洁！");return;}
	if (arguments.length == 0){alert("锟皆诧拷锟斤拷锟斤拷没锟叫达拷锟截憋拷锟截硷拷锟轿何诧拷锟斤拷");return;}
	var dads  = document.all.thanksDateLayer.style;
	var th = tt;
	var ttop  = tt.offsetTop;  
	var thei  = tt.clientHeight; 
	var tleft = tt.offsetLeft;  
	var ttyp  = tt.type;  
	while (tt = tt.offsetParent){ttop+=tt.offsetTop; tleft+=tt.offsetLeft;}
	dads.top  = (ttyp=="image")? ttop+thei : ttop+thei+6;
	dads.left = tleft;
	outObject = (arguments.length == 1) ? th : obj;
	outButton = (arguments.length == 1) ? null : th;	
	
	startDate = (arguments.length == 4) ? startday : "";
	endDate = (arguments.length == 4) ? endday : "";
	var reg = /^(\d{4})(\d{2})(\d{2})$/; 
	var r = outObject.value.match(reg); 
	if(r!=null){
		r[2]=r[2]-1; 
		var d= new Date(r[1], r[2],r[3]); 
		if(d.getFullYear()==r[1] && d.getMonth()==r[2] && d.getDate()==r[3]){
			outDate=d;
		}
		else outDate="";
			thanksSetDay(r[1],r[2]+1);
	}
	else{
		outDate="";
		thanksSetDay(new Date().getFullYear(), new Date().getMonth() + 1);
	}
	dads.display = '';

	event.returnValue=false;
}

var MonHead = new Array(12); 
    MonHead[0] = 31; MonHead[1] = 28; MonHead[2] = 31; MonHead[3] = 30; MonHead[4]  = 31; MonHead[5]  = 30;
    MonHead[6] = 31; MonHead[7] = 31; MonHead[8] = 30; MonHead[9] = 31; MonHead[10] = 30; MonHead[11] = 31;

var thanksTheYear=new Date().getFullYear(); 
var thanksTheMonth=new Date().getMonth()+1; 
var thanksWDay=new Array(39);               

function document.onclick() 
{ 
  with(window.event)
  { if (srcElement != outObject && srcElement != outButton)
    closeLayer();
  }
}

function document.onkeyup()		
  {
    if (window.event.keyCode==27){
		if(outObject)outObject.blur();
		closeLayer();
	}
	else if(document.activeElement)
		if(document.activeElement.getAttribute("Author")==null && document.activeElement != outObject && document.activeElement != outButton)
		{
			closeLayer();
		}
  }

function thanksWriteHead(yy,mm)  
  {
	odatelayer.thanksYearHead.innerText  = yy + " 锟斤拷";
    odatelayer.thanksMonthHead.innerText = mm + " 锟斤拷";
  }

function tmpSelectYearInnerHTML(strYear) 
{
  if (strYear.match(/\D/)!=null){alert("锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街ｏ拷");return;}
  var m = (strYear) ? strYear : new Date().getFullYear();
  if (m < 1000 || m > 9999) {alert("锟斤拷锟街碉拷锟斤拷锟� 1000 锟斤拷 9999 之锟戒！");return;}
  var n = m - 10;
  if (n < 1000) n = 1000;
  if (n + 26 > 9999) n = 9974;
  var s = "<select  name=tmpSelectYear style='font-size: 12px' "
     s += "onblur='document.all.tmpSelectYearLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectYearLayer.style.display=\"none\";"
     s += "parent.thanksTheYear = this.value; parent.thanksSetDay(parent.thanksTheYear,parent.thanksTheMonth)'>\r\n";
  var selectInnerHTML = s;
  for (var i = n; i < n + 26; i++)
  {
    if (i == m)
       {selectInnerHTML += "<option  value='" + i + "' selected>" + i + "锟斤拷" + "</option>\r\n";}
    else {selectInnerHTML += "<option  value='" + i + "'>" + i + "锟斤拷" + "</option>\r\n";}
  }
  selectInnerHTML += "</select>";
  odatelayer.tmpSelectYearLayer.style.display="";
  odatelayer.tmpSelectYearLayer.innerHTML = selectInnerHTML;
  odatelayer.tmpSelectYear.focus();
}

function tmpSelectMonthInnerHTML(strMonth) 
{
  if (strMonth.match(/\D/)!=null){alert("锟铰凤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷郑锟�");return;}
  var m = (strMonth) ? strMonth : new Date().getMonth() + 1;
  var s = "<select  name=tmpSelectMonth style='font-size: 12px' "
     s += "onblur='document.all.tmpSelectMonthLayer.style.display=\"none\"' "
     s += "onchange='document.all.tmpSelectMonthLayer.style.display=\"none\";"
     s += "parent.thanksTheMonth = this.value; parent.thanksSetDay(parent.thanksTheYear,parent.thanksTheMonth)'>\r\n";
  var selectInnerHTML = s;
  for (var i = 1; i < 13; i++)
  {
    if (i == m)
       {selectInnerHTML += "<option  value='"+i+"' selected>"+i+"锟斤拷"+"</option>\r\n";}
    else {selectInnerHTML += "<option  value='"+i+"'>"+i+"锟斤拷"+"</option>\r\n";}
  }
  selectInnerHTML += "</select>";
  odatelayer.tmpSelectMonthLayer.style.display="";
  odatelayer.tmpSelectMonthLayer.innerHTML = selectInnerHTML;
  odatelayer.tmpSelectMonth.focus();
}

function closeLayer()               
  {
    document.all.thanksDateLayer.style.display="none";
    
  }

function IsPinYear(year)            
  {
    if (0==year%4&&((year%100!=0)||(year%400==0))) return true;else return false;
  }
  
function isValidDay(n,ex)     
  {
  	
  	if (startDate == "" || endDate == "")
  		return true;
  	
	var yy = thanksTheYear;
	var mm = parseInt(thanksTheMonth)+ex;	
	
	
	if (mm < 1) {
		yy--;
		mm = 12 + mm;
	}else if (mm > 12) {
		yy++;
		mm = mm - 12;
	}

	if (mm < 10) {mm = "0" + mm;}
	if (n < 10) {n = "0" + n;}
	
  	var date = yy+mm+n;
  	
  	if(date >= startDate && date <= endDate)
  		return true;
  		
  	return false;
  }
  
function GetMonthCount(year,month)  
  {
    var c=MonHead[month-1];if((month==2)&&IsPinYear(year)) c++;return c;
  }
function GetDOW(day,month,year)     
  {
    var dt=new Date(year,month-1,day).getDay()/7; return dt;
  }

function thanksPrevY()  
  {
    if(thanksTheYear > 999 && thanksTheYear <10000){thanksTheYear--;}
    else{alert("锟斤拷莩锟斤拷锟轿э拷锟�00-9999锟斤拷锟斤拷");}
    thanksSetDay(thanksTheYear,thanksTheMonth);
  }
function thanksNextY()  
  {
    if(thanksTheYear > 999 && thanksTheYear <10000){thanksTheYear++;}
    else{alert("锟斤拷莩锟斤拷锟轿э拷锟�00-9999锟斤拷锟斤拷");}
    thanksSetDay(thanksTheYear,thanksTheMonth);
  }
function thanksToday()  
  {
	var today;
    thanksTheYear = new Date().getFullYear();
    thanksTheMonth = new Date().getMonth()+1;
    if(thanksTheMonth<10){
      thanksTheMonth = "0"+thanksTheMonth;
    }
    today=new Date().getDate();
    if(today<10){
      today = "0"+today;
    }
    
    if(outObject){
		outObject.value=thanksTheYear + "" + thanksTheMonth + "" + today;
    }
    closeLayer();
  }
function thanksPrevM()  
  {
    if(thanksTheMonth>1){thanksTheMonth--}else{thanksTheYear--;thanksTheMonth=12;}
    thanksSetDay(thanksTheYear,thanksTheMonth);
  }
function thanksNextM()  
  {
    if(thanksTheMonth==12){thanksTheYear++;thanksTheMonth=1}else{thanksTheMonth++}
    thanksSetDay(thanksTheYear,thanksTheMonth);
  }

function thanksSetDay(yy,mm)   
{
  thanksWriteHead(yy,mm);
  
  thanksTheYear=yy;
  thanksTheMonth=mm;
  
  for (var i = 0; i < 39; i++){thanksWDay[i]=""};  
  var day1 = 1,day2=1,firstday = new Date(yy,mm-1,1).getDay();  
  for (i=0;i<firstday;i++)thanksWDay[i]=GetMonthCount(mm==1?yy-1:yy,mm==1?12:mm-1)-firstday+i+1	
  for (i = firstday; day1 < GetMonthCount(yy,mm)+1; i++){thanksWDay[i]=day1;day1++;}
  for (i=firstday+GetMonthCount(yy,mm);i<39;i++){thanksWDay[i]=day2;day2++}
  for (i = 0; i < 39; i++)
  { var da = eval("odatelayer.thanksDay"+i)     
    if (thanksWDay[i]!="")
      { 
		
		da.borderColorLight="#CCB27D";
		da.borderColorDark="#FFFFFF";
		if(i<firstday)		
		{
			da.style.color="#808080";
			da.innerHTML="<b>" + thanksWDay[i] + "</b>";
			da.title=(mm==1?12:mm-1) +"锟斤拷" + thanksWDay[i] + "锟斤拷";
			da.onclick=Function("thanksDayClick(this.innerText,-1)");
			if(!outDate)
				da.style.backgroundColor = ((mm==1?yy-1:yy) == new Date().getFullYear() && 
					(mm==1?12:mm-1) == new Date().getMonth()+1 && thanksWDay[i] == new Date().getDate()) ?
					 "#EF0401":"#e0e0e0";
			else
			{
				da.style.backgroundColor =((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 && 
				thanksWDay[i]==outDate.getDate())? "#00ffff" :
				(((mm==1?yy-1:yy) == new Date().getFullYear() && (mm==1?12:mm-1) == new Date().getMonth()+1 && 
				thanksWDay[i] == new Date().getDate()) ? "#EF0401":"#e0e0e0");
				
				if((mm==1?yy-1:yy)==outDate.getFullYear() && (mm==1?12:mm-1)== outDate.getMonth() + 1 && 
				thanksWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#CCB27D";
				}
			}
			if(isValidDay(thanksWDay[i],-1)) {
				da.style.cursor="hand";
				if (startDate != "" && endDate != "")
					da.style.color="#9900FF";
	    	} else {
	    		da.style.cursor="not-allowed";
	    		da.onclick="";
	    	}
		}
		else if (i>=firstday+GetMonthCount(yy,mm))		
		{
			da.style.color="#808080";
			da.innerHTML="<b>" + thanksWDay[i] + "</b>";
			da.title=(mm==12?1:mm+1) +"锟斤拷" + thanksWDay[i] + "锟斤拷";
			da.onclick=Function("thanksDayClick(this.innerText,1)");
			if(!outDate)
				da.style.backgroundColor = ((mm==12?yy+1:yy) == new Date().getFullYear() && 
					(mm==12?1:mm+1) == new Date().getMonth()+1 && thanksWDay[i] == new Date().getDate()) ?
					 "#EF0401":"#e0e0e0";
			else
			{
				da.style.backgroundColor =((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && 
				thanksWDay[i]==outDate.getDate())? "#00ffff" :
				(((mm==12?yy+1:yy) == new Date().getFullYear() && (mm==12?1:mm+1) == new Date().getMonth()+1 && 
				thanksWDay[i] == new Date().getDate()) ? "#EF0401":"#e0e0e0");
				
				if((mm==12?yy+1:yy)==outDate.getFullYear() && (mm==12?1:mm+1)== outDate.getMonth() + 1 && 
				thanksWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#CCB27D";
				}
			}
			if(isValidDay(thanksWDay[i],1)) {
				da.style.cursor="hand";
				if (startDate != "" && endDate != "")
					da.style.color="#9900FF";
	    	} else {
	    		da.style.cursor="not-allowed";
	    		da.onclick="";
	    	}
		}
		else		
		{
			da.style.color="#000000";
			da.innerHTML="<b>" + thanksWDay[i] + "</b>";
			da.title=mm +"锟斤拷" + thanksWDay[i] + "锟斤拷";
			da.onclick=Function("thanksDayClick(this.innerText,0)");		
			
			if(!outDate)
				da.style.backgroundColor = (yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && thanksWDay[i] == new Date().getDate())?
					"#EF0401":"#e0e0e0";
			else
			{
				da.style.backgroundColor =(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && thanksWDay[i]==outDate.getDate())?
					"#00ffff":((yy == new Date().getFullYear() && mm == new Date().getMonth()+1 && thanksWDay[i] == new Date().getDate())?
					"#EF0401":"#e0e0e0");
				
				if(yy==outDate.getFullYear() && mm== outDate.getMonth() + 1 && thanksWDay[i]==outDate.getDate())
				{
					da.borderColorLight="#FFFFFF";
					da.borderColorDark="#CCB27D";
				}
			}
			
			if(isValidDay(thanksWDay[i],0)) {
				da.style.cursor="hand";
				if (startDate != "" && endDate != "")
					da.style.color="#9900FF";
	    	} else {
	    		da.style.cursor="not-allowed";
	    		da.onclick="";
	    	}
		}
      }
    else{da.innerHTML="";da.style.backgroundColor="";da.style.cursor="default";}
  }
}

function thanksDayClick(n,ex)  
{
  var yy=thanksTheYear;
  var mm = parseInt(thanksTheMonth)+ex;	
	
	if(mm<1){
		yy--;
		mm=12+mm;
	}
	else if(mm>12){
		yy++;
		mm=mm-12;
	}
	
  if (mm < 10){mm = "0" + mm;}
  if (outObject)
  {
    if (!n) {
      return;}
    if ( n < 10){n = "0" + n;}
    outObject.value= yy + "-" + mm + "-" + n ; 
    closeLayer(); 
  }
  else {closeLayer(); alert("锟斤拷锟斤拷要锟斤拷锟侥控硷拷锟斤拷锟襟并诧拷锟斤拷锟节ｏ拷");}
}