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
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.interest.dao.master", sqlSessionFactoryRef = "masterSqlSessionFactory")
public class DataSourceMasterConfig {

	/**
	 * 生成数据源. @Primary 注解声明为默认数据源
	 */
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	@Primary
	public DataSource testDataSource() {
		
		DataSource ds = DataSourceBuilder.create().build();
		return ds;
	}

	/**
	 * 创建 SqlSessionFactory
	 */
	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/master/*.xml"));
		bean.setDataSource(dataSource);
		SqlSessionFactory ssf = bean.getObject();
		return ssf;
	}

}
