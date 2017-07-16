package com.bdsoft.test.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

public class XMLWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Element rootElt = new Element("slects");
		Element selElt = new Element("select");
		Element idElt = new Element("id");
		idElt.setText("1");
		Element nameElt = new Element("name");
		nameElt.setText("hebei");

		rootElt.addContent(selElt);
		selElt.addContent(idElt);
		selElt.addContent(nameElt);

		Document doc = new Document();
		doc.addContent(rootElt);

		XMLOutputter out = new XMLOutputter();
		// out.setFormat(Format.getCompactFormat().setEncoding("gbk"));

		String xmlStr = out.outputString(doc);
		System.out.println(xmlStr);

		try {
			out.output(doc, new FileOutputStream("c:/tt.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
