package com.bdsoft.test.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bdsoft.global.utils.HibernateUtils;
import com.bdsoft.test.pojo.Class;
import com.bdsoft.test.pojo.StuInfo;

public class AjaxDao { 
	public List loadClass() {
		List list = null;
		Session session = HibernateUtils.getSession();
		String hql = "from Class";
		Query qu = session.createQuery(hql);
		list = qu.list();
		return list;
	}

	public Set loadStu(String cid) {
		Session session = HibernateUtils.getSession();
		Class cls = (Class) session.get(Class.class, cid);
		return cls.getStuInfos();
	}

	public static void main(String[] asr) {
		AjaxDao dao = new AjaxDao();
		List all = dao.loadClass();
		Iterator ite = all.iterator();
		while (ite.hasNext()) {
			Class cl = (Class) ite.next();
			System.out.println(cl.getCid() + ":" + cl.getCname());
		}
		Set set = dao.loadStu("001");
		Iterator itt = set.iterator();
		while (itt.hasNext()) {
			StuInfo stu = (StuInfo) itt.next();
			System.out.println(stu.getSid() + ":" + stu.getSname());
		}
	}
}
