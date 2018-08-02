package com.lingnanedu.usermanagesys.common.util;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.lingnanedu.usermanagesys.common.exception.DateException;

/**
 * 字符串转换工具
 * @author Administrator
 *
 */
public class TypeUtils {
	
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date stringToDate(String str) {
		Date date = null;
		//设置格式日期
		SimpleDateFormat sdf =	new SimpleDateFormat("yyyy-MM-dd");
		try {
			//字符串转化成指定日期格式类型
			date = sdf.parse(str);
		} catch (Exception e) {
			//抛出异常
			throw new DateException("字符串转日期失败",e);
		}
		return date;
	}
	
	/**
	 * 日期转字符串
	 * @param dt
	 * @return
	 */
	public static String dateToString(Date dt) {
		String str = new String();
		SimpleDateFormat sdf = new SimpleDateFormat();
		try {
			str = sdf.format(dt);
		} catch (Exception e) {
			//抛出异常
			throw new DateException("日期转字符串失败",e);
		}
		return str;
	}
}
