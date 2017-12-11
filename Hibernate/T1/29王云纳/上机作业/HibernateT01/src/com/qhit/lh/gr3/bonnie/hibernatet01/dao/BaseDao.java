package com.qhit.lh.gr3.bonnie.hibernatet01.dao;

import java.util.List;

/**
 * @author 王云纳
 * TODO
 * 2017年12月11日上午10:39:50
 */
public interface BaseDao {
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
 * @param obj
 * 查
 */
public List<Object> getAll(String fromObject);
;
}

