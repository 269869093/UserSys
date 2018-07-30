package com.lingnanedu.usermanagesys.usermgr.business.dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.lingnanedu.usermanagesys.common.util.DBUtils;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

public class UserDaoImplTest {

	@Test
	public void testUserDaoImpl() {		
	}

	@Test
	public void testLogin() {
		Connection conn = DBUtils.getConnetion();
		UserDaoImpl udi = new UserDaoImpl(conn);
		UserVD uv = new UserVD();
		uv = udi.login(202,"b22");
		System.out.println(uv.getId()+uv.getPassword()+uv.getName());
	}

}
