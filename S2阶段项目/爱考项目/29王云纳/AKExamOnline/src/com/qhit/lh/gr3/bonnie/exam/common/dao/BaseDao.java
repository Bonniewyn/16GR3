/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.bonnie.exam.common.utils.HibernateSessionFactory;
/**
 * @author 王云纳
 *2018年1月4日下午5:23:40
 * TODO
 */
public class BaseDao {
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}

}
