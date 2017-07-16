package com.bdsoft.web2p0.ch18;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
	
	private static Map items = null;

	static {
		items = new HashMap();
		items.put("book001", new Item("book001", "《三国演义》", "罗贯中", 25));
		items.put("book002", new Item("book002", "《西游记》", "吴承恩", 25));
		items.put("book003", new Item("book003", "《人性的弱点》", "卡耐基", 40));
		items.put("book004", new Item("book004", "《人性的优点》", "卡耐基", 40));
		items.put("book005", new Item("book005", "《傲慢与偏见》", "奥斯汀", 30));
		items.put("book006", new Item("book006", "《基督山伯爵》", "大仲马", 60));
	}

	public Collection getAllItems() {
		return items.values();
	}

	public boolean containsItem(String itemCode) {
		return items.containsKey(itemCode);
	}

	public Item getItem(String itemCode) {
		return (Item) items.get(itemCode);
	}
}
