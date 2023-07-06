package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.TotalMark;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface TotalMarkMapper {


    ArrayList<TotalMark> findAllTotalMark();

    String getUsername(String username);

    void insertTotalMark(TotalMark totalMark);

}



