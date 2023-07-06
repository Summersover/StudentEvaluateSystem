package com.example.fengshenbang_spring;

import com.example.fengshenbang_spring.common.CommonResult;
import com.example.fengshenbang_spring.controller.TotalMarkController;
import com.example.fengshenbang_spring.mapper.DO.TotalMark;
import com.example.fengshenbang_spring.mapper.TotalMarkMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TotalMarkControllerTest {
    @Mock
    private TotalMarkMapper totalMarkMapper;
    @InjectMocks
    private TotalMarkController totalMarkController;
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetTotalMarkList() {
        // 准备测试数据
        TotalMark totalMark1 = new TotalMark();
        totalMark1.setUsername("2200022777");
        totalMark1.setName("测试员");
        totalMark1.setRsmark("1");
        totalMark1.setWsmark("1");
        totalMark1.setSpmark("4");
        totalMark1.setPsmark("5");
        totalMark1.setGpmark("1");
        totalMark1.setVsmark("4");
        totalMark1.setTotmark("114514");


        ArrayList<TotalMark> totalMarks = new ArrayList<>();
        totalMarks.add(totalMark1);

        // 设置模拟行为
        when(totalMarkMapper.findAllTotalMark()).thenReturn(totalMarks);

        // 执行测试
        CommonResult<?> result = totalMarkController.getTotalMarkList();

        // 验证结果
        assertEquals(totalMarks, result.getData());
    }
}
