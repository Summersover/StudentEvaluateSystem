package com.example.fengshenbang_spring.mapper.DO;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentVolSer {
    @ExcelProperty(index = 0)
    private String username;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private String time;

    @ExcelProperty(index = 3)
    private String vsmark;

    // 无参构造函数
    public StudentVolSer() {
    }

    // 带参构造函数
    public StudentVolSer(String username, String name, String time, String vsmark) {
        this.username = username;
        this.name = name;
        this.time = time;
        this.vsmark = vsmark;

    }
}
