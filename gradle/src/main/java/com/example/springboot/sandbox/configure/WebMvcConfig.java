package com.example.springboot.sandbox.configure;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private MeterRegistry meterRegistry;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ConcurrentTransactionCountInterceptor(meterRegistry));
	}
}
