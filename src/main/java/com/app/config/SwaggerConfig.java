package com.app.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("User Api")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.app.controller"))
				.paths(regex("/api.*"))
				.build().apiInfo(metaData());
	}
	
	@Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Admin Api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.app.controller"))
                .paths(regex("/admin-api.*"))
                .build().apiInfo(metaData());
              
    }
	

	private ApiInfo metaData() {
		//String name, String url, String email
		 Contact contact= new Contact("Vishnu Awasthi", "https://www.linkedin.com/in/vishnu-awasthi-36099b77/", "Vishnuawasthi121@gmail.com");
		
		 /**
	  String title,
      String description,
      String version,
      String termsOfServiceUrl,
      Contact contact,
      String license,
      String licenseUrl,
       */
		 ApiInfo apiInfo = new ApiInfo(
				 "Ogive Services",
				 "Api to manage day to day operation on system",
				 "1.0",
				 "http://localhost:8090/ogive-services",
				 contact,
				 "Private Source",
				 "N/A");
		 return apiInfo;
		 
	 }
}
