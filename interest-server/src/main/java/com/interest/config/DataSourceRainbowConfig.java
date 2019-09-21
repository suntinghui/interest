package com.interest.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.interest.dao.rainbow", sqlSessionFactoryRef = "rainbowSqlSessionFactory")
public class DataSourceRainbowConfig {

	@Bean(name = "rainbowDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.rainbow")
	public DataSource testDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "rainbowSqlSessionFactory")
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("rainbowDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/rainbow/*.xml"));
		bean.setDataSource(dataSource);
		return bean.getObject();
	}

}
