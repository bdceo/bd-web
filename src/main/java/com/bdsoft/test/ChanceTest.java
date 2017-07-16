package com.bdsoft.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bdsoft.global.utils.HibernateUtils;
import com.bdsoft.test.pojo.SalPlan;

public class ChanceTest {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSession();
		Transaction tran = null;
		SalPlan plan = new SalPlan();
		// SalChance chance = new SalChance();
		// chance.setChcCustName("�ͻ����2");
		// chance.setChcId(Long.parseLong("18"));
		// chance.setChcRate(39);
		// chance.setChcTitle("���ۻ���Ҫss");
		// chance.setChcLinkman("jϵ��ss");
		// chance.setChcTel("1347233233");
		// chance.setChcSource("���4Դss");
		// chance.setChcDesc("�������ss");
		// chance.setChcCreateBy("jl");
		// chance.setChcCreateId(Long.parseLong("7"));
		// chance.setChcCreateDate(new Date());
		// chance.setChcStatus("2");
		// chance.setChcDueDate("1988-05-17");
		// chance.setChcDueId(Long.parseLong("7"));
		// chance.setChcDueTo("jl");
		String hql = "update SalPlan set plaTodo=? where plaId=?";
		try {
			tran = session.beginTransaction();
			Query query = session.createQuery(hql);
			query.setString(0, "08ddddddd");
			query.setLong(1, Long.parseLong("8"));
			System.out.println(query.executeUpdate());
			// List list=query.list();
			// SalChance chance=(SalChance)list.get(0);
			// System.out.println(chance.getChcId());
			// System.out.println(chance.getChcCustName());
			// System.out.println(chance.getChcCreateBy());
			// System.out.println(chance.getChcLinkman());
			// query.executeUpdate();
			tran.commit();
			System.out.println("done!");
		} catch (Exception se) {
			se.printStackTrace();
			System.out.println("failure!");
		} finally {
			HibernateUtils.closeSession();
		}
	}
}
