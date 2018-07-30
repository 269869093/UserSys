package com.lingnanedu.usermanagesys.common.exception;

public class DaoException extends RuntimeException {
	
	/**
	 * 原始构造方法
	 */
	public DaoException() {
	}
	
	/**
	 * 输出提示信息的构造方法
	 * @param arg0
	 */
	public DaoException(String arg0) {
		super(arg0);
	}
	
	/**
	 * 输出异常信息的构造方法
	 * @param arg0
	 */
	public DaoException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 输出提示信息和异常信息的构造方法
	 * @param arg0
	 * @param arg1
	 */
	public DaoException(String arg0,Throwable arg1) {
		super(arg0, arg1);
	}
}
