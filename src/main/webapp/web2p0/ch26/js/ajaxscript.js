var AjaxAnywhere = new AjaxAnywhere();
AjaxAnywhere.defaultInstanceName = "default";
function AjaxAnywhere() {
    this.id = AjaxAnywhere.defaultInstanceName;
    this.formName = null;
    this.notSupported = false;
    this.delayBeforeContentUpdate = true;
    this.delayInMillis = 100;

    if (window.XMLHttpRequest) {
        this.req = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            this.req = new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
            try {
                this.req = new ActiveXObject("Microsoft.XMLHTTP");
            } catch(e1) {
                this.notSupported = true;
            }
        }
    }

    if (this.req == null || typeof this.req == "undefined")
        this.notSupported = true;
}
AjaxAnywhere.prototype.findForm = function () {
    var form;
    if (this.formName != null)
        form = document.forms[this.formName];
    else if (document.forms.length > 0)
        form = document.forms[0];

    if (typeof form != "object")
        alert("AjaxAnywhere error: Form with name [" + this.formName + "] not found");
    return form;
}

AjaxAnywhere.prototype.bindById = function () {
    var key = "AjaxAnywhere." + this.id;
    window[key] = this;
}


AjaxAnywhere.findInstance = function(id) {
    var key = "AjaxAnywhere." + id;
    return window[key];
}


AjaxAnywhere.prototype.submitAJAX = function(additionalPostData, submitButton) {

    if (this.notSupported)
        return this.onSubmitAjaxNotSupported(additionalPostData, submitButton);

    if (additionalPostData == null || typeof additionalPostData == "undefined")
        additionalPostData = "";

    this.bindById();

    var form = this.findForm();

    var actionAttrNode = form.attributes["action"];
    var url = actionAttrNode == null?null:actionAttrNode.nodeValue;
    if ((url == null) || (url == ""))
        url = location.href;

    var pos = url.indexOf("#");
        if (pos!=-1)
            url = url.substring(0,pos);
        if ((url == null) || (url == ""))
            url = location.href;
        pos = url.indexOf("#");
        if (pos!=-1)
            url = url.substring(0,pos);

    var zones = this.getZonesToReload(url, submitButton);

    if (zones == null) {
        this.submitOld(form,submitButton)
        return;
    }

    this.dropPreviousRequest();

    this.req.open("POST", url, true);
    this.req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    this.req.setRequestHeader("Accept", "text/xml");

    var postData = this.preparePostData(submitButton);

    if (zones != "")
        postData = '&aazones=' + encodeURIComponent(zones) + "&" + postData + "&" + additionalPostData;
    else
        postData += "&" + additionalPostData;

    this.sendPreparedRequest(postData);

}

AjaxAnywhere.prototype.getAJAX = function(url, zonesToRefresh) {
    if (this.notSupported)
        return this.onGetAjaxNotSupported(url);

    this.bindById();

    if (zonesToRefresh == null || typeof zonesToRefresh == "undefined")
        zonesToRefresh = "";
    var urlDependentZones = this.getZonesToReload(url);
    if (urlDependentZones == null) {
        location.href = url;
        return;
    }

    if (urlDependentZones.length != 0)
        zonesToRefresh += "," + urlDependentZones;

    this.dropPreviousRequest();

    url += (url.indexOf("?") != -1) ? "&" : "?";

    url += "aaxmlrequest=true&aa_rand=" + Math.random();
    // avoid caching

    if (zonesToRefresh != null && zonesToRefresh != "")
        url += '&aazones=' + encodeURIComponent(zonesToRefresh);

    this.req.open("GET", url, true);
    this.req.setRequestHeader("Accept", "text/xml");

    this.sendPreparedRequest("");
}

AjaxAnywhere.prototype.sendPreparedRequest = function (postData) {
    var callbackKey = this.id + "_callbackFunction";
    if (typeof window[callbackKey] == "undefined")
        window[callbackKey] = new Function("AjaxAnywhere.findInstance(\"" + this.id + "\").callback(); ");
    this.req.onreadystatechange = window[callbackKey];

    this.showLoadingMessage();

    this.req.send(postData);
}

AjaxAnywhere.prototype.dropPreviousRequest = function() {
    if (this.req.readyState != 0 && this.req.readyState != 4) {
        // abort previous request if not completed
        this.req.abort();
        this.handlePrevousRequestAborted();
    }
}

AjaxAnywhere.prototype.preparePostData = function(submitButton) {
    var form = this.findForm();
    var result = "&aaxmlrequest=true";
    for (var i = 0; i < form.elements.length; i++) {
        var el = form.elements[i];
        if (el.tagName.toLowerCase() == "select") {
            for (var j = 0; j < el.options.length; j++) {
                var op = el.options[j];
                if (op.selected)
                    result += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(op.value);
            }
        } else if (el.tagName.toLowerCase() == "textarea") {
            result += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
        } else if (el.tagName.toLowerCase() == "input") {
            if (el.type.toLowerCase() == "checkbox" || el.type.toLowerCase() == "radio") {
                if (el.checked)
                    result += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            } else if (el.type.toLowerCase() == "submit") {
                if (el == submitButton) // is "el" the submit button that fired the form submit?
                    result += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            } else if (el.type.toLowerCase() != "button") {
                result += "&" + encodeURIComponent(el.name) + "=" + encodeURIComponent(el.value);
            }
        }
    }
    if (typeof submitButton != 'undefined' && submitButton != null && submitButton.type.toLowerCase() == "image") {
        if (submitButton.name == null || submitButton.name == "" || typeof submitButton.name == "undefined")
            result += "&x=1&y=1"; // .x and .y coordinates calculation is not supported.
        else
            result += "&" + encodeURIComponent(submitButton.name) + ".x=1&" +
                      encodeURIComponent(submitButton.name) + ".y=1";
    }
    return result;
}

function delay(millis) {
    date = new Date();
    var curDate = null;
    do {
        curDate = new Date();
    }
    while (curDate - date < millis);
}

AjaxAnywhere.prototype.callback = function() {

    if (this.req.readyState == 4) {

        this.onBeforeResponseProcessing();
        this.hideLoadingMessage();

        if (this.req.status == 200) {

            if (this.req.getResponseHeader('content-type').toLowerCase().substring(0, 8) != 'text/xml')
                alert("AjaxAnywhere error : content-type in not text/xml : [" + this.req.getResponseHeader('content-type') + "]");

            var docs = this.req.responseXML.getElementsByTagName("document");
            var redirects = this.req.responseXML.getElementsByTagName("redirect");
            var zones = this.req.responseXML.getElementsByTagName("zone");
            var exceptions = this.req.responseXML.getElementsByTagName("exception");
            var scripts = this.req.responseXML.getElementsByTagName("script");
            var images = this.req.responseXML.getElementsByTagName("image");

            if (redirects.length != 0) {
                var newURL = redirects[0].firstChild.data;
                location.href = newURL;
            }
            if (docs.length != 0) {
                var newContent = docs[0].firstChild.data;

                //cleanup ressources
                delete this.req;

                document.close();
                document.write(newContent);
                document.close();
            }

            if (images.length != 0) {
                var preLoad = new Array(images.length);
                for (var i = 0; i < images.length; i++) {
                    var img = images[i].firstChild;
                    if (img != null) {
                        preLoad[i] = new Image();
                        preLoad[i].src = img.data;
                    }
                }
                if (this.delayBeforeContentUpdate) {
                    delay(this.delayInMillis);
                }
            }

            if (zones.length != 0) {
                for (var i = 0; i < zones.length; i++) {
                    var zoneNode = zones[i];

                    var name = zoneNode.getAttribute("name");
                    var id = zoneNode.getAttribute("id");

                    var html = "";

                    for (var childIndex = 0; childIndex < zoneNode.childNodes.length; childIndex++) {
                        html += zoneNode.childNodes[childIndex].data
                    }

                    var zoneHolder = name!=null?
                                     document.getElementById("aazone." + name):
                                     document.getElementById(id);

                    if (zoneHolder != null && typeof(zoneHolder) != "undefined") {
                        zoneHolder.innerHTML = html;
                    }

                }
            }
            if (exceptions.length != 0) {
                var e = exceptions[0];
                var type = e.getAttribute("type");
                var stackTrace = e.firstChild.data;
                this.handleException(type, stackTrace);
            }

            if (scripts.length != 0) {
                for (var $$$$i = 0; $$$$i < scripts.length; $$$$i++) {
                    // use $$$$i variable to avoid collision with "i" inside user script
                    var script = scripts[$$$$i].firstChild;
                    if (script != null) {
                        script = script.data;
                        if (script.indexOf("document.write") != -1) {
                            this.handleException("document.write", "This script contains document.write(), which is not compatible with AjaxAnywhere : \n\n" + script);
                        } else {

                            eval("var aaInstanceId = \""+this.id+"\"; \n"+script);
                        }
                    }
                }

                var globals = this.getGlobalScriptsDeclarationsList(script);
                if (globals != null)
                    for (var i in globals) {
                        var objName = globals[i];
                        try {
                            window[objName] = eval(objName);
                        } catch(e) {
                        }
                    }
            }

        } else {
            if (this.req.status != 0)
                this.handleHttpErrorCode(this.req.status);
        }
        this.restoreSubstitutedSubmitButtons();
        this.onAfterResponseProcessing();

    }


}

AjaxAnywhere.prototype.showLoadingMessage = function() {

    var div = document.getElementById("AA_" + this.id + "_loading_div");
    if (div == null) {
        div = document.createElement("DIV");

        document.body.appendChild(div);
        div.id = "AA_" + this.id + "_loading_div";

        div.innerHTML = "&nbsp;Loading...";
        div.style.position = "absolute";
        div.style.border = "1 solid black";
        div.style.color = "white";
        div.style.backgroundColor = "blue";
        div.style.width = "100px";
        div.style.heigth = "50px";
        div.style.fontFamily = "Arial, Helvetica, sans-serif";
        div.style.fontWeight = "bold";
        div.style.fontSize = "11px";
    }
    div.style.top = document.body.scrollTop + "px";
    div.style.left = (document.body.offsetWidth - 100 - (document.all?20:0)) + "px";

    div.style.display = "";
}

/**
*  Default sample loading message hide function. Overrride it if you like.
*/
AjaxAnywhere.prototype.hideLoadingMessage = function() {
    var div = document.getElementById("AA_" + this.id + "_loading_div");
    if (div != null)
        div.style.display = "none";

}

AjaxAnywhere.prototype.substituteFormSubmitFunction = function() {
    if (this.notSupported)
        return;

    this.bindById();

    var form = this.findForm();

    form.submit_old = form.submit;
    var code = "var ajax = AjaxAnywhere.findInstance(\"" + this.id + "\"); " +
               "if (typeof ajax !='object' || ! ajax.isFormSubmitByAjax() ) " +
               "ajax.findForm().submit_old();" +
               " else " +
               "ajax.submitAJAX();"
    form.submit = new Function(code);

}

AjaxAnywhere.prototype.substituteSubmitButtonsBehavior = function (keepExistingOnClickHandler, elements) {
    if (this.notSupported)
        return;

    var form = this.findForm();
    if (elements == null || typeof elements == "undefined") { // process all elements
        elements = new Array();
        for (var i = 0; i < form.elements.length; i++) {
            elements.push(form.elements[i]);
        }

        var inputs = document.getElementsByTagName("input");
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            if (input.type != null && typeof input.type != "undefined" &&
                input.type.toLowerCase() == "image" && input.form == form) {
                elements.push(input);
            }
        }

        for (var i = 0; i < elements.length; i++) {
            var el = elements[i];
            if (el.tagName.toLowerCase() == "input" && (el.type.toLowerCase() == "submit"
                    || el.type.toLowerCase() == "image")) {
                this.substituteSubmitBehavior(el, keepExistingOnClickHandler);

            }
        }
    } else { 
        for (var i = 0; i < elements.length; i++) {
            var el = elements[i];
            if (el == null)
                continue;

            if (typeof el != "object")
                el = form.elements[el];

            if (typeof el != "undefined") {
                if (el.tagName.toLowerCase() == "input" && (el.type.toLowerCase() == "submit"
                        || el.type.toLowerCase() == "image"))
                    this.substituteSubmitBehavior(el, keepExistingOnClickHandler);
            }
        }
    }

}
AjaxAnywhere.prototype.substituteSubmitBehavior = function (el, keepExistingOnClickHandler) {

    var inList = false;
    for (var i = 0; i < this.substitutedSubmitButtons.length; i++) {
        var btnName = this.substitutedSubmitButtons[i];
        if (btnName == el.name) {
            inList = true;
            break;
        }
    }
    if (!inList)
        this.substitutedSubmitButtons.push(el.name);

    this.substitutedSubmitButtonsInfo[el.name] = keepExistingOnClickHandler;

    if (keepExistingOnClickHandler && (typeof el.onclick != "undefined") && ( el.onclick != null) && ( el.onclick != "")) {
        el.AA_old_onclick = el.onclick;
    }

    el.onclick = handleSubmitButtonClick;
    el.ajaxAnywhereId = this.id;
}

AjaxAnywhere.prototype.restoreSubstitutedSubmitButtons = function() {
    if (this.substitutedSubmitButtons.length == 0)
        return;

    var form = this.findForm();

    for (var i = 0; i < this.substitutedSubmitButtons.length; i++) {
        var name = this.substitutedSubmitButtons[i];
        var el = form.elements[name];
        if (el != null && typeof el != "undefined") {
            if (el.onclick != handleSubmitButtonClick) {
                var keepExistingOnClickHandler = this.substitutedSubmitButtonsInfo[el.name];
                this.substituteSubmitBehavior(el, keepExistingOnClickHandler);
            }
        } else {
            //input type=image
            if (name != null && typeof name != "undefined" && name.length != 0) {
                var elements = document.getElementsByName(name);
                if (elements != null)
                    for (var j = 0; j < elements.length; j++) {
                        el = elements[j];
                        if (el != null && typeof el != "undefined"
                                && el.tagName.toLowerCase() == "input"
                                && typeof el.type != "undefined" && el.type.toLowerCase() == "image") {
                            if (el.onclick != handleSubmitButtonClick) {
                                var keepExistingOnClickHandler = this.substitutedSubmitButtonsInfo[el.name];
                                this.substituteSubmitBehavior(el, keepExistingOnClickHandler);
                            }
                        }
                    }
            }
        }
    }
}

function handleSubmitButtonClick(_event) {

    if (typeof this.AA_old_onclick != "undefined") {
        if (false == this.AA_old_onclick(_event))
            return false;
        if (typeof window.event != "undefined")
            if (window.event.returnValue == false)
                return false;
    }
    var onsubmit = this.form.onsubmit;
    if (typeof onsubmit == "function") {
        if (false == onsubmit(_event))
            return false;
        if (typeof window.event != "undefined")
            if (window.event.returnValue == false)
                return false;
    }
    AjaxAnywhere.findInstance(this.ajaxAnywhereId).submitAJAX('', this);

    return false;
}
AjaxAnywhere.prototype.isFormSubmitByAjax = function () {
    return true;
}
AjaxAnywhere.prototype.setDelayBeforeLoad = function (isDelay) {
    this.delayBeforeContentUpdate = isDelay;
}
AjaxAnywhere.prototype.isDelayBeforeLoad = function () {
    return this.delayBeforeContentUpdate;
}
AjaxAnywhere.prototype.setDelayTime = function (delayMillis) {
    this.delayInMillis = delayMillis;
}
AjaxAnywhere.prototype.getDelayTime = function () {
    return this.delayInMillis;
}
AjaxAnywhere.prototype.handleException = function(type, details) {
    alert(details);
}
AjaxAnywhere.prototype.handleHttpErrorCode = function(code) {
    var details = confirm("AjaxAnywhere default error handler. XMLHttpRequest HTTP Error code:" + code + " \n\n Would you like to view the response content in a new window?");
    if (details) {
        var win = window.open("", this.id + "_debug_window");
        if (win != null) {
            win.document.write("<html><body><xmp>" + this.req.responseText);
            win.document.close();
            win.focus();
        } else {
            alert("Please, disable your pop-up blocker for this site first.");
        }
    }
}
AjaxAnywhere.prototype.handlePrevousRequestAborted = function() {
    alert("error")
}
AjaxAnywhere.prototype.getGlobalScriptsDeclarationsList = function(script) {
    return null;
}
AjaxAnywhere.prototype.getZonesToReload = function(url, submitButton) {
    return this.getZonesToReaload();
}
AjaxAnywhere.prototype.getZonesToReaload = function(url, submitButton) {
    return "";
}
AjaxAnywhere.prototype.onRequestSent = function () {
};
AjaxAnywhere.prototype.onBeforeResponseProcessing = function () {
};
AjaxAnywhere.prototype.onAfterResponseProcessing = function () {
};
AjaxAnywhere.prototype.onGetAjaxNotSupported = function (url) {
    location.href = url;
    return false;
};

AjaxAnywhere.prototype.onSubmitAjaxNotSupported = function (additionalPostData, submitButton) {
    var form = this.findForm();

    var actionAttrNode = form.attributes["action"];
    var url = actionAttrNode == null?null:actionAttrNode.nodeValue;
    var url_backup = url;
    if (typeof additionalPostData != 'undefined' && additionalPostData != null) {
        url += (url.indexOf("?") != -1) ? "&" : "?";
        url += additionalPostData;
        form.attributes["action"].nodeValue= url;
        form.setAttribute("method", "post");
    }

    this.submitOld(form,submitButton);

    form.attributes["action"].nodeValue= url_backup;
    return false;
};
AjaxAnywhere.prototype.submitOld = function (form,submitButton){
    var submitHolder = null;
    if (submitButton!=null && typeof submitButton!="undefined"){
        submitHolder = document.createElement("input");
        submitHolder.setAttribute("type","hidden");
        submitHolder.setAttribute("name",submitButton.name);
        submitHolder.setAttribute("value",submitButton.value);
        form.appendChild(submitHolder);

    }

    if (typeof form.submit_old == "undefined")
        form.submit();
    else
        form.submit_old();

    if (submitButton!=null ){
        form.removeChild(submitHolder);
    }
}
ajaxAnywhere = new AjaxAnywhere();
ajaxAnywhere.bindById();