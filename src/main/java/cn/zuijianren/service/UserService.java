package cn.zuijianren.service;

import cn.zuijianren.model.User;
import org.springframework.stereotype.Service;

/**
 * @author zuijianren
 * @date 2020/11/12 9:27
 */
@Service
public class UserService {

    public String addUser(User user){
        System.out.println("添加用户："+user);
        return "添加成功";
    }

    public User getUserById(int id){
        User user = new User();
        user.setId(1);
        user.setUsername("zuijianren");
        user.setEmail("2@q.com");
        return user;
    }
}
