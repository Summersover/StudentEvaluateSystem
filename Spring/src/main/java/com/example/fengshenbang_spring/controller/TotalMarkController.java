package com.example.fengshenbang_spring.controller;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.mapper.DO.TotalMark;
import com.example.fengshenbang_spring.mapper.TotalMarkMapper;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin-api/totalMark")

public class TotalMarkController {

    @Autowired
    private TotalMarkMapper totalMarkMapper;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/getTotalMarkList")
    public CommonResult<?> getTotalMarkList() {

        ArrayList<TotalMark> foundTotalMarks = totalMarkMapper.findAllTotalMark();

        for(TotalMark totalMark: foundTotalMarks){
//            totalMark.setName(totalMarkMapper.getUsername(totalMark.getUsername()));

//            String name = totalMarkMapper.getUsername(totalMark.getUsername());
//            System.out.println("Fetched name: " + name);
//            totalMark.setName(name);

            if(totalMark.getRsmark()!=null&&
                    totalMark.getWsmark()!=null&&
                    totalMark.getSpmark()!=null&&
                    totalMark.getPsmark()!=null&&
                    totalMark.getGpmark()!=null&&
                    totalMark.getVsmark()!=null
            ){
                totalMark.setTotmark(Float.parseFloat(totalMark.getRsmark())+
                        Float.parseFloat(totalMark.getWsmark())+
                        Float.parseFloat(totalMark.getSpmark())+
                        Float.parseFloat(totalMark.getPsmark())+
                        Float.parseFloat(totalMark.getGpmark())+
                        Float.parseFloat(totalMark.getVsmark())+"");
            }else {
                totalMark.setTotmark("未完成所有评测");
            }

            totalMarkMapper.insertTotalMark(totalMark);

        }


        CommonResult<ArrayList<TotalMark>> result = CommonResult.success(foundTotalMarks);

        System.out.println(result);
        return result;
    }

}

