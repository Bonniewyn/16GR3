/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.kmgl.service;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.bonnie.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.bonnie.exam.kmgl.dao.CourseDao;
import com.qhit.lh.gr3.bonnie.exam.kmgl.dao.CourseDaoImpl;

/**
 * @author ������
 *2018��1��9������9:42:12
 * TODO
 */
public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public List<Course> getCoursesList(Map<String, Object> parameter) {
		// TODO Auto-generated method stub
		return courseDao.getCoursesList(parameter);
	}

}
