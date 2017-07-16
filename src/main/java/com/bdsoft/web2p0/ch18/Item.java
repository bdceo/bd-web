package com.bdsoft.web2p0.ch18;

public class Item {
	private String code = null;
	private String name = null;
	private String description = null;
	private int price = 0;

	public Item(String code, String name, String description, int price) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getFormattedPrice() {
		return ("￥" + price);
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (this == null)
			return false;
		if (!(o instanceof Item))
			return false;
		return ((Item) o).getCode().equals(this.code);
	}
}
