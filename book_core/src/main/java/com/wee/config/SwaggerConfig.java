package com.wee.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value(value = "${info.version}")
    private String version;

    @Value(value = "${info.app.name}")
    private String name;

    @Value(value = "${info.app.description}")
    private String description;

    @Value(value = "${info.contact.email}")
    private String email;

    @Value(value = "${info.contact.author}")
    private String author;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wee.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact(author, "", email);
        return new ApiInfo(name, description, version, "Terms of service", contact, "", "");
    }
}

