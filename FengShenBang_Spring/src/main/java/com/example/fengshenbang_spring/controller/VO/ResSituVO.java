package com.example.fengshenbang_spring.controller.VO;

import com.example.fengshenbang_spring.mapper.DO.ResSitu;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ResSituVO {
    private String username;

    ArrayList<ResSitu> tableData = new ArrayList<>();
}
