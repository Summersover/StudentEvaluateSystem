package com.example.fengshenbang_spring.service;

import com.example.fengshenbang_spring.mapper.DO.StudentGPA;
import com.example.fengshenbang_spring.mapper.StudentGPAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGPAService {
    private final StudentGPAMapper studentGPAMapper;

    @Autowired
    public StudentGPAService(StudentGPAMapper studentGPAMapper) {
        this.studentGPAMapper = studentGPAMapper;
    }

    public void processStudentGPAList(List<StudentGPA> studentGPAList) {
        for (StudentGPA studentGPA : studentGPAList) {
            studentGPAMapper.insertStudentGPA(studentGPA);
            studentGPAMapper.insertMarkList(studentGPA);
        }
    }

}
