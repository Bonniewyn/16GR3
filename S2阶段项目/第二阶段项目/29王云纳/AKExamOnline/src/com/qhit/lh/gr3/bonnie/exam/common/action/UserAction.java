package com.qhit.lh.gr3.bonnie.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.bonnie.exam.common.bean.User;
import com.qhit.lh.gr3.bonnie.exam.common.service.UserService;
import com.qhit.lh.gr3.bonnie.exam.common.service.UserServiceImpl;
/**
 * @author ������
 *2018��1��4������5:01:45
 * TODO
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	/**
	 * @return
	 * ��¼
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//��¼�ɹ�
			System.out.println(user.toString());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("��¼ʧ�ܣ��û����������!");
			return "loginFail";
		}
	}
	
	/**
	 * @return
	 * �˳�
	 */
	public String logout(){
		//��ȡsession���󣬲�����
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}
