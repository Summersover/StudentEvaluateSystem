package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.ResSitu;
import com.example.fengshenbang_spring.mapper.DO.WorServ;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface WorServMapper {
    ArrayList<WorServ> findByStuNum(String username);

    void deleteAll(String username);

    void insert(WorServ WorServ);

    void delete(WorServ WorServ);

}
