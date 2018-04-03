/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.bonnie.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.bonnie.exam.common.bean.PageBean;
import com.qhit.lh.gr3.bonnie.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.bonnie.exam.sjgl.bean.PaperClass;

/**
 * @author ������
 *2018��1��9������10:00:49
 * TODO
 */
public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean, Map<String, Object> parameter, int pageIndex) {
		StringBuffer hql = new StringBuffer();
		hql.append("select paper from Paper paper where 1 = 1");
		//ƴ��HQL
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//��ȡ��ѯ��
		Query query = getSession().createQuery(hql.toString());
		//���ò���
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setInteger("csId", (Integer)parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String) parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState", (String) parameter.get("pState"));
		}
		//�ܼ�¼��
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		//��ǰҳ����
		List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//����pagebean�����ݼ���
		pageBean.setItems(items);
		//ִ�в�ѯ
		return pageBean;
	}
	@Override
	public void createPaperRandom(Paper paper) {
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}

	@Override
	public void updateExam(Paper paper,String state) {
		Transaction ts = getSession().beginTransaction();
//		paper = (Paper) getSession().get(Paper.class, paper.getPid());
//		paper.setPstate("���Խ���");
//		getSession().update(paper);
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ?";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//ִ��HQL����ӡ��޸ġ�ɾ�����õ���executeUpdate����
		queryUpdate.executeUpdate();
		ts.commit();
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		// TODO Auto-generated method stub
		Transaction ts = getSession().beginTransaction();
		System.out.println("���ݴ�С:"+paperClasses.size());
		for (PaperClass paperClass : paperClasses) {
			//����n-1��ϵ
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//��������
			getSession().save(paperClass);
		}
		ts.commit();
	}

}
