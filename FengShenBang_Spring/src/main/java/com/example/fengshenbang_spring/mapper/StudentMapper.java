package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface StudentMapper {
    ArrayList<Student> findAll();

    Student findByUsername(String username);
}
