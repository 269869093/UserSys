package com.lingnanedu.usermanagesys.usermgr.business.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lingnanedu.usermanagesys.common.exception.DaoException;
import com.lingnanedu.usermanagesys.common.util.DBUtils;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

public class UserDaoImpl implements UserDao{
	
	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * 构造方法
	 * @param conn
	 */
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 登录模块
	 * @param id
	 * @param password
	 * @return
	 */
	public UserVD login(int id,String password) {
		//初始化结果集
		ResultSet rs = null;
		//初始化批处理对象
		PreparedStatement prep = null;
		//初始化数据存储对象UserVD
		UserVD user = new UserVD();
		try {
		//获得批处理
		prep = conn.prepareStatement
				("select * from T_USER where id = ? and password = ? and status = '0'");
		//传值
		prep.setInt(1,id);
		prep.setString(2,password);
		//批处理执行
		rs = prep.executeQuery();
		//判断是否有这样一条记录，如果有，取出记录赋值给存储对象返回
		if (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setStatus(rs.getString("status"));
		}
		} catch (Exception e) {
			//抛出自定义异常
			throw new DaoException();
		}finally{
			//关闭对象
			DBUtils.closeStatment(rs, null, prep);
		}
		return user;
	}
}
