package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.controller.VO.*;
import com.example.fengshenbang_spring.mapper.DO.*;
import com.example.fengshenbang_spring.mapper.ResSituMapper;
import com.example.fengshenbang_spring.mapper.WorServMapper;
import com.example.fengshenbang_spring.mapper.SocPracMapper;
import com.example.fengshenbang_spring.mapper.PerStat1Mapper;
import com.example.fengshenbang_spring.mapper.PerStat2Mapper;
import com.example.fengshenbang_spring.mapper.StudentMapper;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.utils.DateFormatConvert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Api(tags = "学生接口")
@CrossOrigin
@RestController
@RequestMapping("/admin-api/student/")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ResSituMapper resSituMapper;

    @Autowired
    private WorServMapper worServMapper;

    @Autowired
    private SocPracMapper socPracMapper;

    @Autowired
    private PerStat1Mapper perStat1Mapper;

    @Autowired
    private PerStat2Mapper perStat2Mapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/get")
    public CommonResult<?> getUserProfile(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        Student student = studentMapper.findByUsername(username);
        return CommonResult.success(student);
    }


    @ApiOperation("科研情况-学生接口")
    @PostMapping("/updateResSitu")//要跟前端api的url吻合
    public CommonResult<?> updateResSitu(@RequestBody ResSituVO reqVO) {//注意请求体类型
//        String token = authHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("1111111tt");
        String username = reqVO.getUsername();
        System.out.println("2222222tt");
        //删除已有记录
        ArrayList<ResSitu> foundResSitu = resSituMapper.findByStuNum(username);//注意修改Mapper类和方法名
        if (foundResSitu != null) {
            resSituMapper.deleteAll(username);
        }

        ArrayList<ResSitu> newResSitu = new ArrayList<>(reqVO.getTableData());
        try {
            for (ResSitu record : newResSitu) {
                record.setUsername(username);
                //日期从格林威治时间转成年月日格式
                record.setTime(DateFormatConvert.convert(record.getTime()));
                System.out.println("3333333tt");
                try {
                    resSituMapper.insert(record);
                } catch (Exception ex) {
                    System.out.println(record);
                    System.out.println("4444444tt");
                    System.out.println(ex);
//                resSituMapper.insert(record);
                }
                System.out.println("5555555tt");
            }
            System.out.println("4444444tt");

            // 新记录重新提交
            return CommonResult.success("Research Situation inserted successfully.");

        } catch (Exception ex) {
            return CommonResult.error(50003, "Research Situation insert failed.");
        }

    }

    @GetMapping("/getResSitu")
    public CommonResult<?> getResearchList(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<ResSitu> ResSitu = resSituMapper.findByStuNum(username);
        return CommonResult.success(ResSitu);
    }

    @PostMapping("/deleteResSitu")
    public CommonResult<?> deleteResearchList(@RequestBody ResSituVO reqVO) {
        String username = reqVO.getUsername();
        ArrayList<ResSitu> newResSitu = new ArrayList<>(reqVO.getTableData());
        try {
            for (ResSitu record : newResSitu) {
                record.setUsername(username);
                System.out.println("testtest删除"+record);
                resSituMapper.delete(record);
            }
            // 新记录重新提交
            return CommonResult.success("科研情况删除成功！");

        } catch (Exception ex) {
            return CommonResult.error(50003, "科研情况删除失败！");
        }
    }

    @ApiOperation("学生骨干岗位服务-学生接口")
    @PostMapping("/updateWorServ")//要跟前端api的url吻合
    public CommonResult<?> updateWorServ(@RequestBody WorServVO reqVO) {//注意请求体类型
//        String token = authHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
        String username = reqVO.getUsername();

        //删除已有记录
//        ArrayList<WorServ> foundWorServ = worServMapper.findByStuNum(username);//注意修改Mapper类和方法名
//        if (foundWorServ != null) {
//            worServMapper.deleteAll(username);
//        }
//        System.out.println("aaaaddddwWRoServe"+foundWorServ);


        ArrayList<WorServ> newWorServ = new ArrayList<>(reqVO.getTableData());
        try {
            for (WorServ record : newWorServ) {
                record.setUsername(username);
                //日期从格林威治时间转成年月日格式
                record.setTime(DateFormatConvert.convert(record.getTime()));
                System.out.println("ddddwWRoServe"+record);
                worServMapper.insert(record);
            }
            // 新记录重新提交
            return CommonResult.success("work ser inserted successfully.");

        } catch (Exception ex) {
            return CommonResult.error(50003, "work serve insert failed.");
        }

    }

    @GetMapping("/getWorServ")
    public CommonResult<?> getWorkList(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<WorServ> WorServ = worServMapper.findByStuNum(username);
        return CommonResult.success(WorServ);
    }

    @PostMapping("/deleteWorServ")
    public CommonResult<?> deleteWorServList(@RequestBody WorServVO reqVO) {
        String username = reqVO.getUsername();
        ArrayList<WorServ> newWorServ = new ArrayList<>(reqVO.getTableData());
        try {
            for (WorServ record : newWorServ) {
                record.setUsername(username);
                System.out.println("testtest删除"+record);
                worServMapper.delete(record);
            }
            // 新记录重新提交
            return CommonResult.success("WorServ删除成功！");

        } catch (Exception ex) {
            return CommonResult.error(50003, "WorServ删除失败！");
        }
    }

    @ApiOperation("社会实践-学生接口")
    @PostMapping("/updateSocPrac")//要跟前端api的url吻合
    public CommonResult<?> updateSocPrac(@RequestBody SocPracVO reqVO) {//注意请求体类型
//        String token = authHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
        String username = reqVO.getUsername();

        //删除已有记录
//        ArrayList<SocPrac> foundSocPrac = socPracMapper.findByStuNum(username);//注意修改Mapper类和方法名
//        if (foundSocPrac != null) {
//            socPracMapper.deleteAll(username);
//        }

        ArrayList<SocPrac> newSocPrac = new ArrayList<>(reqVO.getTableData());
        try {
            for (SocPrac record : newSocPrac) {
                record.setUsername(username);
                try {
                    socPracMapper.insert(record);
                } catch (Exception ex) {
                    System.out.println(record);
                    System.out.println("4444444tt");
                    System.out.println(ex);
                }
            }
            // 新记录重新提交
            return CommonResult.success("SocPrac inserted successfully.");

        } catch (Exception ex) {
            return CommonResult.error(50003, "SocPrac insert failed.");
        }

    }

    @GetMapping("/getSocPrac")
    public CommonResult<?> getSocialList(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<SocPrac> SocPrac = socPracMapper.findByStuNum(username);
        System.out.println("测试getSocPrac："+SocPrac);
        return CommonResult.success(SocPrac);
    }

    @PostMapping("/deleteSocPrac")
    public CommonResult<?> deleteSocPracList(@RequestBody SocPracVO reqVO) {
        String username = reqVO.getUsername();
        ArrayList<SocPrac> newSocPrac = new ArrayList<>(reqVO.getTableData());
        try {
            for (SocPrac record : newSocPrac) {
                record.setUsername(username);
                System.out.println("testtest删除"+record);
                socPracMapper.delete(record);
            }
            // 新记录重新提交
            return CommonResult.success("SocPrac删除成功！");

        } catch (Exception ex) {
            return CommonResult.error(50003, "SocPrac删除失败！");
        }
    }

    @ApiOperation("个人学年总结-学生接口")
    @PostMapping("/updatePerStat")//要跟前端api的url吻合
    public CommonResult<?> updatePerStat(@RequestBody PerStat1VO req1VO, PerStat2VO req2VO) {//注意请求体类型
//        String token = authHeader.substring(7);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
        String username1 = req1VO.getUsername();
        String username2 = req1VO.getUsername();

        //删除已有记录
//        ArrayList<PerStat1> foundPerStat1 = perStat1Mapper.findByStuNum(username1);//注意修改Mapper类和方法名
//        if (foundPerStat1 != null) {
//            perStat1Mapper.deleteAll(username1);
//        }
//        ArrayList<PerStat2> foundPerStat2 = perStat2Mapper.findByStuNum(username2);//注意修改Mapper类和方法名
//        if (foundPerStat2 != null) {
//            perStat2Mapper.deleteAll(username2);
//        }

        ArrayList<PerStat1> newPerStat1 = new ArrayList<>(req1VO.getTableData());
        ArrayList<PerStat2> newPerStat2 = new ArrayList<>(req2VO.getTableData());
        try {
            for (PerStat1 record1 : newPerStat1) {
                record1.setUsername(username1);
                //日期从格林威治时间转成年月日格式
                record1.setTime(DateFormatConvert.convert(record1.getTime()));
                perStat1Mapper.insert(record1);
            }
            for (PerStat2 record2 : newPerStat2) {
                record2.setUsername(username2);
                perStat2Mapper.insert(record2);
            }
            // 新记录重新提交
            return CommonResult.success("PerStat inserted successfully.");

        } catch (Exception ex) {
            return CommonResult.error(50003, "PerStat insert failed.");
        }

    }

    @GetMapping("/getPerStat1")
    public CommonResult<?> getPersonal1List(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<PerStat1> PerStat1 = perStat1Mapper.findByStuNum(username);
        return CommonResult.success(PerStat1);
    }
    @GetMapping("/getPerStat2")
    public CommonResult<?> getPersonal2List(@RequestHeader("Authorization") String authHeader) {
        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String token = authHeader.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        ArrayList<PerStat2> PerStat2 = perStat2Mapper.findByStuNum(username);
        return CommonResult.success(PerStat2);
    }

    @PostMapping("/deletePerStat")
    public CommonResult<?> deletePerStatList(@RequestBody PerStat1VO reqVO) {
        String username = reqVO.getUsername();
        ArrayList<PerStat1> newPerStat1 = new ArrayList<>(reqVO.getTableData());
        try {
            for (PerStat1 record : newPerStat1) {
                record.setUsername(username);
                System.out.println("testtest删除"+record);
                perStat1Mapper.delete(record);
            }
            // 新记录重新提交
            return CommonResult.success("PerStat1 删除成功！");

        } catch (Exception ex) {
            return CommonResult.error(50003, "PerStat1 删除失败！");
        }
    }
}
