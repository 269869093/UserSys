package com.lingnanedu.usermanagesys.usermgr.business.dao;

import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lingnanedu.usermanagesys.common.exception.DaoException;
import com.lingnanedu.usermanagesys.common.util.DBUtils;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 操作接口实现类
 * @author Administrator
 *
 */
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
				("select * from T_USER where id = ? and password = ?");
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
			user.setBirthday(rs.getDate("birthday"));
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
	
	/**
	 * 按照id查找指定用户信息
	 */
	public UserVD search(int id) {
		//初始化结果集
		ResultSet rs = null;
		//初始化批处理对象
		PreparedStatement prep = null;
		//初始化数据存储对象UserVD
		UserVD user = new UserVD();
		try {
			//获得批处理对象
			prep = conn.prepareStatement
					("select * from T_USER where id = ?");
			//传值
			prep.setInt(1, id);
			//批处理执行
			rs = prep.executeQuery();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
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
	
	/**
	 * 查找全体用户
	 */
	public Vector<UserVD> searchAll() {
		//创建列表存储结果集
		Vector<UserVD> lov = new Vector<UserVD>();
		//初始化结果集
		ResultSet rs = null;
		//初始化批处理对象
		PreparedStatement prep = null;	
		try {
			//获得批处理对象
			prep = conn.prepareStatement
					("select * from T_USER");
			//批处理执行
			rs = prep.executeQuery();
			while(rs.next()){
				//初始化数据存储对象UserVD
				UserVD user = new UserVD();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setStatus(rs.getString("status"));
				lov.add(user);
			}
		} catch (Exception e) {
			//抛出自定义异常
			throw new DaoException();
		}finally{
			//关闭对象
			DBUtils.closeStatment(rs, null, prep);
		}
		return lov;
	}
	
	/**
	 * 用户注册
	 */
	public boolean add(UserVD uv) {
		//声明布尔型标记变量
		boolean flag = false;
		//批处理对象
		PreparedStatement prep = null;
		//sql语句
		try {
			prep = conn.prepareStatement
					("insert into T_USER values(?,?,?,?,?,?,?,?)");
			//赋值
			prep.setInt(1, uv.getId());
			prep.setString(2, uv.getPassword());
			prep.setString(3, uv.getSex());
			prep.setString(4, uv.getName());
			prep.setString(5, uv.getEmail());
			prep.setString(6, uv.getPhone());
			prep.setDate(7,new java.sql.Date(uv.getBirthday().getTime()));
			prep.setString(8, uv.getStatus());
			//执行
			prep.executeUpdate();
			flag = true;
		} catch (Exception e) {
			System.out.println("插入失败");
		}
		return flag;		
	}
	
	/**
	 * 用户更新
	 * @param uv
	 * @return
	 */
	public boolean update(int id,UserVD uv) {
		//声明布尔型标记变量
		boolean flag = false;
		//批处理对象
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement
					("update T_USER set password = ?,sex = ?,name = ?,email = ?,phone = ?,birthday = ?,status = ? where id = ?");
			prep.setString(1, uv.getPassword());
			prep.setString(2, uv.getSex());
			prep.setString(3, uv.getName());
			prep.setString(4, uv.getEmail());
			prep.setString(5, uv.getPhone());
			prep.setDate(6,new java.sql.Date(uv.getBirthday().getTime()));
			prep.setString(7, uv.getStatus());
			prep.setInt(8,id);
			//执行
			prep.executeUpdate();
			flag = true;
		} catch (Exception e) {
			System.out.println("更新失败");
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/**
	 * 用户信息删除
	 */
	public boolean delete(int id) {
		//声明布尔型标记变量
		boolean flag = false;
		//批处理对象
		PreparedStatement prep = null;
		try {
			prep = conn.prepareStatement
					("delete from T_USER where id = ?");
			prep.setInt(1, id);
			//执行
			prep.executeUpdate();
			flag = true;
		} catch (Exception e) {
			System.out.println("更新失败");
		}
		return flag;
	}
}
