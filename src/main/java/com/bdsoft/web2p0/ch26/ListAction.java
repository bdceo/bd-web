package com.bdsoft.web2p0.ch26;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ListAction extends DispatchAction {

	public ListAction() {
	}

	public ActionForward addInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ListForm listForm = (ListForm) form;
		PersonManager manager = new PersonManager();
		try {
			manager.addPerson(listForm);
			java.util.List list = manager.getList();
			request.setAttribute("result", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("list");
	}

	public ActionForward lookList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PersonManager manager = new PersonManager();
		try {
			java.util.List list = manager.getList();
			request.setAttribute("result", list);
		} catch (Exception e) {
			return mapping.findForward("list");
		}
		return mapping.findForward("list");
	}

	public ActionForward searchList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ListForm listForm = (ListForm) form;
		PersonManager manager = new PersonManager();
		try {
			java.util.List list = manager.searchList((String) listForm
					.getName());
			request.setAttribute("result", list);
		} catch (Exception e) {
			return mapping.findForward("list");
		}
		return mapping.findForward("list");
	}

	public ActionForward delInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ListForm listForm = (ListForm) form;
		PersonManager manager = new PersonManager();
		try {
			manager.delPerson(listForm);
			java.util.List list = manager.getList();
			request.setAttribute("result", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("list");
	}

	public ActionForward delAll(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		PersonManager manager = new PersonManager();
		try {
			manager.delAll();
			java.util.List list = manager.getList();
			request.setAttribute("result", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward("list");
	}
}