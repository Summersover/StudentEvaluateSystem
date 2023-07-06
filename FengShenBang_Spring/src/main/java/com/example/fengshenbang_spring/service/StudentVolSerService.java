package com.example.fengshenbang_spring.service;

import com.example.fengshenbang_spring.mapper.DO.StudentVolSer;
import com.example.fengshenbang_spring.mapper.StudentVolSerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentVolSerService {
    private final StudentVolSerMapper studentVolSerMapper;

    @Autowired
    public StudentVolSerService(StudentVolSerMapper studentVolSerMapper) {
        this.studentVolSerMapper = studentVolSerMapper;
    }

    public void processStudentVolSerList(List<StudentVolSer> studentVolSerList) {
        for (StudentVolSer studentVolSer : studentVolSerList) {
            studentVolSerMapper.insertStudentVolSer(studentVolSer);
            studentVolSerMapper.insertMarkList(studentVolSer);
        }
    }

    // 其他服务方法
}
