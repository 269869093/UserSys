package com.lingnanedu.usermanagesys.usermgr.view;

/**
 * 视图层基类接口
 * @author Administrator
 *
 */
public interface BaseFrame {
	
	/**
	 * 主页面
	 */
	public void show();
	/**
	 * 登录页面
	 */
	public void loginshow();
	/**
	 * 查询页面
	 */
	public void searchshow();
	/**
	 * 注册页面
	 */
	public void addshow();
	/**
	 * 更新页面
	 */
	public void updateshow();
	
	/**
	 * 删除页面
	 */
	public void deleteshow();
}
