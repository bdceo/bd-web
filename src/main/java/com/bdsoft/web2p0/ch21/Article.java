package com.bdsoft.web2p0.ch21;

public class Article {
	private int id;		
	private String title;		
	private String content;	
	private String pubtime;	
	private int blogid;		
	private int sortid;		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSortid() {
		return sortid;
	}
	public void setSortid(int sortid) {
		this.sortid = sortid;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}		

}
