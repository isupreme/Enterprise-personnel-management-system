package com.briup.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 员工信息类
 *
 */
@Component
public class Staff implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//员工id
	private int id;
	//员工姓名
	private String name;
	//员工性别
	private String sex;
	//学历
	private String degree;
	//部门
	private Department department;
	//职位
	private String position;
	//状态，分为在职和离职两种
	private String state;
	//用户名
	private String username;
	//密码
	private String password;

	private Integer posId;

	private Integer deptId;

    public Staff() {
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", degree='" + degree + '\'' +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", state='" + state + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", posId=" + posId +
                ", deptId=" + deptId +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Staff(int id, String name, String sex, String degree, Department department, String position, String state, String username, String password, Integer posId, Integer deptId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.degree = degree;
        this.department = department;
        this.position = position;
        this.state = state;
        this.username = username;
        this.password = password;
        this.posId = posId;
        this.deptId = deptId;
    }
}
