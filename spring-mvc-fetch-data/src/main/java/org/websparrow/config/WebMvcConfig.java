package org.websparrow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.websparrow.dao.EmployeeDao;
import org.websparrow.dao.EmployeeDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.websparrow.controller", "org.websparrow.dao" })
public class WebMvcConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}

	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/websparrow");
		ds.setUsername("root");
		ds.setPassword("");

		return ds;
	}

	@Bean
	public EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl(getDataSource());
	}

}