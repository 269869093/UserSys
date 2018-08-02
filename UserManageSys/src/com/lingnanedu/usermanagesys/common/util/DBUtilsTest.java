package com.lingnanedu.usermanagesys.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
/**
 * 测试类
 * @author Administrator
 *
 */
public class DBUtilsTest {

	@Test
	public void testGetConnetion() {
		Connection conn = DBUtils.getConnetion();
		System.out.println(conn+"数据库连接成功");
	}

	@Test
	public void testOpenTransaction() {
		Connection conn = DBUtils.getConnetion();
		DBUtils.openTransaction(conn);
		System.out.println("事务已开启");
	}

	@Test
	public void testCommit() {
		Connection conn = DBUtils.getConnetion();
		DBUtils.commit(conn);
		System.out.println("事务已提交");
	}

	@Test
	public void testRowback() {
		Connection conn = DBUtils.getConnetion();
		DBUtils.rowback(conn);
		System.out.println("事务已回滚");
	}

	@Test
	public void testCloseStatment() {
		ResultSet rs = null;
		Statement stmt = null;
		PreparedStatement prep = null;
		DBUtils.closeStatment(rs, stmt,prep);
		System.out.println();
	}

	@Test
	public void testCloseConection() {
		Connection conn = DBUtils.getConnetion();
		DBUtils.closeConection(conn);
		System.out.println("连接已关闭");
	}

}
