/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.exam.common.action.UserAction;
import com.qhit.lh.gr3.bonnie.exam.common.bean.User;


/**
 * @author 王云纳
 *2018年1月9日下午5:24:03
 * TODO
 */
public class UserTest {
	
	@Test
	public void login(){
		UserAction userAction = new UserAction();
		
		User user = new User();
		user.setName("admin");
		user.setPwd("123456");
		user.setRole(4);
		
		userAction.setUser(user);
		
		System.out.println(userAction.login());;
		
	}

}
