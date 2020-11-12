package cn.zuijianren.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zuijianren
 * @date 2020/11/12 9:20
 */
@Data
public class User {
    @NotNull(message = "id 不能为空")
    private int id;

    @NotBlank(message = "用户名不能为空")
    @Size(min = 2, max = 6, message = "用户名长度为2~6")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 2, max = 6, message = "密码长度为2~6")
    private String userPassword;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

}
