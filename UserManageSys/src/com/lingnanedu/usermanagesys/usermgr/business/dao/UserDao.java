package com.lingnanedu.usermanagesys.usermgr.business.dao;

import com.lingnanedu.usermanagesys.common.dao.BaseDao;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

public interface UserDao extends BaseDao{
	
	/**
	 * 用户登录
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD login(int id,String password);
}
