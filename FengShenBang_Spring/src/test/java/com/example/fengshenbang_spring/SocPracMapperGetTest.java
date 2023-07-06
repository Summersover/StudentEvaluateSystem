//package com.example.fengshenbang_spring;
//import com.example.fengshenbang_spring.mapper.DO.ResSitu;
//import com.example.fengshenbang_spring.mapper.DO.SocPrac;
//import com.example.fengshenbang_spring.mapper.SocPracMapper;
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
//public class SocPracMapperGetTest {
//    @Mock
//    private SocPracMapper socPracMapper;
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//    @Test
//    public void testFindByStuNum() {
//        // 准备测试数据
//        String username = "2200022701";
//
//        // 设置期望的返回结果
//        SocPrac expectedSocPrac = new SocPrac("2200022701", "肯德基", "德克萨斯", "30", "10", "洗手员", "是", "是", "蜜汁全鸡");
//        ArrayList<SocPrac> expectedSocPracList = new ArrayList<>();
//        expectedSocPracList.add(expectedSocPrac);
//
//        // 模拟数据库操作的返回结果
//        when(socPracMapper.findByStuNum(username)).thenReturn(expectedSocPracList);
//
//        // 执行后端方法
//        ArrayList<SocPrac> actualSocPracList = socPracMapper.findByStuNum(username);
//
//        Assertions.assertEquals(expectedSocPracList, actualSocPracList);
//
//        // 验证数据库操作的调用次数
//        verify(socPracMapper, times(1)).findByStuNum(username);
//    }
//
//}
