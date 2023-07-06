package com.example.fengshenbang_spring.mapper.DO;


import lombok.Data;

@Data
public class Menu {
    private String name;
    private String path;
    private String component;

    public Menu(String name, String path, String component) {
        this.name = name;
        this.path = path;
        this.component = component;
    }

}
