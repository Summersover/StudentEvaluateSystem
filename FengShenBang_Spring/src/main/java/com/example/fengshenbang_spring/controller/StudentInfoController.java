package com.example.fengshenbang_spring.controller;

import com.alibaba.excel.EasyExcel;
import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.StudentInfo;
import com.example.fengshenbang_spring.mapper.StudentInfoMapper;
import com.example.fengshenbang_spring.service.StudentInfoService;
import com.example.fengshenbang_spring.utils.StudentInfoListener;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:8081")
@Data
@RestController
@RequestMapping("/admin-api/studentInfo")

public class StudentInfoController {
    private final StudentInfoService studentInfoService;
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Autowired
    public StudentInfoController(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }
    @CrossOrigin(origins = "http://localhost:8081")

    @GetMapping("/get")//学生列表页，获取所有学生的列表
    public CommonResult<?> getStudentInfo() {
        ArrayList<StudentInfo> studentInfo = studentInfoMapper.getAll();
        return CommonResult.success(studentInfo);
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/upload")

    public CommonResult<String> uploadStudentInfo(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();

            // 创建StudentInfoListener监听器
            StudentInfoListener listener = new StudentInfoListener();

            // 读取Excel文件并传入监听器
            EasyExcel.read(inputStream, StudentInfo.class, listener).sheet().doRead();

            // 获取监听器中读取的数据
            List<StudentInfo> studentInfoList = listener.getStudentInfoList();

            // 将数据传入数据库进行处理
            studentInfoService.processStudentInfoList(studentInfoList);

            return CommonResult.success("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return CommonResult.error(500, "上传失败");
        }
    }
}
