package com.lingnanedu.usermanagesys.common.util;

import org.junit.Test;

/**
 * 测试类
 * @author Administrator
 *
 */
public class CheckUtilsTest {

	@Test
	public void testStringNullCheck() {
		String test = new String();
		String test1 = new String("null");
		boolean flag = CheckUtils.StringNullCheck(test);
		boolean flag1 = CheckUtils.StringNullCheck(test1);
		System.out.println(flag);
		System.out.println(flag1);
	}

	@Test
	public void testEmailTypeCheck() {
		String test = new String();
		String test1 = new String("null");
		String test2 = new String("helloworld@123.com");
		boolean flag = CheckUtils.StringNullCheck(test);
		boolean flag1 = CheckUtils.StringNullCheck(test1);
		boolean flag2 = CheckUtils.StringNullCheck(test2);
		System.out.println(flag);
		System.out.println(flag1);
		System.out.println(flag2);
	}

}
