package com.bdsoft.web2p0.ch18;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// 需要返回给页面的XML
		String cartXml = null;

		// 从session中得到购物车对象实例
		Cart cart = getCartFromSession(req);

		// 得到从页面发送来的参数
		String action = req.getParameter("action");
		String item = req.getParameter("item");
		int count = 0;
		if (req.getParameter("count") != null) {
			count = Integer.parseInt(req.getParameter("count"));
		}

		if ((action != null) && (item != null)) {

			if ("add".equals(action)) {
				cart.addItem(item, count);
				cartXml = cart.toAddXml(item);

			} else if ("remove".equals(action)) {
				cart.removeItems(item);
				cartXml = cart.toRemoveXml(item);
			}
		}

		res.setHeader("Content-Type", "text/xml;charset=GBK");
		res.setHeader("Cache-Control", "no-cache");
		res.setHeader("Pragma", "no-cache");
		res.getWriter().write(cartXml);
	}

	private Cart getCartFromSession(HttpServletRequest req) {

		HttpSession session = req.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		return cart;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
