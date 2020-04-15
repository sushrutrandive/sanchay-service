package com.planner.calc.service.prop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "app.sql")
public class AppSql {
	private final StaticResources staticResources = new StaticResources();
	private final User user = new User();
	private final Family family= new Family();	
	private final Income income= new Income();
	private final Expense expense= new Expense();
	public StaticResources getStaticResources() {
		return staticResources;
	}
	public User getUser() {
		return user;
	}
	public Family getFamily() {
		return family;
	}
	public Income getIncome() {
		return income;
	}
	public Expense getExpense() {
		return expense;
	}
	
	
	

}

