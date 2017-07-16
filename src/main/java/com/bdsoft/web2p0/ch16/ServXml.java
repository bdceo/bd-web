package com.bdsoft.web2p0.ch16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ServXml {
	private Document dom;

	public ServXml() {
		try {
			SAXBuilder builder = new SAXBuilder();
			this.dom = builder.build(ServXml.class.getResource("news.xml"));
		} catch (Exception ex) {
			this.handleError(ex);
		}
	}

	/**
	 * 获取全部的新闻列表
	 * 
	 * @return
	 */
	public Item[] getAllMessage() {
		Collection newslist = new ArrayList();
		if (this.dom.getRootElement().getChildren().size() != 0) {
			Iterator iterator = this.dom.getRootElement().getChildren()
					.iterator();
			do {
				Element element = (Element) iterator.next();
				Item news = new Item(element);
				newslist.add(news);
			} while (iterator.hasNext());
			return (Item[]) newslist.toArray(new Item[0]);
		} else
			return new Item[0];
	}

	/**
	 * 处理系统异常
	 * 
	 * @param ex
	 */
	private void handleError(Exception ex) {
		ex.printStackTrace();
		System.out.println(ex.toString());
	}
}
