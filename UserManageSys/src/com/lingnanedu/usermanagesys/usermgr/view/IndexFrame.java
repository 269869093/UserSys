package com.lingnanedu.usermanagesys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnanedu.usermanagesys.common.util.CheckUtils;
import com.lingnanedu.usermanagesys.common.util.TypeUtils;
import com.lingnanedu.usermanagesys.usermgr.controller.UserController;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 首页
 * @author Administrator
 *
 */
public class IndexFrame implements BaseFrame {
	/**
	 * 首页
	 */
	public void show(){
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			//登录界面
			System.out.println("----用户管理系统----");
			System.out.println("~~~~~~~~~~~~~~~~");
			System.out.println("1,用户登录");
			System.out.println("2,用户注册");
			System.out.println("3,退出程序");
			int i = -1;
			//循环读取用户键盘输入
			while(true){
				try {
					//读取用户输入数字并转换为Int
					i = Integer.parseInt(br.readLine());
					//跳出
				} catch (Exception e) {
					System.out.println("输入出错");
					System.out.println("请重新输入");
				}
				switch (i) {
				case 1:
					//跳转到登录界面
					this.loginshow();
					break;
				case 2:
					this.addshow();
					break;
				case 3:
					System.out.println("感谢使用，再见");
					//退出
					System.exit(0);
					default:
						System.out.println("输入不合法，请重试");
				}
			}
		}
	}
	
	/**
	 * 登陆界面
	 */
	public void loginshow() {
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//登录界面
		System.out.println("----登陆界面----");
		System.out.println("~~~~~~~~~~~~~~~~");
		int id = -1;
		String password = null;
		//循环读取用户键盘输入
		while(true){
			try {
				System.out.println("请输入您的账号：");
				//读取用户输入数字并转换为Int
				id = Integer.parseInt(br.readLine());
				System.out.println("请输入您的密码：");
				password = br.readLine();
				//调用控制方法，进行登录操作
				UserController uc = new UserController();
				UserVD user = uc.doLogin(id, password);
				if (user != null) {
					System.out.println("登陆成功！");
					System.out.println("~~~~~~~~~~~");
					//System.out.println(user.getStatus());
					if (user.getStatus().equals("1")) {
						//调用管理员界面
						AdminFrame m = new AdminFrame(user);
						m.loginSuccShow();
					} else {
						NormalFrame n = new NormalFrame(user);
						n.loginSuccShow();
					}				
				}
				//跳出
				break;
			} catch (Exception e) {
				System.out.println("输入出错");
				System.out.println("请重新输入,id为数字，密码为字符串");
				e.printStackTrace();
				
			}
		}
	}
	
	/**
	 * 注册界面
	 */
	public void addshow() {
				//声明缓冲处理对象，用于接收控制台输入的数据
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//获得用户输入的值
				UserVD uv = new UserVD();
				//登录界面
				System.out.println("----注册界面----");
				System.out.println("~~~~~~~~~~~~~~~~");
				while (true) {
					try {
						//输入
						System.out.println("请输入账号：");
						//读取用户输入数字并转换为Int
						uv.setId(Integer.parseInt(br.readLine()));
						System.out.println("请输入密码：");
						uv.setPassword(br.readLine());
						System.out.println("请输入性别");
						uv.setSex(br.readLine());
						System.out.println("请输入姓名");
						uv.setName(br.readLine());
						System.out.println("请输入电子邮箱");
						uv.setEmail(br.readLine());
						if(CheckUtils.EmailTypeCheck(uv.getEmail())==false){
							System.out.println("邮箱格式错误！");
							continue;
						}
						System.out.println("请输入电话");
						uv.setPhone(br.readLine());
						System.out.println("请输入生日，格式为yyyy-mm-dd");
						uv.setBirthday(TypeUtils.stringToDate(br.readLine()));
						System.out.println("请输入权限，0为普通用户，1为管理员");					
						uv.setStatus(br.readLine());
						System.out.println(uv.getStatus());
						//调用控制层
						UserController uc = new UserController();
						if(uc.add(uv)){
							System.out.println("注册成功！");							
						}
						break;
					} catch (Exception e) {
						System.out.println("注册失败-视图层");
					}			
				}
	}
	
	/**
	 * 查询页面
	 */
	public void searchshow(){
		
	};
	/**
	 * 更新页面
	 */
	public void updateshow(){
		
	};
	
	/**
	 * 删除页面
	 */
	public void deleteshow(){
		
	};
}
