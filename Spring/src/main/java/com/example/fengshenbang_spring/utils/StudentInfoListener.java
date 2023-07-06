package com.example.fengshenbang_spring.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.fengshenbang_spring.mapper.DO.StudentInfo;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoListener extends AnalysisEventListener<StudentInfo> {

    private List<StudentInfo> studentInfoList = new ArrayList<>();

    @Override
    public void invoke(StudentInfo studentInfo, AnalysisContext context) {
        studentInfoList.add(studentInfo);
        // 在这里可以对每一行数据进行进一步处理
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 读取完毕后的操作，可以在这里进行数据库操作或其他逻辑处理
    }

    public List<StudentInfo> getStudentInfoList() {
        return studentInfoList;
    }
}
