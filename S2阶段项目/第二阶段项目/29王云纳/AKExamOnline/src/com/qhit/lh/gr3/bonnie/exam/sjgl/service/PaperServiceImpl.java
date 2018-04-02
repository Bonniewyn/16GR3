/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.sjgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.bonnie.exam.common.bean.PageBean;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.PaperClass;
import com.qhit.lh.gr3.bonnie.exam.sjgl.dao.PaperDao;
import com.qhit.lh.gr3.bonnie.exam.sjgl.dao.PaperDaoImpl;

/**
 * @author 王云纳
 *2018年1月9日下午9:56:29
 * TODO
 */
public class PaperServiceImpl implements PaperService {
	private PaperDao paperDao = new PaperDaoImpl();

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		// TODO Auto-generated method stub
		return paperDao.getPaperList(pageBean, parameter, pageIndex);
	}
	@Override
	public void createPaperRandom(Paper paper) {
		paperDao.createPaperRandom(paper);
	}

	@Override
	public void endExam(Paper paper) {
		paperDao.updateExam(paper,"考试结束");
	}

	@Override
	public void startExam(List<PaperClass> paperClasses,Paper paper) {
		paperDao.startExam(paperClasses);
		paperDao.updateExam(paper, "考试中");
	}

}
