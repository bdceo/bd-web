package com.bdsoft.web2p0.ch26;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class LogonAction extends DispatchAction {

	public LogonAction() {
	}

	public ActionForward logOut(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("logout");
	}

	public ActionForward logOn(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LogonForm logonForm = (LogonForm) form;
		LogonManager manager = new LogonManager();
		try {
			manager.logonSys(logonForm);
		} catch (Exception e) {
			return mapping.findForward("logon");
		}
		return mapping.findForward("logon");
	}
}