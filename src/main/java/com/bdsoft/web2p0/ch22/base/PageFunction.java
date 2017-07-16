package com.bdsoft.web2p0.ch22.base;

import java.io.Serializable;
import java.util.ArrayList;

public class PageFunction implements Serializable {
	private int page;
	private int totalCount;
	private int pageSie = 10;
	private int barSize = 10;

	public ArrayList paging() {
		int page = this.page;
		if (page == 0) {
			page = 1;
		}
		if (page == (getpageCount() + 1)) {
			page = getpageCount();
		}
		int pageSize = this.pageSie;
		int total = this.totalCount;
		int barSize = this.barSize;
		ArrayList mypa = new ArrayList();
		int pageCount = (total - 1) / pageSize + 1;// 总页数
		int barPageCount = (pageCount - 1) / barSize + 1; // bar的总页数
		int currentBar = (page - 1) / barSize + 1; // 当前bar号
		if (page == pageCount || currentBar == barPageCount) {// 判断当前bar是否最后页
			// 或 当前页是否最后页
			int xx = pageCount % barSize; // 最后页bar记录数
			int i = (page - 1) / barSize; // 获取前面N-1页bar数
			for (int j = 0; j < xx; j++) {
				mypa.add(barSize * i + (j + 1)); // 最后页bar的页码数
			}
		} else {
			int i = (page - 1) / barSize; // 获取前面N-1页bar数
			for (int ii = 0; ii < barSize; ii++) {
				mypa.add(barSize * i + (ii + 1)); // 最后页bar的页码数
			}
		}
		return mypa;
	}

	public int getBarCount() {
		int pageSize = this.pageSie;
		int total = this.totalCount;
		int pageCount = (total - 1) / pageSize + 1;// 总页数
		int barPageCount = (pageCount - 1) / barSize + 1; // bar的总页数
		return barPageCount;
	}

	public int getpageCount() {
		int pageSize = this.pageSie;
		int total = this.totalCount;
		int pageCount = (total - 1) / pageSize + 1;// 总页数
		return pageCount;
	}

	public int getCurrentBar() { // 获得当前页所在的bar号
		int page = this.page;
		int barSie = this.barSize;
		return (page - 1) / barSize + 1;
	}

	public PageFunction() {
	}

	public PageFunction(int page, int totalCount, int pageSie, int barSize) {
		super();
		this.page = page;
		this.totalCount = totalCount;
		this.pageSie = pageSie;
		this.barSize = barSize;
	}

	public int getBarSize() {
		return barSize;
	}

	public void setBarSize(int barSize) {
		this.barSize = barSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSie() {
		return pageSie;
	}

	public void setPageSie(int pageSie) {
		this.pageSie = pageSie;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
