/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.bonnie.exam.common.utils.HibernateSessionFactory;
/**
 * @author ������
 *2018��1��4������5:23:40
 * TODO
 */
public class BaseDao {
	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}

}
