package com.lingnanedu.usermanagesys.common.exception;

/**
 * 自定义工具异常
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class UtilException extends RuntimeException{
	/**
	 * 原始构造方法
	 */
	public UtilException() {
	}
	
	/**
	 * 输出提示信息的构造方法
	 * @param arg0
	 */
	public UtilException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 输出异常信息的构造方法
	 * @param arg0
	 */
	public UtilException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 输出提示信息和异常信息的构造方法
	 * @param arg0
	 * @param arg1
	 */
	public UtilException(String arg0,Throwable arg1) {
		super(arg0, arg1);
	}
}
