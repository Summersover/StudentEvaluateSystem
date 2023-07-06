package com.example.fengshenbang_spring.controller.VO;

import com.example.fengshenbang_spring.mapper.DO.PerStat1;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PerStat1VO {
    private String username;

    ArrayList<PerStat1> tableData = new ArrayList<>();
}
