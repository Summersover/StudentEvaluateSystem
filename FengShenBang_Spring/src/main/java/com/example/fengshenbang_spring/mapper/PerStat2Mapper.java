package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.PerStat2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface PerStat2Mapper {
    ArrayList<PerStat2> findByStuNum(String username);

    void deleteAll(String username);

    void insert(PerStat2 PerStat2);

    void delete(PerStat2 PerStat2);

}
