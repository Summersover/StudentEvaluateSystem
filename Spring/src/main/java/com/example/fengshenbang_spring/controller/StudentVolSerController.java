package com.example.fengshenbang_spring.controller;

import com.alibaba.excel.EasyExcel;
import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.StudentVolSer;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.mapper.StudentVolSerMapper;
import com.example.fengshenbang_spring.service.StudentVolSerService;
import com.example.fengshenbang_spring.utils.StudentVolSerListener;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Data
@CrossOrigin
@RestController
@RequestMapping("/admin-api/studentVolSer")
public class StudentVolSerController {
    private final StudentVolSerService studentVolSerService;

    @Autowired
    public StudentVolSerController(StudentVolSerService studentVolSerService) {
        this.studentVolSerService = studentVolSerService;
    }

    @Autowired
    private StudentVolSerMapper studentVolSerMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/upload")
    public CommonResult<String> uploadStudentVolSer(MultipartFile file) {
        System.out.println("上传volserTest");
        System.out.println(file);
        try {
            InputStream inputStream = file.getInputStream();

            // 创建StudentVolSerListener监听器
            StudentVolSerListener listener = new StudentVolSerListener();

            // 读取Excel文件并传入监听器
            EasyExcel.read(inputStream, StudentVolSer.class, listener).sheet().doRead();

            // 获取监听器中读取的数据
            List<StudentVolSer> studentVolSerList = listener.getStudentVolSerList();

            // 在这里添加println语句，用于检查studentVolSerList中的数据
            System.out.println(studentVolSerList);

            // 将数据传入数据库进行处理
            studentVolSerService.processStudentVolSerList(studentVolSerList);

            return CommonResult.success("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500, "上传失败");
        }
        //d
    }

    @GetMapping("/getStudentVolSerData")
    public CommonResult<?> getStudentVolSerData() {
        System.out.println("测!!!!!!!!!试！"+studentVolSerMapper);
        ArrayList<StudentVolSer> studentVolSers = studentVolSerMapper.findAllVolSer();
        System.out.println("测试！"+studentVolSers);
        return CommonResult.success(studentVolSers);
    }

    @GetMapping("/getVolSer")
    public CommonResult<?> getVolSer(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<StudentVolSer> StudentVolSer = studentVolSerMapper.findByStuNum(username);
        System.out.println("测试VolSer一个："+StudentVolSer);
        return CommonResult.success(StudentVolSer);
    }
}
