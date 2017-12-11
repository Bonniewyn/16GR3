package com.qhit.lh.gr3.bonnie.hibernatet01.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.hibernatet01.utils.HibernateSessionFactory;

/**
 * @author 王云纳
 * TODO
 * 2017年12月11日上午11:07:42
 */
public class BaseDaoImpl implements BaseDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao#add(java.lang.Object)
	 * 添加
	 */
	@Override
	public void add(Object obj) {
		//1,获取Session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事务
		Transaction ts = session.beginTransaction();
		//3,执行
		session.save(obj);
		//4,提交事务
		ts.commit();
		//5,释放资源
		HibernateSessionFactory.closeSession();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao#delete(java.lang.Object)
	 * 删除
	 */
	@Override
	public void delete(Object obj) {
		//1,获取Session对象
				Session session = HibernateSessionFactory.getSession();
				//2,开启事务
				Transaction ts = session.beginTransaction();
				//3,执行
				session.delete(obj);
				//4,提交事务
				ts.commit();
				//5,释放资源
				HibernateSessionFactory.closeSession();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao#update(java.lang.Object)
	 * 修改
	 */
	@Override
	public void update(Object obj) {
		//1,获取Session对象
				Session session = HibernateSessionFactory.getSession();
				//2,开启事务
				Transaction ts = session.beginTransaction();
				//3,执行
				session.update(obj);
				//4,提交事务
				ts.commit();
				//5,释放资源
				HibernateSessionFactory.closeSession();
	}
	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao#getAll(java.lang.String)
	 * 查询
	 */
	@Override
	public List<Object> getAll(String fromObject) {
		  //1,获取Session对象
		Session session = HibernateSessionFactory.getSession();
		//2,开启事务
		Transaction ts = session.beginTransaction();
		//3,获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4,提交事务
		ts.commit();
		//5,释放资源
		HibernateSessionFactory.closeSession();
		return list;

	}

}
