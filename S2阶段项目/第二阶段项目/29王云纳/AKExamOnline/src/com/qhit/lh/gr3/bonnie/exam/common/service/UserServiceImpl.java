/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.common.service;

import com.qhit.lh.gr3.bonnie.exam.common.bean.User;
import com.qhit.lh.gr3.bonnie.exam.common.dao.UserDao;
import com.qhit.lh.gr3.bonnie.exam.common.dao.UserDaoImpl;

/**
 * @author ������
 *2018��1��4������5:15:34
 * TODO
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

}
