package com.clarivate.stayconnectedservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class StayConnectedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StayConnectedServiceApplication.class, args);
		System.out.println("Hello World!");
	}

	@Bean
	   public Docket productApi() {
	     // return new Docket(DocumentationType.SWAGGER_2).select().build();
	      return new Docket(DocumentationType.SWAGGER_2).select()
	 	         .apis(RequestHandlerSelectors.basePackage("com.clarivate.stayconnectedservice.controller")).build().apiInfo(metaData());
	   }
	 
	 
	 private ApiInfo metaData() {
			return new ApiInfoBuilder() 
	             .title("StayConnectedService")
	             .description("REST API for StayConnectedService")
	             .version("1.0.0")
	             .license("Apache License Version 2.0")
	             .build();
		}
}
