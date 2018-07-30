package com.lingnanedu.usermanagesys.common.dao;

import java.sql.Connection;

import com.lingnanedu.usermanagesys.common.exception.ServiceException;

public class DaoFactory {
	public BaseDao getDao(Connection conn,String type) {
		if ("user".equals(type)) {
			return new UserDaoImpl(conn);
		} else if ("order".equals(type)) {
			//return new OrderDaoImpl(conn);
		} else {
			throw new ServiceException("dao方法出错");
		}
	}
}
