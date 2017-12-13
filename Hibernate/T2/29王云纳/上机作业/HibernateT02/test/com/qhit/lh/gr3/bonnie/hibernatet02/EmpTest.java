package com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet02.Service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet02.Service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.bonnie.hibernatet02.bean.Emp;
import com.qhit.lh.gr3.bonnie.hibernatet02.bean.User;

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
		emp.setEmpName("zhangli");
		emp.setEmpSex("F");
		emp.setBirthday("1998-08-12");
		emp.setDeptId(1);
		//分配一个账户
		User user = new User();
		user.setUserName("zhangli");
		user.setPassword("123456");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工

		//级联操作
		baseService.add(emp);

	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 2);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEid(7);
		emp.setEmpName("tom");
		emp.setEmpSex("F");
		emp.setBirthday("2013-05-01");
		emp.setDeptId(1);
		//分配一个账户
		User user = new User();
		user.setUserId(7);
		user.setUserName("tom");
		user.setPassword("123");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工

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

}
