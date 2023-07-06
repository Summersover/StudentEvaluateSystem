package com.example.fengshenbang_spring.mapper.DO;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentGPA {
    @ExcelProperty(index = 0)
    private String username;

    @ExcelProperty(index = 1)
    private String name;

    @ExcelProperty(index = 2)
    private String grade;

    @ExcelProperty(index = 3)
    private String gpa;

    @ExcelProperty(index = 4)
    private String gpmark;

    // 无参构造函数
    public StudentGPA() {
    }

    // 带参构造函数
    public StudentGPA(String username, String name, String grade, String gpa, String gpmark) {
        this.username = username;
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
        this.gpmark = gpmark;

    }
}
