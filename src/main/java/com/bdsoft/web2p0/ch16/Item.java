package com.bdsoft.web2p0.ch16;

import org.jdom.Element;

public class Item {
	private String id = "";
	private String title = "";
	private String author = "";

	public Item() {

	}

	public Item(Element element) {
		this.id = element.getAttributeValue("id");
		this.title = element.getChildText("title");
		this.author = element.getChildText("submittime");
	}

	public Item(String id, String title, String submittime) {
		this.id = id;
		this.title = title;
		this.author = submittime;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
