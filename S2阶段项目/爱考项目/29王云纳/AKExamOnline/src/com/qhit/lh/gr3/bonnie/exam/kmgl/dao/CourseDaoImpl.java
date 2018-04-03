/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.kmgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.qhit.lh.gr3.bonnie.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.bonnie.exam.kmgl.bean.Course;

/**
 * @author ������
 *2018��1��9������9:36:11
 * TODO
 */
public class CourseDaoImpl extends BaseDao implements CourseDao {

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.bella.exam.kmgl.dao.CourseDao#getCoursesList(java.util.Map)
	 */
	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		StringBuffer hql = new StringBuffer("select course from Course course where 1 = 1 ");
		//ƴ��HQL
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//��ȡ��ѯ��
		Query query = getSession().createQuery(hql.toString());
		//���ò���
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//ִ�в�ѯ
		return query.list();
	}
}
