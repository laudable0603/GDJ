package com.gdu.app02.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//서블릿 컨택스트에 있는것을 옮길때 해당파일 사용
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/load/image/**")
			.addResourceLocations("file:///C:/summernoteImage/");
	}
}
