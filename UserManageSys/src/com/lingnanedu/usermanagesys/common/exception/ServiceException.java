package com.lingnanedu.usermanagesys.common.exception;

public class ServiceException extends RuntimeException {
	
	/**
	 * 原始构造方法
	 */
	public ServiceException() {
	}
	
	/**
	 * 输出提示信息的构造方法
	 * @param arg0
	 */
	public ServiceException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 输出异常信息的构造方法
	 * @param arg0
	 */
	public ServiceException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 输出提示信息与异常信息的构造方法
	 * @param arg0
	 * @param arg1
	 */
	public ServiceException(String arg0,Throwable arg1) {
		super(arg0, arg1);
	}
}
