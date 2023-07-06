package com.example.fengshenbang_spring.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Mapper
@Repository
public interface PermissionMapper {
    String findRole(String username);
    ArrayList<String> findPermission(String username);

}