package com.lingnanedu.usermanagesys.usermgr.business.dao;

import java.util.Vector;

import com.lingnanedu.usermanagesys.common.dao.BaseDao;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 用户操作接口
 * @author Administrator
 *
 */
public interface UserDao extends BaseDao{
	
	/**
	 * 用户登录
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD login(int id,String password);
	
	/**
	 * 用户查询
	 * @param id
	 * @return
	 */
	public UserVD search(int id);
	
	/**
	 * 查询所用户有
	 * @return
	 */
	public Vector<UserVD> searchAll();
	
	/**
	 * 用户注册
	 * @param uv
	 * @return
	 */
	public boolean add(UserVD uv);
	
	/**
	 * 用户修改
	 * @return
	 */
	public boolean update(int id,UserVD uv);
	
	/**
	 * 用户删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
}
