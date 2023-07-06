package com.example.fengshenbang_spring.mapper.DO;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentInfo {
    @ExcelProperty(index = 0)
    private String username;

    @ExcelProperty(index = 1)
    private String name;

    // 无参构造函数
    public StudentInfo() {
    }

    // 带参构造函数
    public StudentInfo(String username, String name) {
        this.username = username;
        this.name = name;
//        this.mark1 = mark1;
//        this.mark2 = mark2;
//        this.mark3 = mark3;
//        this.mark4 = mark4;
//        this.mark5 = mark5;
//        this.mark6 = mark6;
//        this.totalMark = totalMark;
    }
}
