package com.interest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.interest.datasource.DataSourceMaster;
import com.interest.datasource.DataSourceRainbow;

@SpringBootApplication
@EnableConfigurationProperties(value = { DataSourceMaster.class, DataSourceRainbow.class })
@MapperScan("com.interest")
public class WhSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WhSpringBootApplication.class, args);
	}
}
