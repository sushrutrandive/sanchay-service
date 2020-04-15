package com.planner.calc.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

import com.planner.calc.service.prop.config.AppSql;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(AppSql.class)
public class PlannerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlannerServiceApplication.class, args);
	}

}
