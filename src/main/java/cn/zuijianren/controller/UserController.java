package cn.zuijianren.controller;

import cn.zuijianren.exception.APIException;
import cn.zuijianren.model.User;
import cn.zuijianren.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zuijianren
 * @date 2020/11/12 9:19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid User user){
        System.out.println(user);
        return userService.addUser(user);
    }

    @GetMapping("/getUser")
    public User register(){
        /*if(2 != 1){
            throw new APIException("获取失败的原因：。。。");
        }
*/
        return userService.getUserById(1);
    }
}
