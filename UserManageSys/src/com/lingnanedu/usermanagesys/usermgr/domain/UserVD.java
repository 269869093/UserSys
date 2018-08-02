package com.lingnanedu.usermanagesys.usermgr.domain;

import java.util.Date;

/**
 * 存储对象
 * @author Administrator
 *
 */
public class UserVD {
	private int id;
	private String password;
	private String sex;
	private String name;
	private String email;
	private String phone;
	private Date birthday;
	private String status;
	/**
	 * 获得id
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 赋值id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 获取密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 赋值当前密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取性别
	 * @return
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 赋值当前性别
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取姓名
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 赋值当前姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获得邮箱
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 赋值当前邮箱
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取电话
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 赋值当前电话
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取生日
	 * @return
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * 赋值当前生日
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * 获取权限
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 赋值当前权限
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
