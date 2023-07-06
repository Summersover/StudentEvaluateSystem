//package com.example.fengshenbang_spring;
//
//import com.example.fengshenbang_spring.mapper.DO.ResSitu;
//import com.example.fengshenbang_spring.mapper.ResSituMapper;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.*;
//
//public class StudentResSitGetTest {
//
//    @Mock
//    private ResSituMapper resSituMapper;
//
//    @BeforeEach
//    public void setUp() {
////        Mockito框架模拟ResSituMapper
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testGetResSitByStuNum() {
//        // 准备测试数据
//        String username = "2200022701";
//        ResSitu expectedResSitu = new ResSitu("2200022701", "一等奖", "2023-07-01", "麦当劳", "冰杯");
//        ArrayList<ResSitu> expectedResSituList = new ArrayList<>();
//        expectedResSituList.add(expectedResSitu);
//        //模拟数据库操作的返回结果
//        when(resSituMapper.findByStuNum(username)).thenReturn(expectedResSituList);
//        //执行后端方法
//        ArrayList<ResSitu> actualResSituList = resSituMapper.findByStuNum(username);
//        Assertions.assertEquals(expectedResSituList, actualResSituList);
//        //验证数据库操作的调用次数
//        verify(resSituMapper, times(1)).findByStuNum(username);
//    }
//
//    @Test
//    public void testGetResSitByStuNumNotFound() {
//        String username = "5615963459";
//        ArrayList<ResSitu> actualResSituList = resSituMapper.findByStuNum(username);
//        //验证结果是否为空
//        //不直接写null，实际上有个list，里面为空
//        ArrayList<ResSitu> nullList = new ArrayList<>();
//        Assertions.assertEquals(nullList, actualResSituList);
//    }
//}
//
