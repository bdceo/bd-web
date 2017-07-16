package com.bdsoft.web2p0.ch22.struts.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bdsoft.web2p0.ch22.base.PageFunction;
import com.bdsoft.web2p0.ch22.dao.NewsFormDAO;
import com.bdsoft.web2p0.ch22.struts.form.NewsForm;

public class NewsOptionAction extends Action {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String method = request.getParameter("method");
		if (method.equals("add")) {
			return addNews(mapping, form, request, response);
		}
		if (method.equals("list")) {
			listNews(form, request, response);
		}
		if (method.equals("typeme")) {
			return typeNews(mapping, form, request, response);
		}
		if (method.equals("modify")) {
			return modifyNews(mapping, form, request, response);
		}
		if (method.equals("typenews")) {
			return typeNews(mapping, form, request, response);
		}
		if (method.equals("findpage")) {
			return findPage(mapping, form, request, response);
		}
		return null;
	}

	public ActionForward addNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		NewsForm newsForm = (NewsForm) form;
		NewsFormDAO ndao = new NewsFormDAO();
		if (ndao.insertNews(newsForm) != 0) {
			return mapping.findForward("addSuccess");
		} else {
			return mapping.findForward("addFailure");
		}
	}

	public void listNews(ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			NewsFormDAO ndao = new NewsFormDAO();
			ArrayList listNews = (ArrayList) ndao.queryAll();
			session.setAttribute("listNews", listNews);
			out
					.print("<script>alert('操作成功');window.opener.location.reload();window.close();</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ActionForward typeNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String method = request.getParameter("method");
		HttpSession session = request.getSession();
		int newsid = Integer.parseInt(request.getParameter("newsid"));
		NewsForm modifyNews = new NewsFormDAO().selectNews(newsid);
		session.setAttribute("modifyNews", modifyNews);
		if (method.equals("typeme")) {
			return mapping.findForward("modifyMe");
		}
		if (method.equals("typenews")) {
			return mapping.findForward("typeNews");
		}
		return null;
	}

	public ActionForward findPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		PageFunction pf = new PageFunction();
		NewsFormDAO ndao = new NewsFormDAO();
		String currentBar = request.getParameter("currentBar");
		String barType = request.getParameter("barType");
		String pagetemp = request.getParameter("page");
		String pageType = request.getParameter("pageType");
		int nowCurrentBar = 0;
		int page = 0;
		pf.setTotalCount(ndao.newsCount());
		if ("next".equals(barType) && !"".equals(currentBar)) {
			page = Integer.parseInt(currentBar) * pf.getBarSize() + 1;
			nowCurrentBar = Integer.parseInt(currentBar) + 1;
			if (nowCurrentBar == pf.getBarCount()) {
				nowCurrentBar = pf.getBarCount();
			}
		}
		if ("pre".equals(barType) && !"".equals(currentBar)) {
			page = (Integer.parseInt(currentBar) - 1) * pf.getBarSize();
			nowCurrentBar = Integer.parseInt(currentBar) - 1;
			if (nowCurrentBar == 1) {
				nowCurrentBar = 1;
			}
		}
		if (!"".equals(pagetemp) && pagetemp != null) {
			page = Integer.parseInt(pagetemp);
		}
		if ("first".equals(pageType)) {
			nowCurrentBar = 1;
		}
		if ("last".equals(pageType)) {
			nowCurrentBar = pf.getBarCount();
		}
		pf.setPage(page);
		if ((!"".equals(pageType) || pageType == null)
				&& (!"".equals(barType) || barType == null)) {
			nowCurrentBar = pf.getCurrentBar();
		}
		ArrayList listNews = (ArrayList) ndao.queryPage(page, pf.getPageSie());
		session.setAttribute("listNews", listNews);
		session.setAttribute("pageList", pf.paging());
		session.setAttribute("currentBar", nowCurrentBar);
		session.setAttribute("nowpage", page);
		return mapping.findForward("pageList");

	}

	public ActionForward modifyNews(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			NewsForm newsForm = (NewsForm) form;
			newsForm.setNewsId(request.getParameter("newsid"));
			NewsFormDAO ndao = new NewsFormDAO();
			if (ndao.modifyNews(newsForm) != 0) {
				return mapping.findForward("addSuccess");
			} else {
				out.print("<script>alert('修改失败');history.go(-1);</script>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
