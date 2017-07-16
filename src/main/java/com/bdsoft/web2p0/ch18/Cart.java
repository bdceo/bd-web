package com.bdsoft.web2p0.ch18;

import java.util.HashMap;
import java.util.Iterator;

public class Cart {

	private HashMap contents = null;

	/**
	 * 创建一个购物车实例
	 */
	public Cart() {
		contents = new HashMap();
	}

	/**
	 * 往购物车中添加物品
	 */
	public void addItem(String itemCode, int itemCount) {

		Catalog catalog = new Catalog();

		if (catalog.containsItem(itemCode)) {
			Item item = catalog.getItem(itemCode);

			int newQuantity = itemCount;
			if (contents.containsKey(item)) {
				Integer currentQuantity = (Integer) contents.get(item);
				newQuantity += currentQuantity.intValue();
			}

			contents.put(item, new Integer(newQuantity));
		}
	}

	/**
	 * 从购物车中删除物品
	 */
	public void removeItems(String itemCode) {

		contents.remove(new Catalog().getItem(itemCode));
	}

	/**
	 * @return 添加物品到购物车中的XML
	 */

	/*
	 * XML的格式如下: <?xml version="1.0" encoding="GBK" ?> <cart generated=""
	 * total=""> <item code=""> <name> </name> <quantity> </quantity> </item>
	 * </cart>
	 */
	public String toAddXml(String itemCode) {
		Catalog catalog = new Catalog();
		Item item = catalog.getItem(itemCode);

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
		xml.append("<cart generated=\"" + System.currentTimeMillis()
				+ "\" total=\"" + getCartTotal() + "\">");

		int itemQuantity = ((Integer) contents.get(item)).intValue();

		xml.append("<item code=\"" + item.getCode() + "\">");
		xml.append("<name>");
		xml.append(item.getName());
		xml.append("</name>");
		xml.append("<quantity>");
		xml.append(itemQuantity);
		xml.append("</quantity>");
		xml.append("</item>");

		xml.append("</cart>");
		// System.out.println(xml.toString());
		return xml.toString();
	}

	/**
	 * @return 从购物车中删除物品的XML
	 */

	/*
	 * XML的格式如下: <?xml version="1.0" encoding="GBK" ?> <cart generated=""
	 * total=""> <item> <name> </name> </item> </cart>
	 */
	public String toRemoveXml(String itemCode) {
		Catalog catalog = new Catalog();
		Item item = catalog.getItem(itemCode);

		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
		xml.append("<cart generated=\"" + System.currentTimeMillis()
				+ "\" total=\"" + getCartTotal() + "\">");
		xml.append("<item>");
		xml.append("<name>");
		xml.append(item.getName());
		xml.append("</name>");
		xml.append("</item>");

		xml.append("</cart>");
		// System.out.println(xml.toString());
		return xml.toString();
	}

	private String getCartTotal() {
		int total = 0;

		for (Iterator I = contents.keySet().iterator(); I.hasNext();) {
			Item item = (Item) I.next();
			int itemQuantity = ((Integer) contents.get(item)).intValue();
			total += (item.getPrice() * itemQuantity);
		}

		return ("￥" + total);
	}

}
