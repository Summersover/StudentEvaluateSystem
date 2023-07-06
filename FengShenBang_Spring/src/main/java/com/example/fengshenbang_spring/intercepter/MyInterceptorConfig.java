package com.example.fengshenbang_spring.intercepter;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor(permissionMapper, jwtTokenUtil))
				.addPathPatterns("/admin-api/**"); // 设置拦截的URL模式
	}
}