package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.Mark;
import com.example.fengshenbang_spring.mapper.DO.PerStat2;
import com.example.fengshenbang_spring.mapper.DO.StudentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface StudentInfoMapper {
    void insertStudentInfo(StudentInfo studentInfo);

    void insertMarkList(StudentInfo studentInfo);
    ArrayList<StudentInfo> getAll();


}