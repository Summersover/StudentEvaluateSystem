package com.example.fengshenbang_spring.mapper.DO;

import lombok.Data;

@Data
public class ResSitu {
    private String username;
    private String rank;
    private String time;
    private String place;
    private String prize;

    public ResSitu() {
    }
}
