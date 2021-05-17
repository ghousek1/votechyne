package com.ghouse.votechyne;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class VotechyneApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotechyneApplication.class, args);
	}
    
	
	@Bean
	public Docket mySwaggerConfig() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ghouse.votechyne")).build()
				.apiInfo(mySwaggerApiInfo());
	}

	public ApiInfo mySwaggerApiInfo() {

		return new ApiInfo("Votechyne App", "Votechyne-Spring Boot Application developed by Ghouse", "v 1.0",
				"www.gouse369.com/tandc",
				new springfox.documentation.service.Contact("ghouse", "gouse369.github.io", "gouse369@gmail.com"),
				"Apache License", "apache.org/license", Collections.emptyList());

	}
}
