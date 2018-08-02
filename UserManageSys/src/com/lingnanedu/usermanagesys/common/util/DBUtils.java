package com.lingnanedu.usermanagesys.common.util;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.lingnanedu.usermanagesys.common.exception.UtilException;

/**
 * DB操作工具包
 * @author Administrator
 *
 */
public class DBUtils {
	
	/**
	 * 获取数据库连接类
	 * @return
	 */
	public static Connection getConnetion() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID 
		String user="scott";
		String password="123321";
		Connection conn =null;
		try {
			//注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance(); 
			//获取连接
			conn = DriverManager.getConnection(url, user, password);			
		} catch (Exception e) {
			//抛出异常
			throw new UtilException("获取数据库连接失败", e);
		}	
		return conn;			
	}
	
	/**
	 * 开启事务类
	 * @param conn
	 */
	public static void openTransaction(Connection conn) {
		try {
			//事务自动提交方式设定为假
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new UtilException("打开事务失败", e);
		}
	}
	
	/**
	 * 提交事务类
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			//提交事务
			conn.commit();
			//事务自动提交方式设定为真
			conn.setAutoCommit(true);
		} catch (Exception e) {
			//抛出异常
			throw new UtilException("事务提交失败", e);
		}
	}
	
	/**
	 * 事务回滚类
	 * @param conn
	 */
	public static void rowback(Connection conn) {
		try {
			//事务回滚
			conn.rollback();
			//事务自动提交方式设定为真
			conn.setAutoCommit(true);
		} catch (Exception e) {
			//抛出异常
			throw new UtilException("事务回滚失败", e);
		}
	}
	
	/**
	 * 关闭对象
	 * @param rs
	 * @param stmt
	 */
	public static void closeStatment(ResultSet rs,Statement stmt,PreparedStatement prep) {
		try {
			if(rs != null){
				//关闭结果集对象
				rs.close();
			}
			if(stmt != null){
				//关闭statement对象
				stmt.close();
			}
			if(prep != null){
				prep.close();
			}
		} catch (Exception e) {
			//抛出异常
			throw new UtilException("释放资源失败", e);
		}
	}
	
	/**
	 * 关闭连接类
	 * @param conn
	 */
	public static void closeConection(Connection conn) {
		try {
			if(conn!=null){
				//关闭连接
				conn.close();
			}
		} catch (Exception e) {
			throw new UtilException("关闭数据库连接失败", e);
		}
	}
}
