package test.com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet05.Service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet05.Service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Dept;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Emp;




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

}
