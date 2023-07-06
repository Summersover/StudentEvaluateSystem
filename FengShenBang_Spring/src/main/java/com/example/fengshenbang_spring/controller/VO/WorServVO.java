package com.example.fengshenbang_spring.controller.VO;

import com.example.fengshenbang_spring.mapper.DO.WorServ;
import lombok.Data;

import java.util.ArrayList;

@Data
public class WorServVO {
    private String username;

    ArrayList<WorServ> tableData = new ArrayList<>();
}
