package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.controller.VO.LoginReqVO;
import com.example.fengshenbang_spring.mapper.DO.User;
import com.example.fengshenbang_spring.mapper.UserMapper;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.controller.VO.TokenRespVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;

@RestController
@RequestMapping("/admin-api/auth/")
public class AuthController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private String code;
    @CrossOrigin  //后端跨域
    @PostMapping("/login")
    public CommonResult<?> login(@RequestBody LoginReqVO loginUser) {
        User user = userMapper.findByUsername(loginUser.getUsername());

        //直接后端验证
        if(!loginUser.getCaptchaText().equals(code)){
            return CommonResult.error(50006,"登录失败，验证码不正确");
        }
        if (user == null) {
            return CommonResult.error(50007, "登录失败，账号密码不正确");
        }
        if (!loginUser.getPassword().equals(user.getPassword())) {
            return CommonResult.error(50007, "登录失败，账号密码不正确");
        }

        String username = loginUser.getUsername();

        // 生成访问令牌和刷新令牌
        String accessToken = jwtTokenUtil.generateAccessToken(username);
        String refreshToken = jwtTokenUtil.generateRefreshToken(username);
        TokenRespVO token_resp = new TokenRespVO(accessToken, refreshToken);

        CommonResult<TokenRespVO> result = CommonResult.success(token_resp);
        return result;

    }

    @RequestMapping("/captcha")
    public void getCode(HttpServletResponse response) {
        //随机生成4位验证码
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 4);
        //定义图片的显示大小
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 30);
        //设置给前端的图片类型和响应头
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        try {
            //调用父类的setGenerator()方法，设置验证码的类型
            lineCaptcha.setGenerator(randomGenerator);
            //输出流到web页面
            lineCaptcha.write(response.getOutputStream());

            //打印一下生成的验证码
            System.out.println(lineCaptcha.getCode() + "   captcha");
            code = lineCaptcha.getCode();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                //最后清除缓存并关闭IO流
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

