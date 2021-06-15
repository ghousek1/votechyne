package com.ghouse.votechyne.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket mySwaggerConfig() {

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ghouse.votechyne")).build().apiInfo(mySwaggerApiInfo());
	}

	public ApiInfo mySwaggerApiInfo() {

		return new ApiInfo("Votechyne App", "Votechyne-Spring Boot Application developed by Ghouse", "v 1.0",
				"www.gouse369.com/tandc",
				new springfox.documentation.service.Contact("ghouse", "gouse369.github.io", "gouse369@gmail.com"),
				"OpenSource License", "opensource.org/license", Collections.emptyList());

	}

}
