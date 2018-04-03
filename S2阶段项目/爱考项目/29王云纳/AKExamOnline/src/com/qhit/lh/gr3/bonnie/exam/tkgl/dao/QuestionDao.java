/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.bonnie.exam.common.bean.PageBean;
import com.qhit.lh.gr3.bonnie.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.bonnie.exam.tkgl.bean.WrittenQuestion;

/**
 * @author ������
 *2018��1��8������11:41:11
 * TODO
 */
public interface QuestionDao {
	
	/**
	 * @return
	 * ��ȡ���⼯��
	 */
     public List<WrittenQuestion> getQuestionsByType(int csId,String qtrpe,String degree);
	
	/**
	 * @return
	 * ��ȡ��Ŀ��
	 */
	public int getQuestionsMax(int csId,String qtype,String degree);
	/**
	 * ������
	 * @param mjId
	 * @param stage
	 * @return
	 * ����б�
	 */
	public List<Course> getCourseInfo(Map parameter);
	
	/**
	 * @param pageBean
	 * @return
	 * �������б��ҳ����
	 */
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex);
	
	/**
	 * @param writtenQuestion
	 * ��ӱ�����
	 */
	public void addWrittenQuestion(WrittenQuestion writtenQuestion);
	
	/**
	 * @param writtenQuestion
	 * @return
	 * ����id��ѯ����
	 */
	public WrittenQuestion getWrittenQuestionById(WrittenQuestion writtenQuestion);
	
	/**
	 * @param writtenQuestion
	 * ��������
	 */
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion);
	
	/**
	 * @param listWQuestions
	 * �������������
	 */
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions);
}


