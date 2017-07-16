<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>拖动</title>
		<style>
* {
	font-size: 12px
}

.dragTable {
	font-size: 12px;
	border-top: 1px solid #3366cc;
	margin-bottom: 10px;
	width: 100%;
	background-color: #FFFFFF;
}

.dragTR {
	cursor: move;
	color: #7787cc;
	background-color: #e5eef9;
}

td {
	vertical-align: top;
}

#parentTable {
	border-collapse: collapse;
	letter-spacing: 25px;
}
</style>
		<script src="xmlhttp.js" language="javascript" type="text/javascript"></script>
		<script defer>
 var draged=false;
 tdiv=null;
function dragStart(){
	 ao=event.srcElement;
	 if((ao.tagName=="TD")||(ao.tagName=="TR"))ao=ao.offsetParent;
	 else return;
	 draged=true;
	 tdiv=document.createElement("div");
	 tdiv.innerHTML=ao.outerHTML;
	 tdiv.style.display="block";
	 tdiv.style.position="absolute";
	 tdiv.style.filter="alpha(opacity=70)";
	 tdiv.style.cursor="move";
	 tdiv.style.width=ao.offsetWidth;
	 tdiv.style.height=ao.offsetHeight;
	 tdiv.style.top=getInfo(ao).top;
	 tdiv.style.left=getInfo(ao).left;
	 document.body.appendChild(tdiv);
	 lastX=event.clientX;
	 lastY=event.clientY;
	 lastLeft=tdiv.style.left;
	 lastTop=tdiv.style.top;
	 try{
	  ao.dragDrop(); 
	 }catch(e){}
}
function draging(){
 if(!draged)return;
 var tX=event.clientX;
 var tY=event.clientY;
 tdiv.style.left=parseInt(lastLeft)+tX-lastX;
 tdiv.style.top=parseInt(lastTop)+tY-lastY;
 for(var i=0;i<parentTable.cells.length;i++){
  var parentCell=getInfo(parentTable.cells[i]);
  if(tX>=parentCell.left&&tX<=parentCell.right&&tY>=parentCell.top&&tY<=parentCell.bottom){
   var subTables=parentTable.cells[i].getElementsByTagName("table");
   if(subTables.length==0){
    if(tX>=parentCell.left&&tX<=parentCell.right&&tY>=parentCell.top&&tY<=parentCell.bottom){
     parentTable.cells[i].appendChild(ao);
    }
    break;
   }
   for(var j=0;j<subTables.length;j++){
    var subTable=getInfo(subTables[j]);
    if(tX>=subTable.left&&tX<=subTable.right&&tY>=subTable.top&&tY<=subTable.bottom){
     parentTable.cells[i].insertBefore(ao,subTables[j]);
     break;
    }else{
     parentTable.cells[i].appendChild(ao);
    } 
   }
  }
 }
}

function dragEnd(){
 if(!draged)return;
 draged=false;
 mm=frize(150,15);
}
function getInfo(o){
 var to=new Object();
 to.left=to.right=to.top=to.bottom=0;
 var twidth=o.offsetWidth;
 var theight=o.offsetHeight;
 while(o!=document.body){
  to.left+=o.offsetLeft;
  to.top+=o.offsetTop;
  o=o.offsetParent;
 }
  to.right=to.left+twidth;
  to.bottom=to.top+theight;
 return to;
}
function frize(aa,ab){
 var ac=parseInt(getInfo(tdiv).left);
 var ad=parseInt(getInfo(tdiv).top);
 var ae=(ac-getInfo(ao).left)/ab;
 var af=(ad-getInfo(ao).top)/ab;
 return setInterval(function(){if(ab<1){
       clearInterval(mm);
       tdiv.removeNode(true);
       ao=null;
       return
      }
     ab--;
     ac-=ae;
     ad-=af;
     tdiv.style.left=parseInt(ac)+"px";
     tdiv.style.top=parseInt(ad)+"px"
    }
,aa/ab)
}
function inint(){
 for(var i=0;i<parentTable.cells.length;i++){
  var subTables=parentTable.cells[i].getElementsByTagName("table");
  for(var j=0;j<subTables.length;j++){
   if(subTables[j].className!="dragTable")break;
   subTables[j].rows[0].className="dragTR";
   subTables[j].rows[0].attachEvent("onmousedown",dragStart);
   subTables[j].attachEvent("ondrag",draging);
   subTables[j].attachEvent("ondragend",dragEnd);
  }
 }
}
inint();

</script>
	</head>
	<body>
		<table border="0" cellpadding="0" cellspacing="10" width="100%"
			height=300 id="parentTable">
			<tr>
				<td width="25%" valgin="top">
					<table border=0 class="dragTable" cellspacing="0" id="column1">
						<tr>
							<td>
								栏目1
							</td>
							<td align="right">
								<a href="#" onClick="document.all.column1.style.display='none'"
									onMouseDown="document.all.imag1.src='images/Icon2.gif'"
									onMouseUp="document.all.imag1.src='images/Icon.gif'"
									onFocus="this.blur()"><img src="images/Icon.gif"
										width="16" height="14" id="imag1" border="0">
								</a>
							</td>
						</tr>
						<tr>
							<td id="div4"></td>
						<tr>
					</table>
					<table border=0 class="dragTable" cellspacing="0" id="column2">
						<tr>
							<td>
								栏目2
							</td>
							<td align="right">
								<a href="#" onClick="document.all.column2.style.display='none'"
									onMouseDown="document.all.imag2.src='images/Icon2.gif'"
									onMouseUp="document.all.imag2.src='images/Icon.gif'"
									onFocus="this.blur()"><img src="images/Icon.gif"
										width="16" height="14" id="imag2" border="0">
								</a>
							</td>
						</tr>
						<tr>
							<td id="div5"></td>
						<tr>
					</table>
					<table border=0 class="dragTable" cellspacing="0" id="column3">
						<tr>
							<td>
								栏目3
							</td>
							<td align="right">
								<a href="#" onClick="document.all.column3.style.display='none'"
									onMouseDown="document.all.imag3.src='images/Icon2.gif'"
									onMouseUp="document.all.imag3.src='images/Icon.gif'"
									onFocus="this.blur()"><img src="images/Icon.gif"
										width="16" height="14" id="imag3" border="0">
								</a>
							</td>
						</tr>
						<tr>
							<td id="div3"></td>
						<tr>
					</table>
				</td>
				<td width="25%">
					<table border=0 class="dragTable" cellspacing="0" id="column4">
						<tr>
							<td>
								栏目4
							</td>
							<td align="right">
								<a href="#" onClick="document.all.column4.style.display='none'"
									onMouseDown="document.all.imag4.src='images/Icon2.gif'"
									onMouseUp="document.all.imag4.src='images/Icon.gif'"
									onFocus="this.blur()"><img src="images/Icon.gif"
										width="16" height="14" id="imag4" border="0">
								</a>
							</td>
						</tr>
						<tr>
							<td id="div2">
							</td>
						<tr>
					</table>
				</td>
				<td width="25%">
					<table border=0 class="dragTable" cellspacing="0" id="column5">
						<tr>
							<td>
								栏目5
							</td>
							<td align="right">
								<a href="#" onClick="document.all.column5.style.display='none'"
									onMouseDown="document.all.imag5.src='images/Icon2.gif'"
									onMouseUp="document.all.imag5.src='images/Icon.gif'"
									onFocus="this.blur()"><img src="images/Icon.gif"
										width="16" height="14" id="imag5" border="0">
								</a>
							</td>
						</tr>
						<tr>
							<td id="dv">
								<div id="div10"></div>
							</td>
						<tr>
					</table>
				</td>
			</tr>
		</table>

	</body>
</html>

