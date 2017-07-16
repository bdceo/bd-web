package com.bdsoft.web2p0.ch17;

public class AlbumEO {
	
	public AlbumEO()// 无参的构造方法
	{
	}

	protected int albumID;// 对应表中的album_id
	protected String albumName;// 对应表中的album_name
	protected String albumURL;// 对应表中的album_url
	protected String albumDescription;// 对应表中的album_desciption
	protected String albumCategory;// 对应表中的album_category
	protected String activeStatus;// 对应表中的active_status

	public String getActiveStatus() {// activeStatus的get方法
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {// activeStatus的set方法
		this.activeStatus = activeStatus;
	}

	public String getAlbumCategory() {// albumCategory的get方法
		return albumCategory;
	}

	public void setAlbumCategory(String albumCategory) {// albumCategory的set方法
		this.albumCategory = albumCategory;
	}

	public String getAlbumDescription() {// albumDescription的get方法
		return albumDescription;
	}

	public void setAlbumDescription(String albumDescription) {// albumDescription的set方法
		this.albumDescription = albumDescription;
	}

	public int getAlbumID() {// albumID的get方法
		return albumID;
	}

	public void setAlbumID(int albumID) {// albumID的set方法
		this.albumID = albumID;
	}

	public String getAlbumName() {// albumName的get方法
		return albumName;
	}

	public void setAlbumName(String albumName) {// albumName的set方法
		this.albumName = albumName;
	}

	public String getAlbumURL() {// albumURL的get方法
		return albumURL;
	}

	public void setAlbumURL(String albumURL) {// albumURL的set方法
		this.albumURL = albumURL;
	}
}
