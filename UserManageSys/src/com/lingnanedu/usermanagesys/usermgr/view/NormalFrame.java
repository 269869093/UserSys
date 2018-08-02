package com.lingnanedu.usermanagesys.usermgr.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnanedu.usermanagesys.common.util.CheckUtils;
import com.lingnanedu.usermanagesys.common.util.TypeUtils;
import com.lingnanedu.usermanagesys.usermgr.controller.UserController;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 用户操作页面
 * @author Administrator
 *
 */
public class NormalFrame extends IndexFrame {
	public UserVD uv = new UserVD();
			/**
			 * 赋值
			 * @param uv
			 */
			public NormalFrame(UserVD uv){
				this.uv = uv;
			}
	/**
	 * 登陆成功后操作页面
	 */
	public void loginSuccShow() {		
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String space = new String("    ");
		//管理员欢迎界面
		System.out.println
		("欢迎您！"+uv.getName()+"您的账号为"+uv.getId()+"权限为"+uv.getStatus());
		System.out.println("请选择以下操作：");
		System.out.println("1,查询信息");
		System.out.println("2,修改信息");
		System.out.println("3,注销");
		//循环等待键盘输入
		while(true){
			try {
				int i = Integer.parseInt(br.readLine());
				//根据不同操作选择调用不同页面
				switch (i) {
				case 1:
					System.out.println
						("账号    性别    姓名    邮箱         电话        生日        权限");
						System.out.println
						(uv.getId()+space+uv.getSex()+space+uv.getName()+space+uv.getEmail()+space+uv.getPhone()+space+uv.getBirthday()+space+uv.getStatus());							
					break;
				case 2:
					this.updateshow();
					break;
				case 3:
					System.out.println("用户已注销");
					//退出
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("输入格式错误，请输入1-3的数字！");
			}
		}
	}
	
	
	/**
	 * 更新页面
	 */
	public void updateshow() {
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(uv.getName()+"----更新界面----");
		System.out.println("~~~~~~~~~~~~~~~~");
		//更新成功与否标志
		boolean flag = false;
		while (true){
				try {
				//新建一个UserVD变存储对象用于传入要更新的值
				UserVD uv_update = new UserVD();
				//创建控制器
				UserController uc = new UserController();
				//输入值给UserVD,id值固定
				int id = uv.getId();
				uv_update.setId(id);
				System.out.println("请输入要更新的password");
				uv_update.setPassword(br.readLine());
				System.out.println("请输入要更新的sex");
				uv_update.setSex(br.readLine());
				System.out.println("请输入要更新的name");
				uv_update.setName(br.readLine());
				System.out.println("请输入要更新的email");				
				uv_update.setEmail(br.readLine());
				if(CheckUtils.EmailTypeCheck(uv_update.getEmail())==false){
					System.out.println("邮箱格式错误！");
					continue;
				}
				System.out.println("请输入要更新的phone");
				uv_update.setPhone(br.readLine());
				System.out.println("请输入要更新的birthday(格式:yyyy-MM-dd)");
				uv_update.setBirthday(TypeUtils.stringToDate(br.readLine()));
				System.out.println("请输入要更新的status");
				uv_update.setStatus(br.readLine());
				flag = uc.update(id, uv_update);
				if (flag) {
					System.out.println("更新已完成!");
					break;
				} else {
					System.out.println("更新中途出现问题，更新失败");
					break;
				}
			} catch (Exception e) {
				System.out.println("更新失败-视图层");
			}
		}		
	}
}
