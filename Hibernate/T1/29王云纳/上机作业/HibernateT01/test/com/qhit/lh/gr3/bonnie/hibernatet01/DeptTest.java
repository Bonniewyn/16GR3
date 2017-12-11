package com.qhit.lh.gr3.bonnie.hibernatet01;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet01.bean.Dept;
import com.qhit.lh.gr3.bonnie.hibernatet01.service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet01.service.impl.BaseServiceImpl;

/**
 * @author 王云纳
 * TODO
 * 2017年12月11日上午11:39:41
 */
public class DeptTest {
	 private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addDept() {
	//1,声明并实例化对象
		Dept dept = new Dept();
		dept.setName("信息工程");
		//2,操作对象
		baseService.add(dept);
	}

}
