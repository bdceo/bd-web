package com.bdsoft.test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bdsoft.global.utils.HibernateUtils;

public class TreeDao {
	public List getParents() {
		List list = null;
		Session session = HibernateUtils.getSession();
		Transaction tran = null;
		String hql = "from SysRight";
		try {
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();
			tran.commit();
		} catch (Exception se) {
			if (tran != null) {
				tran.rollback();
			}
			System.out.println("ϵͳ����!�ڱ���־û�����ʱ��?ԭ���ǣ�");
			se.printStackTrace();
		} finally {
			HibernateUtils.closeSession();
		}
		return list;
	}

}
