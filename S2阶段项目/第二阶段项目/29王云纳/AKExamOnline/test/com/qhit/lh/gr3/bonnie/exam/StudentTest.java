/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.gr3.bonnie.exam.common.bean.User;
import com.qhit.lh.gr3.bonnie.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.exam.xsgl.bean.Student;

/**
 * @author ������
 *2018��1��9������5:21:10
 * TODO
 */
public class StudentTest extends BaseDao {
	
	@Test
	public void add(){
		//�½�ѧ��
		Student student = new Student();
		student.setSname("����");
		student.setSex("��");
		student.setEnterSchool("2016");
		//�����˻�
		User user = new User();
		user.setName("16030221001");
		user.setPwd("123456");
		user.setRole(1);
		
		student.setUser(user);
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(student);
		ts.commit();
	}

}
