package com.wee.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.configuration.SwaggerGlobalSettings;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.Principal;
import java.util.Set;

@Configuration
@EnableSwagger
public class SwaggerConfig {

    @Autowired
    private SpringSwaggerConfig springSwaggerConfig;

    @Value(value = "${info.version}")
    private String version;

    @Value(value = "${info.app.name}")
    private String name;

    @Value(value = "${info.app.description}")
    private String description;

    @Value(value = "${info.contact.email}")
    private String email;

    @Value(value = "${swagger.include.pattern}")
    private String includePatterns;


    @Bean
    public SwaggerSpringMvcPlugin customImplementation() {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
                .apiVersion(version)
                .apiInfo(getApiInfo())
                .includePatterns(includePatterns);
    }

    @Bean
    public SwaggerGlobalSettings swaggerGlobalSettings() {
        SwaggerGlobalSettings swaggerGlobalSettings = new SwaggerGlobalSettings();
        swaggerGlobalSettings.setGlobalResponseMessages(springSwaggerConfig.defaultResponseMessages());
        swaggerGlobalSettings.setIgnorableParameterTypes(getIgnorableParameterTypes());
        return swaggerGlobalSettings;
    }

    private Set<Class> getIgnorableParameterTypes() {
        Set<Class> types = springSwaggerConfig.defaultIgnorableParameterTypes();
        types.add(Principal.class);
        return types;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(name, description, "", email, "", "");
    }
}

