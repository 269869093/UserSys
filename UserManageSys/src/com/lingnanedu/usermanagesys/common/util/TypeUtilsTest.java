package com.lingnanedu.usermanagesys.common.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TypeUtilsTest {

	@Test
	public void testStringToDate() {
		Date date = new Date();
		date = TypeUtils.stringToDate("1997-08-10");
		System.out.println(date);
	}

	@Test
	public void testDateToString() {
		String str = new String();
		Date date = new Date();
		str = TypeUtils.dateToString(date);
		System.out.println(str);
	}

}
