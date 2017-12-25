package test.com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet05.Service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet05.Service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Dept;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Emp;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.User;
import com.qhit.lh.gr3.bonnie.hibernatet05.utils.HibernateSessionFactory;



/**
 * @author 王云纳
 * TODO
 * 2017年12月13日上午10:18:41
 */
public class EmpTest {

	private BaseService baseService = new BaseServiceImpl();
	/**
	 * 添加员工，并分配一个账户
	 */
	@Test
	public void add() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEmpName("jackk");
		emp.setEmpSex("M");
		emp.setBirthday("2017-12-13");
		//分配一个账户
		User user = new User();
		user.setUserName("jackk");
		user.setPassword("123456");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工
		//分配所属的部门
		Dept dept = new Dept();
		dept =	(Dept) baseService.getObjectById(dept.getClass(), 2);
		//建立多对一的关联
		emp.setDept(dept);
		//级联操作
		baseService.add(emp);

	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp.getClass(), 10);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		//声明员工对象
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp.getClass(), 9);
		emp.setEmpName("tomdog");
		User user = emp.getUser();
		user.setUserName("tomdog");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工
		//修改所属的部门：并不是修改部门本身的信息
		Dept dept = new Dept();
		dept =	(Dept) baseService.getObjectById(dept.getClass(), 2);
		//建立多对一关联
		emp.setDept(dept);
		//级联操作
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}
	}
		@Test
     public void getEmpByName() {
			List<Emp> list = baseService.getEmpByName("%啦%");
			
			for (Emp emp : list) {
				System.out.println(emp.getEid()+":"+emp.getEmpName()+":"+emp.getEmpSex()+":"+emp.getBirthday());
			}
	}
		@Test
	     public void getEmpLikeName() {
			    //1，获取session对象
				Session session = HibernateSessionFactory.getSession();
				//2，通过session对象创建criteria条件查询器
				Criteria criteria = session.createCriteria(Emp.class)
						.add(Restrictions.like("empName", "啦%"));
				//3，通过criteria条件查询器进行查询
				List<Emp> list = criteria.list();
				//4，遍历输出
				for(Emp emp : list){
					System.out.println(emp.getEid()+":"+emp.getEmpName());
				}
		}
		@Test
	     public void getEmpByDeptName() {
			    //1，获取session对象
				Session session = HibernateSessionFactory.getSession();
				//2，通过session对象创建criteria条件查询器
				Criteria criteria = session.createCriteria(Emp.class)
						.setFetchMode("dept",FetchMode.JOIN)
						.createAlias("dept","d")
						.add(Restrictions.eq("d.deptName","政治部"));
				//3，通过criteria条件查询器进行查询
				List<Emp> list = criteria.list();
				//4，遍历输出
				for(Emp emp : list){
					System.out.println(emp.getEid()+":"+emp.getEmpName());
				}
		}
}
