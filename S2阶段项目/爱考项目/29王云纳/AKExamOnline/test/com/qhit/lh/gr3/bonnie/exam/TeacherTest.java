/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam;

import org.hibernate.Transaction;
import org.junit.Test;

import com.qhit.lh.gr3.bonnie.exam.common.bean.User;
import com.qhit.lh.gr3.bonnie.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.exam.jsgl.bean.Teacher;

/**
 * @author 王云纳
 *2018年1月9日下午5:22:55
 * TODO
 */
public class TeacherTest extends BaseDao {
	
	@Test
	public void add(){
		Teacher teacher = new Teacher();
		teacher.setTname("张亚辉");
		teacher.setSex("女");
		teacher.setPost("辅导员");
		
		User user = new User();
		user.setName("150202");
		user.setPwd("123456");
		user.setRole(2);
		
		teacher.setUser(user);
		
		Transaction ts = getSession().beginTransaction();
		getSession().save(teacher);
		ts.commit();
		
		
	}

}
