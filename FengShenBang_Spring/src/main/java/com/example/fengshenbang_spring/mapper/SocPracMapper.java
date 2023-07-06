package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.SocPrac;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface SocPracMapper {
    ArrayList<SocPrac> findByStuNum(String username);

    void deleteAll(String username);

    void insert(SocPrac SocPrac);

    void delete(SocPrac SocPrac);

}
