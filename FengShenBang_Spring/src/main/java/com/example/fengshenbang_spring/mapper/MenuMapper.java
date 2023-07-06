package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface MenuMapper {
    String findRole(String username);
    ArrayList<Menu> findMenu(String username);

}