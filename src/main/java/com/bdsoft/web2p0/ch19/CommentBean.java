package com.bdsoft.web2p0.ch19;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.jdom.CDATA;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Text;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class CommentBean {
	private String filepath;

	private SAXBuilder builder = null;

	private Document doc = null;

	public CommentBean() {

	}

	// 初始化XML文件路径,加载文件
	public CommentBean(String path) {
		this.filepath = path;
		builder = new SAXBuilder();
		try {
			doc = builder.build(filepath);
		} catch (JDOMException e) {
			System.out.print("找不到指定的XML文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("找不到指定的文件");
			e.printStackTrace();
		}
	}

	// 添加评论
	public String addComment(String nikename, String comment, String attitude) {
		Element root = doc.getRootElement();

		Element el = new Element("comment");
		Random rand = new Random();
		int id = rand.nextInt(10000);
		el.setAttribute("id", "comment_" + id);
		el.setAttribute("attitude", attitude);

		Element name = new Element("nikename");
		CDATA cname = new CDATA(nikename);
		name.addContent(cname);

		Element data = new Element("data");
		CDATA ctext = new CDATA(comment);
		data.addContent(ctext);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Text tdate = new Text(format.format(date));
		Element pubdate = new Element("pubdate");
		pubdate.addContent(tdate);

		el.addContent(name);
		el.addContent(data);
		el.addContent(pubdate);
		root.addContent(el);
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()
				.setEncoding("gb2312"));
		// 清除comment元素间的空格
		// outputter.setTrimAllWhite(true);
		try {
			outputter.output(doc, new FileWriter(filepath));
		} catch (IOException e) {
			System.out.println("指定路径有错");
			e.printStackTrace();
		}
		return tdate.getText();
	}

	// 删除指定ID的评论

	public String removeComment(String commentId) {
		Element root = doc.getRootElement();
		List comments = root.getChildren();
		int size = comments.size();
		Element dist = null;
		for (int i = 0; i < size; i++) {
			Element comment = (Element) comments.get(i);
			String id = comment.getAttributeValue("id");
			if (id.equals(commentId)) {
				dist = comment;
				break;
			}
		}
		if (dist != null) {
			root.removeContent(dist);
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()
					.setEncoding("gb2312"));
			// 清除comment元素间的空格
			// outputter.setTrimAllWhite(true);
			try {
				outputter.output(doc, new FileWriter(filepath));
			} catch (IOException e) {
				System.out.println("重写文件有出错");
				e.printStackTrace();
			}
			return "成功删除指定元素!";
		} else
			return "指定元素不存在!";
	}

	// 批量删除评论

	public String removeComments(String[] commentIdArgs) {
		Element root = doc.getRootElement();
		List comments = root.getChildren();
		int size = comments.size();
		int len = commentIdArgs.length;
		List dist = new ArrayList();
		outer: for (int i = 0; i < size; i++) {
			Element comment = (Element) comments.get(i);
			String id = comment.getAttributeValue("id");

			for (int j = 0; j < len; j++)
				if (id.equals(commentIdArgs[j])) {
					dist.add(comment);
					continue outer;
				}
		}
		int dist_size = dist.size();
		if (dist_size != 0) {
			for (int i = 0; i < dist_size; i++)
				root.removeContent((Element) dist.get(i));
			XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat()
					.setEncoding("gb2312"));
			// 清除comment元素间的空格
			// outputter.setTrimAllWhite(true);
			try {
				outputter.output(doc, new FileWriter(filepath));
			} catch (IOException e) {
				System.out.println("重写文件有出错");
				e.printStackTrace();
			}
			return "成功删除指定的元素集合!";
		} else
			return "指定元素集合的不存在!";
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public SAXBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(SAXBuilder builder) {
		this.builder = builder;
	}
}
