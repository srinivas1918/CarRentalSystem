package com.pramati.crs.booking.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The configuration class for swagger 2
 * 
 * @author ashishr
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.pramati.crs")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Booking Service", "Rest APIs for Booking micro-service", "Version 1.0.0.SNAPSHOT",
				"Terms of service", new Contact("Ashish Roy", "http://www.pramati.com", "ashish.roy@imaginea.com"),
				"License of API", "API license URL", Collections.emptyList());
	}
}
