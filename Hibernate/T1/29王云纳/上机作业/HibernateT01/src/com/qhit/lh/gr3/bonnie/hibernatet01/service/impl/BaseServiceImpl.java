package com.qhit.lh.gr3.bonnie.hibernatet01.service.impl;

import java.util.List;

import com.qhit.lh.gr3.bonnie.hibernatet01.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.hibernatet01.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.bonnie.hibernatet01.service.BaseService;

/**
 * @author 王云纳
 * TODO
 * 2017年12月11日上午10:39:26
 */
public class BaseServiceImpl implements BaseService {
    private BaseDao baseDao = new BaseDaoImpl();
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

}
