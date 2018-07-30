package com.lingnanedu.usermanagesys.common.util;

public class CheckUtils {
	
	/**
	 * 判断字符串是否为空，true为空，false为非空
	 * @param str
	 * @return
	 */
	public static boolean StringNullCheck(String str) {
			if (str == null || str.length() <= 0) {
				return true;
			} else {
				return false;
			}
		}
	
	/**
	 * 判断邮箱是否符合正则表达式标准
	 * @param str
	 * @return
	 */
	public static boolean EmailTypeCheck(String str) {
		String regex = "\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
		if(str.matches(regex))
		{
			return true;
		}
		else {
			return false;
		}		
	}
}
