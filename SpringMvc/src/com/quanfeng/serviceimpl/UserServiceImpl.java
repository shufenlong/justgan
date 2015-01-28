package com.quanfeng.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.quanfeng.basedao.BaseDAO;
import com.quanfeng.entity.User;
import com.quanfeng.service.UserService;

@Service("userService")  
public class UserServiceImpl implements UserService {  
     
   private BaseDAO<User> baseDAO;  
 
   @Override  
   public void saveUser(User user) {  
       baseDAO.save(user);  
   }  
 
   @Override  
   public void updateUser(User user) {  
       baseDAO.update(user);  
   }  
 
   @Override  
   public User findUserById(int id) {  
       return baseDAO.get(User.class, id);  
   }  
 
   @Override  
   public void deleteUser(User user) {  
       baseDAO.delete(user);  
   }  
 
   @Override  
   public List<User> findAllList() {  
       return baseDAO.find(" from User u");  
   }  
 
   @Override  
   public User findUserByNameAndPassword(String username, String password) {  
       return baseDAO.get(" from User u where u.userName = ? and u.password = ? ", new Object[] { username, password });  
   }

public BaseDAO<User> getBaseDAO() {
	return baseDAO;
}
@Resource(name="baseDAO")
public void setBaseDAO(BaseDAO<User> baseDAO) {
	this.baseDAO = baseDAO;
}

}
