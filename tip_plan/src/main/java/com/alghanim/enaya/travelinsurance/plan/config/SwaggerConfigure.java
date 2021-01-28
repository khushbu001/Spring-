package com.alghanim.enaya.travelinsurance.plan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author khushbu
 * @Description This method will use for API Documentation.
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {
	
	/**
	 * @Description This method will use for API Documentation
	 */
	@Bean
	public Docket userApi() {
		 return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com.alghanim.enaya.travelinsurance.plan"))
		         .build();		
	}
}
