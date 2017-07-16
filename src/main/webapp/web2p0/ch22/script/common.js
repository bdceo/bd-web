String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
function OMO() {
    if (window.event.srcElement.tagName == "IMG")
        event.srcElement.parentElement.className="T";
    else
        event.srcElement.className="T";
}

function OMOU() {
    if (window.event.srcElement.tagName == "IMG")
        event.srcElement.parentElement.className="T";
    else
        event.srcElement.className="P";
}
function OMO1() {
	event.srcElement.className="LL";	
}
function openWindow(URL, Name, Width, Height) {
	window.open(URL, Name, "width=" + Width + ",height=" + Height +
				",left=" + (window.screen.width - Width)/2 +
				",top=" + (window.screen.height - Height)/2 +
				",resizable=no,scrollbars=yes,toolbar=no,location=no," +
				"directories=no,status=no,menubar=no");	
}