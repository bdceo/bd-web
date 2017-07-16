package com.bdsoft.web2p0.ch21;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DbOperate {

	/**
	 * 根据用户名得到Blog对象
	 */
	public Blog getBlog(String userId) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Blog blog = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session
					.createQuery("from Blog where username=:userId");
			query.setParameter("userId", userId);
			List list = query.list();
			if (!list.isEmpty())
				blog = (Blog) list.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}
		session.close();
		return blog;
	}

	/**
	 * 根据ID得到Blog对象
	 */
	public Blog getBlog(int Id) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Blog blog = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session.createQuery("from Blog where id=" + Id);
			List list = query.list();
			if (!list.isEmpty())
				blog = (Blog) list.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		session.close();
		return blog;
	}

	/**
	 * 得到热点Blog对象集
	 */
	public List getBlogs(int showCount) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session
					.createQuery("from Blog order by visitcount desc");
			if (showCount > 0) {
				query.setMaxResults(showCount); // 记录集最大个数
			}
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到匹配Blog对象集
	 */
	public List getMatchBlogs(String key) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session.createQuery("from Blog where subject like '%"
					+ key + "%'");
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 根据ID得到Sort对象
	 */
	public Sort getSort(int Id) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Sort sort = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session.createQuery("from Sort where id=" + Id);
			List list = query.list();
			if (!list.isEmpty())
				sort = (Sort) list.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		session.close();
		return sort;
	}

	/**
	 * 根据ID得到Links对象
	 */
	public Links getLink(int Id) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Links link = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session.createQuery("from Links where id=" + Id);
			List list = query.list();
			if (!list.isEmpty())
				link = (Links) list.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		session.close();
		return link;
	}

	/**
	 * 得到指定文章对象
	 */
	public Article getArticle(int articleid) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Article article = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session.createQuery("from Article where id="
					+ articleid);
			List list = query.list();
			if (!list.isEmpty())
				article = (Article) list.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		session.close();
		return article;
	}

	/**
	 * 得到匹配Article对象集
	 */
	public List getMatchArticles(String key) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session
					.createQuery("from Article where title like '%" + key
							+ "%'");
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到最新文章对象集
	 */
	public List getArticles(int showCount) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			Query query = session
					.createQuery("from Article order by pubtime desc");
			if (showCount > 0) {
				query.setMaxResults(showCount); // 记录集最大个数
			}
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到指定博客最新文章对象集
	 */
	public List getBlogArticles(int blogid, int sortid)
			throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			String strSql = "from Article  where blogid=" + blogid;// 创建一个查询语句,查询指定类别产品;
			if (sortid > 0) {
				strSql = strSql + " and sortid=" + sortid; // 记录集最大个数
			}
			strSql = strSql + " order by pubtime desc"; // 记录集最大个数
			Query query = session.createQuery(strSql);
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到指定博客文章分类对象集
	 */
	public List getBlogSorts(int blogid) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			String strSql = "from Sort where blogid=" + blogid;// 创建一个查询语句,查询指定类别产品;
			Query query = session.createQuery(strSql);
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到指定博客超级链接对象集
	 */
	public List getBlogLinks(int blogid) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			String strSql = "from Links where blogid=" + blogid;// 创建一个查询语句,查询指定类别产品;
			Query query = session.createQuery(strSql);
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 得到指定文章回复对象集
	 */
	public List getFeedBacks(int articleid) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		List list = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 创建查询对象
			String strSql = "from FeedBack  where articleid=" + articleid
					+ " order by pubtime desc"; // 创建一个查询语句,查询指定类别产品;
			Query query = session.createQuery(strSql);
			list = query.list(); // 从数据库取出数据，并自动封装到List集合中
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}

	/**
	 * 插入实体对象所对应的记录
	 */
	public void save(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		if (obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(obj);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}

	/**
	 * 修改实体对象所对应的记录
	 */
	public void update(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();

		if (obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(obj);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}

	/**
	 * 删除对象所对应的记录
	 */
	public void delete(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		if (obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(obj);
				tx.commit();
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}
}
