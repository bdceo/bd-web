package com.bdsoft.android.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.bdsoft.android.form.AndroidForm;

public class AndroidAction extends DispatchAction {

	public ActionForward android(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AndroidForm aForm = (AndroidForm) form;
		System.out.println("name = " + aForm.getName());
		System.out.println("id = " + aForm.getId());

		request.setAttribute("name",aForm.getName()	);
		request.setAttribute("id", aForm.getId());
		return mapping.findForward("result");
	}

}  
