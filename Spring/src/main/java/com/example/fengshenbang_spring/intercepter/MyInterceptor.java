package com.example.fengshenbang_spring.intercepter;
import com.example.fengshenbang_spring.utils.JwtTokenUtil;
import com.example.fengshenbang_spring.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Component
public class MyInterceptor implements HandlerInterceptor {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	public MyInterceptor(PermissionMapper permissionMapper, JwtTokenUtil jwtTokenUtil) {
		this.permissionMapper = permissionMapper;
		this.jwtTokenUtil =jwtTokenUtil;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 在请求处理之前执⾏的操作
		System.out.println("=====preHandle=====");

		// 打印拦截或放行的接口URI
		System.out.println("Intercepted URI: " + request.getRequestURI());

		// 放行 OPTIONS 请求
		if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
			System.out.println(request.getMethod());
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		}
		if(request.getRequestURI().startsWith("/admin-api/auth")) { //login或register
			return true;
		}
		if(request.getHeader( "Authorization")==null){
			System.out.println("Request header is transmitted incorrectly.");
			return false;
		}

		String token = request.getHeader( "Authorization").substring(7);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		String uri = request.getRequestURI();
		String role=permissionMapper.findRole(username);
		System.out.println("uri: " + uri);
		System.out.println("role: " + role);

		if (role.equals("学生") || role.equals("评委老师") || role.equals("学工老师")) {
			// 根据请求的角色不同进行访问限制
			ArrayList<String> permissions = permissionMapper.findPermission(username);
			System.out.println("permissions: " + permissions);
			if(!permissions.contains(uri)){
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write("You do not have the access to this resource.");
				return false;
			} else {
				// 正常访问资源
				return true;
			}

		} else {
			// 不是有访问权限的角色
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("You are not the authorized role.");
			return false;
		}
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
		// 在请求处理之后，视图渲染之前执行的操作
		System.out.println("=====postHandle=====");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
	                            Exception ex) throws Exception {
		// 在请求完成之后执行的操作，即视图渲染完成后
		System.out.println("=====afterCompletion=====");
	}
}
