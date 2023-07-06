package com.example.fengshenbang_spring.mapper.DO;

import lombok.Data;

import java.util.ArrayList;

@Data

public class Permission {
    private String role;
    private ArrayList<String> permissions;

    public Permission(String role, ArrayList<String> permissions) {
        this.role = role;
        this.permissions = permissions;
    }
}

