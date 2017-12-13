package com.qhit.lh.gr3.bonnie.hibernatet02.bean;

/**
 * @author 王云纳
 * TODO
 * 2017年12月13日上午9:42:11
 */
public class User {
  private int userId;
  private String userName;
  private String password;
  //一对一关系映射
  private Emp emp;
public User(int userId, String userName, String password, Emp emp) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
	this.emp = emp;
}
public User(int userId, String userName, String password) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.password = password;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Emp getEmp() {
	return emp;
}
public void setEmp(Emp emp) {
	this.emp = emp;
}
  
}
