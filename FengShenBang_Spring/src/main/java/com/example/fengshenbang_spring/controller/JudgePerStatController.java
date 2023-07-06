package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.*;
import com.example.fengshenbang_spring.mapper.DO.*;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "评委接口")
@RestController
@RequestMapping("/admin-api/judge/perStat/")
public class JudgePerStatController {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PerStat1Mapper perStat1Mapper;
    @Autowired
    private PerStat2Mapper perStat2Mapper;
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

    @GetMapping("getPerStat1")//要跟前端api的url吻合
    public CommonResult<?> getPerStat1List() {
        ArrayList<PerStat1> personalStatement1 = perStat1Mapper.findByStuNum(this.postStuNum);
        return CommonResult.success(personalStatement1);
    }
//第二个传回的数据是数组，但是前端的转化是对象，应该是有问题的
    @GetMapping("getPerStat2")//要跟前端api的url吻合
    public CommonResult<?> getPerStat2List() {
        ArrayList<PerStat2> personalStatement2 = perStat2Mapper.findByStuNum(this.postStuNum);
        return CommonResult.success(personalStatement2);
    }

    @GetMapping("/getPerStatMarkList")
    public CommonResult<?> getPerStatMarkList() {
        ArrayList<Mark> markList = markMapper.findAllPerStat();
        System.out.println("测试测试PerStat:"+markList);
        return CommonResult.success(markList);
    }

    @PostMapping("/updatePerStatMark")
    public CommonResult<?> updatePerStatMark(@RequestBody Mark mark) {

        Mark updatePerStatMark = new Mark(mark.getUsername(), mark.getMark());

        markMapper.insertPerStatMark(updatePerStatMark);

        return CommonResult.success("Update PersonalStatement mark successfully.");
    }
}
