package com.example.fengshenbang_spring.mapper.DO;
import lombok.Data;
import java.util.List;


@Data
public class User {
    private String username;
    private String password;

    public User(String username, String password ) {
        this.username = username;
        this.password = password;
    }

//    private List<Role> roles;
}
