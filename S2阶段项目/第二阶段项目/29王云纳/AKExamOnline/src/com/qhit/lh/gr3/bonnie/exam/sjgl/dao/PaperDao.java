/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.bonnie.exam.common.bean.PageBean;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.PaperClass;

/**
 * @author 王云纳
 *2018年1月9日下午9:53:20
 * TODO
 */
public interface PaperDao {
	
	/**
	 * @param paperClasses
	 */
	public void startExam(List<PaperClass> paperClasses);
	
	/**
	 * @param paper
	 * 结束考试
	 */
	public void updateExam(Paper paper,String state);
	
	/**
	 * @param paper
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);
	/**
	 * @param parameter
	 * @return
	 * 查询试卷列表
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
