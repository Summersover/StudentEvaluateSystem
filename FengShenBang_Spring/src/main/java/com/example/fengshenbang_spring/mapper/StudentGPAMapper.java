package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.StudentGPA;
import com.example.fengshenbang_spring.mapper.DO.StudentVolSer;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentGPAMapper {
    void insertStudentGPA(StudentGPA studentGPA);
    void insertMarkList(StudentGPA studentGPA);

    ArrayList<StudentGPA> findAllGPA();


    ArrayList<StudentGPA> findByStuNum(String username);
}