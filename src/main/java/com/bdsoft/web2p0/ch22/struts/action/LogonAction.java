//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package com.bdsoft.web2p0.ch22.struts.action;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bdsoft.web2p0.ch22.base.PageFunction;
import com.bdsoft.web2p0.ch22.dao.LogonFormDAO;
import com.bdsoft.web2p0.ch22.dao.NewsFormDAO;
import com.bdsoft.web2p0.ch22.struts.form.LogonForm;

public class LogonAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LogonForm logonForm = (LogonForm) form;
		HttpSession session = request.getSession();
		String path = request.getRealPath("/web2p0/ch22/toolbar.html");
		LogonFormDAO ldao = new LogonFormDAO();
		boolean valid = ldao.checkUser(logonForm);
		if (valid) {
			String logonType = "yes";
			session.setAttribute("logonType", logonType);
			PageFunction pf = new PageFunction();
			NewsFormDAO ndao = new NewsFormDAO();
			pf.setTotalCount(ndao.newsCount());
			pf.setPage(1);
			ArrayList listNews = (ArrayList) ndao.queryPage(1, pf.getPageSie());
			int currentBar = (pf.getPage() - 1) / pf.getBarSize() + 1;
			session.setAttribute("currentBar", currentBar);
			session.setAttribute("listNews", listNews);
			session.setAttribute("pageList", pf.paging());
			session.setAttribute("nowpage", 1);
			session.setAttribute("barcount", pf.getBarCount());
			session.setAttribute("pagecount", pf.getpageCount());
			// System.out.println(path);
			try {
				FileWriter fw = new FileWriter(path);
				BufferedWriter bw = new BufferedWriter(fw);
				bw
						.write("<table width=\"100%\"  border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n");
				bw.write("<tr>\n");
				bw
						.write("<td nowrap class=\"toolbar\" onMouseOver=\"OMO()\" onMouseOut=\"OMOU()\" onClick=\"add()\" align=right style=\"cursor:hand\"><u>添加新闻</u></a></td>\n");
				bw.write("</tr>\n");
				bw.write("</table>");
				bw.flush();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return mapping.findForward("success");
		} else {
			String logonType = "no";
			session.setAttribute("logonType", logonType);
			try {
				FileOutputStream fos = new FileOutputStream(path);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				DataOutputStream dos = new DataOutputStream(bos);
				try {
					dos.writeBytes("");
					dos.flush();
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return mapping.findForward("fail");
		}

	}

}
