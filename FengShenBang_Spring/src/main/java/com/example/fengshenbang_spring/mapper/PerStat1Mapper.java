package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.PerStat1;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface PerStat1Mapper {
    ArrayList<PerStat1> findByStuNum(String username);

    void deleteAll(String username);

    void insert(PerStat1 PerStat1);

    void delete(PerStat1 PerStat1);

}
