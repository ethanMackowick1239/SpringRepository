package com.tcs.mvcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.tcs.mvcdemo.interceptor.GuestInterceptor;

@Configuration
@EnableWebMvc // it will enable the mvc env (@requestbaody, controller , response body, requestmapping, @valid
@ComponentScan("com.tcs.mvcdemo")
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new GuestInterceptor()).addPathPatterns("/guest");
		super.addInterceptors(registry);
	}


	@Bean
	public InternalResourceViewResolver	 resolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
