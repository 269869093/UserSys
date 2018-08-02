package com.lingnanedu.usermanagesys.usermgr.view;

import java.util.Vector;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.lingnanedu.usermanagesys.common.util.CheckUtils;
import com.lingnanedu.usermanagesys.common.util.TypeUtils;
import com.lingnanedu.usermanagesys.usermgr.controller.UserController;
import com.lingnanedu.usermanagesys.usermgr.domain.UserVD;

/**
 * 管理员操作页面
 * @author Administrator
 *
 */
public class AdminFrame extends IndexFrame{
	
	public UserVD uv = new UserVD();
	/**
	 * 赋值
	 * @param uv
	 */
	public AdminFrame(UserVD uv){
		this.uv = uv;
	}
	
	/**
	 * 登陆成功后操作页面
	 */
	public void loginSuccShow() {
		
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
					//管理员欢迎界面
					System.out.println
					("欢迎您！"+uv.getName()+"您的账号为"+uv.getId()+"权限为"+uv.getStatus());
					System.out.println("请选择以下操作：");
					System.out.println("1,查询所有用户");
					System.out.println("2,查询指定用户");
					System.out.println("3,更改指定用户信息");
					System.out.println("4,删除指定用户记录");
					System.out.println("5,注销");
					int i = -1;
				try {
					i = Integer.parseInt(br.readLine());			
				} catch (Exception e) {
					// TODO: handle exception
				}			
				//根据不同操作选择调用不同页面
				switch (i) {
				case 1:	
					UserController uc = new UserController();
					String space = new String("  ");
					Vector<UserVD> lov = uc.searchAll();
					System.out.println
						("账号     性别    姓名    邮箱         电话        生日        权限");					
					for(UserVD vd : lov){
						System.out.println
						(vd.getId()+space+vd.getSex()+space+vd.getName()+space+vd.getEmail()+space+vd.getPhone()+space+vd.getBirthday()+space+vd.getStatus());		
					}			
					break;
				case 2:
					this.searchshow();
					break;
				case 3:
					this.updateshow();
					break;
				case 4:
					this.deleteshow();
					break;
				case 5:
					System.out.println(uv.getName()+"已注销");
					break;
				default:
					break;
				}
			}
	}	 
	
	/**
	 * 指定查询页面
	 */
	public void searchshow() {
		//声明缓冲处理对象，用于接收控制台输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入要查询的id");		
		try {		
			//请输入要查询的id值
			int id = Integer.parseInt(br.readLine());
			UserController uc = new UserController();
			//新建一个UserVD变存储对象用于接收查询返回值
			UserVD uv_search = new UserVD();
			String space = "    ";
			uv_search = uc.search(id);
			if (uv_search != null) {
				System.out.println("查询结果如下");
				System.out.println
				("账号     性别    姓名    邮箱         电话        生日        权限");
				System.out.println
				(uv_search.getId()+space+uv_search.getSex()+space+uv_search.getName()+space+uv_search.getEmail()+space+uv_search.getPhone()+space+uv_search.getBirthday()+space+uv_search.getStatus());
			} else {
				System.out.println("无此记录");
			}						
		} catch (Exception e) {
			System.out.println("查询失败-视图层");
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
				//请输入要更新的id值
				System.out.println("请输入要更新的id");
				int id = Integer.parseInt(br.readLine());
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
	
	/**
	 * 删除页面
	 */
	public void deleteshow() {
				//声明缓冲处理对象，用于接收控制台输入的数据
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(uv.getName()+"----删除界面----");
				System.out.println("~~~~~~~~~~~~~~~~");
				//更新成功与否标志
				boolean flag = false;
				while (true) {
					try {
						//创建控制器
						UserController uc = new UserController();
						//请输入要删除的id值
						System.out.println("请输入要删除的id");
						int id = Integer.parseInt(br.readLine());
						flag = uc.delete(id);
						if (flag) {
							System.out.println("删除完成！");
							break;
						} else {
							System.out.println("删除中途出现错误，删除失败");
							break;
						}
					} catch (Exception e) {
						System.out.println("删除失败-视图层");
					}			
				}
	}
}
