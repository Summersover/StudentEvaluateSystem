package com.example.fengshenbang_spring.mapper.DO;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
public class TotalMark {
    private String username;
    private String name;
    private String rsmark;
    private String wsmark;
    private String spmark;
    private String psmark;
    private String gpmark;
    private String vsmark;
    private String totmark;


    public TotalMark() {
    }

    public TotalMark(String username, String name, String rsmark, String wsmark, String spmark, String psmark, String gpmark, String vsmark) {
        this.username = username;
        this.name = name;
        this.rsmark = rsmark;
        this.wsmark = wsmark;
        this.spmark = spmark;
        this.psmark = psmark;
        this.gpmark = gpmark;
        this.vsmark = vsmark;
    }
}
