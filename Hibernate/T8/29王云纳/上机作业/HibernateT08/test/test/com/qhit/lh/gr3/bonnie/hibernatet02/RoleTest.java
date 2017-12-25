package test.com.qhit.lh.gr3.bonnie.hibernatet02;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.bonnie.hibernatet05.Service.BaseService;
import com.qhit.lh.gr3.bonnie.hibernatet05.Service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.Role;
import com.qhit.lh.gr3.bonnie.hibernatet05.bean.User;

/**
 * @author 王云纳
 * TODO
 * 2017年12月20日上午10:40:15
 */
public class RoleTest {
	
  private BaseService baseService = new BaseServiceImpl();
	@Test
	public void add() {
	  //创建一个角色	
		Role role = new Role();
		role.setRoleName("部长");
		role.setMemo("思想政治");
		//获取账户
		User user = (User) baseService.getObjectById(User.class, 1);
		//建立角色和账户的关系
		role.getUsers().add(user);
		baseService.add(role);
	}

	@Test
	public void delete() {
		Role role = (Role) baseService.getObjectById(Role.class,2);
		
		baseService.delete(role);
		}
	@Test
	public void update() {
		Role role = (Role) baseService.getObjectById(Role.class, 2);
        role.setMemo("政");
        
        //获取账户
         User user1 = (User) baseService.getObjectById(User.class, 1);
         User user2 = (User) baseService.getObjectById(User.class, 3);
         User user3 = (User) baseService.getObjectById(User.class, 7);
         
         role.getUsers().add(user1);
         role.getUsers().add(user2);
         role.getUsers().add(user3);
         baseService.update(role);
	}
	@Test
	public void query() {
		Role role = (Role) baseService.getObjectById(Role.class, 11);
		for(User user : role.getUsers()){
			System.out.println(role.getRoleName()+":"+user.getUserName());
		}
	}
}
