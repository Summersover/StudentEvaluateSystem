package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.StudentGPA;
import com.example.fengshenbang_spring.mapper.DO.StudentVolSer;
import com.example.fengshenbang_spring.mapper.DO.TotalMark;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentVolSerMapper {
    void insertStudentVolSer(StudentVolSer studentVolSer);
    //d
    void insertMarkList(StudentVolSer studentVolSer);

    ArrayList<StudentVolSer> findAllVolSer();

    ArrayList<StudentVolSer> findByStuNum(String username);


}