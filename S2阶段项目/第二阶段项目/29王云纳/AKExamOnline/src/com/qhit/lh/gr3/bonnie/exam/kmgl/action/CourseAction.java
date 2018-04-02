/**
 * 
 */
package com.qhit.lh.gr3.bonnie.exam.kmgl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.bonnie.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.bonnie.exam.kmgl.service.CourseService;
import com.qhit.lh.gr3.bonnie.exam.kmgl.service.CourseServiceImpl;

/**
 * @author ������
 *2018��1��9������8:33:45
 * TODO
 */
public class CourseAction extends ActionSupport {
	private static final long serialVersionUID = 5352074026213567264L;
	private CourseService courseService = new CourseServiceImpl();
	private List<Course> listCourses = new ArrayList<>();
	private Course course;//�γ�

	public String getCourses2Json(){
		//���ò���
		Map<String, Object> parameter = new HashMap<>();
		if(course != null){
			parameter.put("major", course.getMajor());
			parameter.put("stage", course.getStage());
		}
		//��ѯ����б�����
		listCourses = courseService.getCoursesList(parameter);
		System.out.println("�첽����:"+listCourses.size());
		return "listCourseJson";
	}

	
	public List<Course> getListCourses() {
		return listCourses;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
