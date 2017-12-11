package com.qhit.lh.gr3.bonnie.hibernatet01;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet01.bean.User;
import com.qhit.lh.gr3.bonnie.hibernatet01.service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet01.service.impl.BaseServiceImpl;

/**
 * @author 王云纳
 * TODO
 * 2017年12月11日上午11:21:29
 */
public class UserTest {
   private BaseService baseService = new BaseServiceImpl();
	@Test
	public void addUser() {
		//声明并实例化对象
		User user = new User();
		user.setUname("jack");
		user.setUpwd("123");
		user.setBirthday("1996-05-20");
		user.setSex("m");
		user.setEnable(1);
		//数据操作
		baseService.add(user);
	}
	@Test
	public void deleteUser() {
		//声明并实例化对象
		User user = new User();
		user.setId(1);
		//数据操作
		baseService.delete(user);
	}
	@Test
	public void update() {
		//声明并实例化对象
		User user = new User();
		user.setId(2);
		user.setUname("sss");
		user.setUpwd("123456");
		user.setBirthday("1997-05-20");
		user.setSex("m");
		user.setEnable(1);
		//数据操作
		baseService.update(user);
	}
	@Test
	public void getAll() {
		List<Object> list = baseService.getAll("from User");
	    for(Object object : list){
	    	User user = (User) object;
	    	System.out.println(user.toString());
	    }
	}
}
