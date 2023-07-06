package com.example.fengshenbang_spring.controller;

import com.alibaba.excel.EasyExcel;
import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.StudentGPA;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.service.StudentGPAService;
import com.example.fengshenbang_spring.utils.StudentGPAListener;
import com.example.fengshenbang_spring.mapper.StudentGPAMapper;
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
@RequestMapping("/admin-api/studentGPA")
public class StudentGPAController {
    private final StudentGPAService studentGPAService;

    @Autowired
    public StudentGPAController(StudentGPAService studentGPAService) {
        this.studentGPAService = studentGPAService;
    }

    @Autowired
    private StudentGPAMapper studentGPAMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/upload")
    public CommonResult<String> uploadStudentGPA(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();

            System.out.println("上传GPATest");
            System.out.println(file);

            // 创建StudentGPAListener监听器
            StudentGPAListener listener = new StudentGPAListener();

            // 读取Excel文件并传入监听器
            EasyExcel.read(inputStream, StudentGPA.class, listener).sheet().doRead();

            // 获取监听器中读取的数据
            List<StudentGPA> studentGPAList = listener.getStudentGPAList();
            // 在这里添加println语句，用于检查studentVolSerList中的数据
            System.out.println(studentGPAList);

            // 将数据传入数据库进行处理
            studentGPAService.processStudentGPAList(studentGPAList);

            return CommonResult.success("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500, "上传失败");
        }
    }

    @GetMapping("/getStudentGPAData")
    public CommonResult<?> getStudentGPAData() {
        ArrayList<StudentGPA> studentGPAs = studentGPAMapper.findAllGPA();
        System.out.println("测试获取gpa：：："+studentGPAs);
        return CommonResult.success(studentGPAs);
    }

    @GetMapping("/getGPA")
    public CommonResult<?> getGpa(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<StudentGPA> studentGpa = studentGPAMapper.findByStuNum(username);
        System.out.println("测试GPa一个："+studentGpa);
        return CommonResult.success(studentGpa);
    }
}
