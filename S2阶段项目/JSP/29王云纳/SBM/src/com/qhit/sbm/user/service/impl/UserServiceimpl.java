package com.qhit.sbm.user.service.impl;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceimpl implements UserService {
	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

}


