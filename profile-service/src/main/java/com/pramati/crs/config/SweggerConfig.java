package com.pramati.crs.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author srinivasn
 *  
 *  Enables the swaggers api
 */
@Configurable
@EnableSwagger2
public class SweggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors
				.basePackage("com.pramati.crs.controller"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().contact(new Contact("Srinivas Nalla", "http://www.pramati.com", "srinivas.nalla@imaginea")).title("Profile-Service Rest API")
                .description("Profile service rest api")
                .version("1.0.0")
                .build();
	}
	
}
