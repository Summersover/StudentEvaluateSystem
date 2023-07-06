package com.example.fengshenbang_spring.controller.VO;

import com.example.fengshenbang_spring.mapper.DO.SocPrac;
import lombok.Data;

import java.util.ArrayList;

@Data
public class SocPracVO {
    private String username;

    ArrayList<SocPrac> tableData = new ArrayList<>();
}
