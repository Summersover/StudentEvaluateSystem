package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.ResSitu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface ResSituMapper {
    ArrayList<ResSitu> findByStuNum(String username);

    void deleteAll(String username);

    void insert(ResSitu ResSitu);
    void delete(ResSitu ResSitu);

}
