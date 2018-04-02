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
 * @author ������
 *2018��1��9������9:53:20
 * TODO
 */
public interface PaperDao {
	
	/**
	 * @param paperClasses
	 */
	public void startExam(List<PaperClass> paperClasses);
	
	/**
	 * @param paper
	 * ��������
	 */
	public void updateExam(Paper paper,String state);
	
	/**
	 * @param paper
	 * ������
	 */
	public void createPaperRandom(Paper paper);
	/**
	 * @param parameter
	 * @return
	 * ��ѯ�Ծ��б�
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex);
}
