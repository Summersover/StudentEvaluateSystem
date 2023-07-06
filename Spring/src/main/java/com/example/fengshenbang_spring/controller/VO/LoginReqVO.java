package com.example.fengshenbang_spring.controller.VO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@ApiModel(description = "用户登录请求")
public class LoginReqVO {
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 3, max = 20, message = "用户名长度不正确")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "用户名只能为数字以及字母")
    @ApiModelProperty(value = "用户名", required = true,example = "user01")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 20, message = "密码长度为 6-20 位")
    //以上为校验用的限制注解
    //所有VO类都可以写类似的注解给输入信息作限制
    @ApiModelProperty(value = "密码", required = true,example = "123456")
    //以上为swagger用注解
    private String password;

    private String captchaText;
}