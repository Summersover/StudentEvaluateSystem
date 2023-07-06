package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.Mark;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface MarkMapper {
    ArrayList<Mark> findAllResSitu();
    ArrayList<Mark> findAllWorServ();
    ArrayList<Mark> findAllSocPrac();
    ArrayList<Mark> findAllPerStat();

    void insertResSituMark(Mark mark);//所有提交分数都可以用这个
    void insertWorServMark(Mark mark);
    void insertSocPracMark(Mark mark);
    void insertPerStatMark(Mark mark);

}
