package com.pramati.crs.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.pramati.crs.booking.client")
@SpringBootApplication
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

	@Bean
	FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
		FilterRegistrationBean<ForwardedHeaderFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new ForwardedHeaderFilter());
		return bean;
	}
}
