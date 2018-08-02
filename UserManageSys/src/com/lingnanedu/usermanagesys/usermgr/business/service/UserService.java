package com.lingnanedu.usermanagesys.usermgr.business.service;

import java.util.Vector;

import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 业务层接口
 * @author Administrator
 *
 */
public interface UserService {
	
	/**
	 * 登陆接口，抽象类
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD login(int id,String password);
	/**
	 * 查询所有用户
	 * @return
	 */
	public Vector<UserVD> searchAll();
	/**
	 * 查询指定用户信息
	 * @param id
	 * @return
	 */
	public UserVD search(int id);
	/**
	 * 用户注册
	 * @param uv
	 * @return
	 */
	public boolean add(UserVD uv);
	
	/**
	 * 用户修改信息
	 * @param id
	 * @param uv
	 * @return
	 */
	public boolean update(int id,UserVD uv);
	
	/**
	 * 删除用户信息
	 * @param id
	 * @param uv
	 * @return
	 */
	public boolean delete(int id);
}
