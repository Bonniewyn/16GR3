package test.com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Emp;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.User;
import com.qhit.lh.gr3.bonnie.hibernatet05.utils.HibernateSessionFactory;

public class UserTest {

	@Test
	public void login() {
		 //1，获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(User.class)
			 .add(Restrictions.eq("userName", "zhangli"))
			 .add(Restrictions.eq("password","123456"));
		//3，通过criteria条件查询器进行查询
		List<User> list = criteria.list();
		//4，遍历输出
		if(list != null && list.size() > 0){
			System.out.println("登录成功");
		}else{
			System.out.println("登陆失败");
		}
	}

}
