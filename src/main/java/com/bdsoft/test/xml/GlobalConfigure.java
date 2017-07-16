package com.bdsoft.test.xml;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

/**
 * ��ȡ�����ļ�
 * 
 * @author Administrator
 * 
 */
public class GlobalConfigure {

	private static GlobalConfigure instance = new GlobalConfigure();

	private static final String CONFIG_FILE_NAME = "com/code/test/xml/gobal-configure.xml";

	private Element rootElt;

	private JdbcInfo jdbcInfo = new JdbcInfo();

	private Map beanMap = new HashMap();

	private GlobalConfigure() {
		// ����װ�ڵĶ���
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(Thread.currentThread()
					.getContextClassLoader().getResourceAsStream(
							CONFIG_FILE_NAME));
			this.rootElt = doc.getRootElement();
			initJdbcInfo();
			initBeans();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initJdbcInfo() {
		try {
			Element driverClassNameElt = (Element) XPath.selectSingleNode(
					rootElt, "//sys-configure/jdbc-info/driver-class-name");
			jdbcInfo.setDriverClassName(driverClassNameElt.getText());

			Element urlsElt = (Element) XPath.selectSingleNode(rootElt,
					"//sys-configure/jdbc-info/urls");
			jdbcInfo.setUrls(urlsElt.getText());

			Element userNameElt = (Element) XPath.selectSingleNode(rootElt,
					"//sys-configure/jdbc-info/user-name");
			jdbcInfo.setUserName(userNameElt.getText());

			Element passwordElt = (Element) XPath.selectSingleNode(rootElt,
					"//sys-configure/jdbc-info/password");
			jdbcInfo.setPassword(passwordElt.getText());
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}

	private void initBeans() {
		try {
			List<Element> beanList = XPath.selectNodes(rootElt,
					"//sys-configure/beans/bean");
			for (Element let : beanList) {
				String id = let.getAttributeValue("id");
				String classPath = let.getAttributeValue("class");
				// System.out.println(id + " : " + classPath);
				Object obj = (Object) Class.forName(classPath);
				beanMap.put(id, obj);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String str) {
		return beanMap.get(str);
	}

	public static GlobalConfigure getInstance() {
		return instance;
	}

	public JdbcInfo getJdbcInfo() {
		return jdbcInfo;
	}

	public static void main(String[] args) {
		System.out.println(GlobalConfigure.getInstance().getJdbcInfo());
		Object obj = GlobalConfigure.getInstance().getBean("ajax");
	}
}
