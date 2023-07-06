package com.example.fengshenbang_spring.service;

import com.example.fengshenbang_spring.mapper.DO.StudentInfo;
import com.example.fengshenbang_spring.mapper.StudentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoService {
    private final StudentInfoMapper studentInfoMapper;

    @Autowired
    public StudentInfoService(StudentInfoMapper studentInfoMapper) {
        this.studentInfoMapper = studentInfoMapper;
    }

    public void processStudentInfoList(List<StudentInfo> studentInfoList) {
        for (StudentInfo studentInfo : studentInfoList) {
            studentInfoMapper.insertStudentInfo(studentInfo);
            studentInfoMapper.insertMarkList(studentInfo);
        }
    }

    // 其他服务方法
}