package com.bdsoft.web2p0.ch27.util;

import java.util.ArrayList;

import com.bdsoft.web2p0.ch27.bean.ProductBean;

public class ProductXML {
	String strXML = "";
	String top = "<MusicList>\n";
	String top_ = "</MusicList>";
	String count = "<Count>";
	String count_ = "</Count>\n";

	public ProductXML() {
		strXML = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" + top;
	}

	public String getXML(ArrayList list, int pageCount) {
		for (int i = 0; i < list.size(); i++) {
			ProductBean cd = (ProductBean) list.get(i);
			strXML += addMusicBean(cd);
		}
		return strXML + count + pageCount + count_ + top_;
	}

	public String getXML(ProductBean cd) {
		strXML += addMusicBean(cd);
		return strXML + top_;
	}

	public String addMusicBean(ProductBean cds) {
		String header = "<mycd>\n";
		String header_ = "</mycd>\n";
		String cdName = "<cdName>";
		String cdName_ = "</cdName>\n";
		String cdCom = "<cdCom>";
		String cdCom_ = "</cdCom>\n";
		String cdSinger = "<cdSinger>";
		String cdSinger_ = "</cdSinger>\n";
		String cdType = "<cdType>";
		String cdType_ = "</cdType>\n";
		String ID = "<ID>";
		String ID_ = "</ID>\n";
		String str = header + cdName + cds.getCdName() + cdName_ + cdCom
				+ cds.getCdCompany() + cdCom_ + cdSinger + cds.getCdAlbum()
				+ cdSinger_ + cdType + cds.getCdType() + cdType_ + ID
				+ cds.getCdId() + ID_ + header_;
		return str;
	}
}
