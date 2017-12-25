package test.com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet05.Service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet05.Service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Dept;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Emp;
import com.qhit.lh.gr3.bonnie.hibernatet05.utils.HibernateSessionFactory;




public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add(){
		//创建部门
		Dept dept = new Dept();
		dept.setDeptName("政治部");
		dept.setAddress("郸城");
		//没有员工
		
		//有新员工
		Emp lala = new Emp();
		lala.setEmpName("啦啦");
		lala.setEmpSex("M");
		lala.setBirthday("2012-12-12");
		
		Emp kaka = new Emp();
		kaka.setEmpName("卡卡");
		kaka.setEmpSex("F");
		kaka.setBirthday("2017-12-14");
		
		dept.getEmps().add(lala);
		dept.getEmps().add(kaka);
		//级联操作
		baseService.add(dept);

	}
	
	@Test
	public void delete(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 4);
		
		baseService.delete(dept);
	}
	
	@Test
	public void update(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 3);
		dept.setDeptName("政治部");
		
		baseService.update(dept);
	}
	
	@Test
	public void query(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
		
		for(Emp emp:dept.getEmps()){
			System.out.println(dept.getDeptName()+":"+emp.getEmpName());
		}
	}
	/**
	 * 查询每个部门的员工人数，显示出部门信息和人数
	 */
	@Test
	public void getDeptInfo(){
		 //1，获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emps",FetchMode.JOIN)
				.createAlias("emps","e");
		//设置分组条件和查询结果
		ProjectionList proList = Projections.projectionList()
				.add(Projections.groupProperty("deptId"))
				.add(Projections.groupProperty("deptName"))
				.add(Projections.groupProperty("address"))
				.add(Projections.count("e.eid"));
		//关联条件查询器和结果
		criteria.setProjection(proList);
		//3，通过criteria条件查询器进行查询
		List<Object[]> list = criteria.list();
		//4，遍历输出
		for(Object[] obj : list){
			System.out.println(""+obj[0]+obj[1]+obj[2]+obj[3]);
		}
	}

}
