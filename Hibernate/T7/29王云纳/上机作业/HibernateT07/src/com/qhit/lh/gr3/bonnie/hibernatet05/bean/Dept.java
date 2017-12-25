package com.qhit.lh.gr3.bonnie.hibernatet05.bean;

import java.util.HashSet;
import java.util.Set;

import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Emp;

/**
 * @author 王云纳
 * TODO
 * 2017年12月13日上午11:19:54
 */
public class Dept {
    private int deptId;
    private String deptName;
    private String address;
    
  //一对多
    private Set<Emp> emps = new HashSet<Emp>();
	public Dept(int deptId, String deptName, String address) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.address = address;
	}
	
	public Dept(String deptName, String address) {
		super();
		this.deptName = deptName;
		this.address = address;
	}
	
	public Dept(String deptName) {
		super();
		this.deptName = deptName;
	}

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
    
}
