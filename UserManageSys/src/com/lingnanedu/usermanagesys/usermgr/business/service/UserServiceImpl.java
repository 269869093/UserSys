package com.lingnanedu.usermanagesys.usermgr.business.service;

import java.util.Vector;
import java.sql.Connection;

import com.lingnanedu.usermanagesys.common.constant.EnumType;
import com.lingnanedu.usermanagesys.common.dao.DaoFactory;
import com.lingnanedu.usermanagesys.common.exception.DaoException;
import com.lingnanedu.usermanagesys.common.exception.ServiceException;
import com.lingnanedu.usermanagesys.common.util.DBUtils;
import com.lingnanedu.usermanagesys.usermgr.business.dao.UserDao;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 业务层接口实现类
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
	
	/**
	 * 登陆检测——返回一个UserVD存储对象
	 */
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
			return user;
		}catch(DaoException e) {
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException();
		}finally {
			DBUtils.closeConection(conn);
		}
	}
	
	/**
	 * 按照id查询指定用户
	 * @param id
	 * @return
	 */
	public UserVD search(int id) {
		//初始化连接
		Connection conn = null;
		UserVD user = null;
		try {
			//获取数据库连接
			conn = DBUtils.getConnetion();
			//调用dao工厂生产一个userdao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用查找逻辑，查找某一条记录
			user = userMgrDao.search(id);
			return user;
		}catch(DaoException e) {
			throw e;
		}catch (Exception e) {
			throw new ServiceException();
		}finally {
			DBUtils.closeConection(conn);
		}	
	}
	
	/**
	 * 查询全部用户
	 * @return
	 */
	public Vector<UserVD> searchAll() {
		Vector<UserVD> lov = null;
		//初始化连接
		Connection conn = null;
		try {
			//获取数据库连接
			conn = DBUtils.getConnetion();
			//调用dao工厂生产一个userdao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			//调用查找逻辑，查找某一条记录
			lov = userMgrDao.searchAll();
			return lov;
		}catch(DaoException e) {
			throw e;
		}catch (Exception e) {
			throw new ServiceException();
		}finally {
			DBUtils.closeConection(conn);
		}	
	}
	
	/**
	 * 用户注册
	 */
	public boolean add(UserVD uv) {
		//初始化
		Connection conn = null;
		boolean flag = false;
		try {
			//获取数据库连接
			conn = DBUtils.getConnetion();
			//调用dao工厂生产一个userdao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			DBUtils.openTransaction(conn);
			userMgrDao.add(uv);
			DBUtils.commit(conn);
			flag = true;
		} catch (Exception e) {
			DBUtils.rowback(conn);
			System.out.println("注册业务失败");
		}finally{
			DBUtils.closeConection(conn);
		}
		return flag;
	}
	
	/**
	 * 更新用户信息
	 */
	public boolean update(int id,UserVD uv) {
		//初始化
		Connection conn = null;
		boolean flag = false;		
		try {
			conn = DBUtils.getConnetion();
			//调用dao工厂生产一个userdao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			DBUtils.openTransaction(conn);
			userMgrDao.update(id, uv);
			DBUtils.commit(conn);
			flag = true;
		} catch (Exception e) {
			DBUtils.rowback(conn);
			System.out.println("更新业务失败");
		}finally{
			DBUtils.closeConection(conn);
		}
		return flag;
	}
	
	/**
	 * 删除用户信息
	 */
	public boolean delete(int id) {
		//初始化
		Connection conn = null;
		boolean flag = false;		
		try {
			conn = DBUtils.getConnetion();
			//调用dao工厂生产一个userdao
			UserDao userMgrDao = (UserDao)DaoFactory.getDao(conn, EnumType.USER_DAO);
			DBUtils.openTransaction(conn);
			userMgrDao.delete(id);
			DBUtils.commit(conn);
			flag = true;
		} catch (Exception e) {
			DBUtils.rowback(conn);
			System.out.println("更新业务失败");
		}finally{
			DBUtils.closeConection(conn);
		}
		return flag;
	}
}
