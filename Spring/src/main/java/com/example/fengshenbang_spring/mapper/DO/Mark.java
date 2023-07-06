package com.example.fengshenbang_spring.mapper.DO;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class Mark {
    private String username;
    private String mark;

    public Mark() {
    }

    public Mark(String username, String mark) {
        this.username = username;
        this.mark = mark;
    }
}
