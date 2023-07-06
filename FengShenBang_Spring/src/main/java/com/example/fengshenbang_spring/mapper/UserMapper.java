package com.example.fengshenbang_spring.mapper;

import com.example.fengshenbang_spring.mapper.DO.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findByUsername(String username);
}
