package com.lingnanedu.usermanagesys.common.dao;

import java.sql.Connection;

import com.lingnanedu.usermanagesys.common.exception.ServiceException;
import com.lingnanedu.usermanagesys.usermgr.business.dao.UserDaoImpl;

public class DaoFactory {
	public static BaseDao getDao(Connection conn,String type) {
		if ("user".equals(type)) {
			return new UserDaoImpl(conn);
		} /*else if ("order".equals(type)) {
			return new OrderDaoImpl(conn);
		} */else {
			throw new ServiceException("dao方法出错");
		}
	}
}
