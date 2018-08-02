package com.lingnanedu.usermanagesys.usermgr.controller;

import java.util.Vector;

import com.lingnanedu.usermanagesys.usermgr.business.service.UserService;
import com.lingnanedu.usermanagesys.usermgr.business.service.UserServiceImpl;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 控制层接口
 * @author Administrator
 *
 */
public class UserController {
	//声明接口对象，用于业务处理
	UserService userMgrService = UserServiceImpl.getInstance();
	//初始化存储对象
	UserVD user = null;
	/**
	 * 调用登陆业务
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD doLogin(int id,String password) {	
		try {
			//调用登陆业务
			user = userMgrService.login(id, password);
		} catch (Exception e) {
			System.out.println("登陆发生错误"+e.getMessage());
		}
		return user;
	}
	/**
	 * 调用查询所有用户
	 * @return
	 */
	public Vector<UserVD> searchAll() {
		Vector<UserVD> lov = null;
		try {
			lov = userMgrService.searchAll();
		} catch (Exception e) {
			System.out.println("查询所有用户发生错误");
		}
		return lov;
	}
	/**
	 * 调用查询指定用户 
	 * @param id
	 * @return
	 */
	public UserVD search(int id) {
		try {
			user = userMgrService.search(id);
		} catch (Exception e) {
			System.out.println("查询指定用户发生错误");
		}
		return user;
	}
	
	/**
	 * 用户注册
	 * @param uv
	 * @return
	 */
	public boolean add(UserVD uv) {
		boolean flag = false;
		try {
			flag = userMgrService.add(uv);			
		} catch (Exception e) {
			System.out.println("注册失败-控制层");
		}
		return flag;
	}
	
	/**
	 * 用户更新
	 * @param id
	 * @param uv
	 * @return
	 */
	public boolean update(int id,UserVD uv) {
		boolean flag = false;
		try {
			flag = userMgrService.update(id, uv);
		} catch (Exception e) {
			System.out.println("更新失败-控制层");
		}
		return flag;
	}
	
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		boolean flag = false;
		try {
			flag = userMgrService.delete(id);
		} catch (Exception e) {
			System.out.println("删除失败-控制层");
		}
		return flag;
	}
}
