/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.bonnie.exam.common.bean.PageBean;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.PaperClass;

/**
 * @author ������
 *2018��1��9������9:55:34
 * TODO
 */
public interface PaperService {
	
	/**
	 * @param paperClasses
	 */
	public void startExam(List<PaperClass> paperClasses,Paper paper);
	
	/**
	 * @param paper
	 * ��������
	 */
	public void endExam(Paper paper);
	
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
