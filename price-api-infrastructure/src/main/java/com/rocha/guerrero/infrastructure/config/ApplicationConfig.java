package com.rocha.guerrero.infrastructure.config;

import jakarta.inject.Singleton;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.rocha.guerrero.application",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Singleton.class)
)
public class ApplicationConfig {}
