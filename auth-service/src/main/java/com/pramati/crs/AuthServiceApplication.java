package com.pramati.crs;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author manikanth
 *
 */
@SpringBootApplication
@EnableSwagger2
public class AuthServiceApplication {

	public static void main(String[] args) {
		String[] extededArgs = Arrays.copyOf(args, args.length+1);
		extededArgs[args.length] = "-DLog4jContextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector";
		SpringApplication.run(AuthServiceApplication.class, extededArgs);
	}

	/**
	 * Customizing Swagger Configurations
	 * 
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.pramati.crs")).paths(PathSelectors.any()).build();
	}

	/**
	 * Giving customized title, description and version of the service
	 * using Swagger
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Car Rental System Auth Service API")
				.description("This is a service which provides the system for customers and vendors to login")
				.version("1.0").build();
	}

	/**
	 * Initializing BCryptPasswordEncoder
	 * 
	 */
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}