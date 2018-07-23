package com.accenture.lkm.spring.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ="com.accenture.lkm")
public class SpringWebContextConfigurator {
	
	
}



//equivalent to the Springconfiguration xml Files

