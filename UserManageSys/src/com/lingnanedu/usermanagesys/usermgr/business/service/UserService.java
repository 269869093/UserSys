package com.lingnanedu.usermanagesys.usermgr.business.service;

import oracle.jdbc.util.Login;

import com.lingnanedu.usermanagesys.common.dao.BaseDao;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

public interface UserService {
	
	/**
	 * 登陆接口，抽象类
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD login(int id,String password);
}
