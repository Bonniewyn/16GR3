package com.qhit.lh.gr3.bonnie.hibernatet02.Service;

import java.util.List;

/**
 * @author 王云纳
 * TODO
 * 2017年12月13日上午10:14:27
 */
public interface BaseService {

	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	
	/**
	 * 查
	 */
	public List<Object> getAll(String fromObject);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据id查询
	 */
	public Object getObjectById(Object obj, int id);
}

