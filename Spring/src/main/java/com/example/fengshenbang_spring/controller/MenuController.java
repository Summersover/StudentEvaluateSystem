package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.Menu;
import com.example.fengshenbang_spring.mapper.MenuMapper;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin-api/menu/")
public class MenuController {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/getMenu")
    public CommonResult<?> getMenuList(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<Menu> menuList = menuMapper.findMenu(username);

        CommonResult<ArrayList<Menu>> result = CommonResult.success(menuList);

        return result;
    }

    @GetMapping("/getRole")
    public CommonResult<?> getRole(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        String roleName = menuMapper.findRole(username);

        CommonResult<String> result = CommonResult.success(roleName);

        return result;
    }

}

