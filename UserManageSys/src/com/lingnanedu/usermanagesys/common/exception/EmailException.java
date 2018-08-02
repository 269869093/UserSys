package com.lingnanedu.usermanagesys.common.exception;

/**
 * 自定义邮箱异常
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class EmailException extends ServiceException {
	
	/**
	 * 原始构造方法
	 */
	public EmailException() {
	}
	
	/**
	 * 带输出提示信息的构造方法
	 * @param arg0
	 */
	public EmailException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 带输出警告信息的构造方法
	 * @param arg0
	 */
	public  EmailException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 带输出提示与警告信息的构造方法
	 * @param arg0
	 * @param arg1
	 */
	public  EmailException(String arg0,Throwable arg1) {
		super(arg0, arg1);
	}
}
