package com.myapp.airlines.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component

public class MyConfig {

	@Bean

	public DataSource dataSource() {

		HikariDataSource dataSource = new HikariDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/airlines");

		dataSource.setUsername("root");

		dataSource.setPassword("root");

		return dataSource;

	}

}