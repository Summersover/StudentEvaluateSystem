package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.Mark;
import com.example.fengshenbang_spring.mapper.DO.SocPrac;
import com.example.fengshenbang_spring.mapper.DO.Student;
import com.example.fengshenbang_spring.mapper.MarkMapper;
import com.example.fengshenbang_spring.mapper.SocPracMapper;
import com.example.fengshenbang_spring.mapper.StudentMapper;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "评委接口")
@RestController
@RequestMapping("/admin-api/judge/socPrac/")
public class JudgeSocPracController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SocPracMapper socPracMapper;

    @Autowired
    private MarkMapper markMapper;

    private String postStuNum;

    @GetMapping("/getStuList")//学生列表页，获取所有学生的列表
    public CommonResult<?> getStuList() {
        ArrayList<Student> studentList = studentMapper.findAll();
        return CommonResult.success(studentList);
    }

    @PostMapping("/sendStuNum")//进入学生的详细信息页，传回学生学号
    public CommonResult<?> sendStuNum(@RequestBody Student reqVO) {
        this.postStuNum = reqVO.getUsername();//只传学生学号，直接复用Student类，不写reqVO了
        return CommonResult.success("Send student number successfully");
    }

    @GetMapping("getSocPrac")//要跟前端api的url吻合
    public CommonResult<?> getSocPracList() {
        ArrayList<SocPrac> socialPractice = socPracMapper.findByStuNum(this.postStuNum);
        return CommonResult.success(socialPractice);
    }

    @GetMapping("/getSocPracMarkList")
    public CommonResult<?> getSocPracMarkList() {
        ArrayList<Mark> markList = markMapper.findAllSocPrac();
        return CommonResult.success(markList);
    }

    @PostMapping("/updateSocPracMark")
    public CommonResult<?> updateSocPracMark(@RequestBody Mark mark) {

        Mark updateSocPracMark = new Mark(mark.getUsername(), mark.getMark());

        markMapper.insertSocPracMark(updateSocPracMark);

        return CommonResult.success("Update SocialPractice mark successfully.");
    }

}
