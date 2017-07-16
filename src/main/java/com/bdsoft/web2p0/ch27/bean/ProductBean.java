package com.bdsoft.web2p0.ch27.bean;
public class ProductBean {
	private String cdName;

	private String cdCompany;

	private String cdAlbum;

	private String cdType;

	private long cdId;

	public ProductBean() {

	}

	public void setCdName(String cdName) {
		this.cdName = cdName;
	}

	public String getCdName() {
		return cdName;
	}

	public void setCdCompany(String cdCompany) {
		this.cdCompany = cdCompany;
	}

	public String getCdCompany() {
		return cdCompany;
	}

	public void setCdAlbum(String cdAlbum) {
		this.cdAlbum = cdAlbum;
	}

	public String getCdAlbum() {
		return cdAlbum;
	}

	public void setCdType(String cdType) {
		this.cdType = cdType;
	}

	public String getCdType() {
		return cdType;
	}

	public void setCdId(long cdId) {
		this.cdId = cdId;
	}

	public long getCdId() {
		return cdId;
	}
}
