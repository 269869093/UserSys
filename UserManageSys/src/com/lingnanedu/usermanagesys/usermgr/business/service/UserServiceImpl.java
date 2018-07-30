package com.lingnanedu.usermanagesys.usermgr.business.service;

import java.sql.Connection;

import com.lingnanedu.usermanagesys.common.constant.EnumType;
import com.lingnanedu.usermanagesys.common.dao.DaoFactory;
import com.lingnanedu.usermanagesys.common.exception.DaoException;
import com.lingnanedu.usermanagesys.common.exception.ServiceException;
import com.lingnanedu.usermanagesys.common.util.DBUtils;
import com.lingnanedu.usermanagesys.usermgr.business.dao.UserDao;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * service接口实现类
 * @author Administrator
 *
 */
public class UserServiceImpl implements UserService{
	
	/**
	 * service类实例，在类的内部静态初始化唯一的实例
	 */
	private static UserService userService = new UserServiceImpl();
	/**
	 * 私有化构造方法
	 */
	private UserServiceImpl() {		
	}
	
	/**
	 * 向外部提供使用这个实例的public方法
	 * @return
	 */
	public static UserService getInstance() {
		return userService;
	}
	
	public UserVD login(int id,String password) {
		//声明连接对象以及存储对象
		Connection conn = null;
		UserVD user = null;
		try {
			//获取数据库连接
			conn = DBUtils.getConnetion();
			//调用工厂类的getDao方法，取得指定类型dao接口的实现类，并赋值给dao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn,EnumType.USER_DAO);
			user = userMgrDao.login(id, password);
		}catch(DaoException e) {
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException();
		}finally {
			DBUtils.closeConection(conn);
		}
	}
}
