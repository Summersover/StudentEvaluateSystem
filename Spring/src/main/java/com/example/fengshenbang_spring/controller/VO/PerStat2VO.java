package com.example.fengshenbang_spring.controller.VO;

import com.example.fengshenbang_spring.mapper.DO.PerStat2;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PerStat2VO {
    private String username;

    ArrayList<PerStat2> tableData = new ArrayList<>();
}
