package com.example.fengshenbang_spring.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.fengshenbang_spring.mapper.DO.StudentGPA;

import java.util.ArrayList;
import java.util.List;

public class StudentGPAListener extends AnalysisEventListener<StudentGPA> {

    private List<StudentGPA> studentGPAList = new ArrayList<>();

    @Override
    public void invoke(StudentGPA studentGPA, AnalysisContext context) {
        studentGPAList.add(studentGPA);
        // 在这里可以对每一行数据进行进一步处理
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 读取完毕后的操作
    }

    public List<StudentGPA> getStudentGPAList() {
        return studentGPAList;
    }
}
