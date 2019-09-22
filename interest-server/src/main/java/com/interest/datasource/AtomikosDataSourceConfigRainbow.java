package com.interest.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.cj.jdbc.MysqlXADataSource;


@Configuration
@MapperScan(basePackages = "com.interest.dao.rainbow", sqlSessionTemplateRef = "rainbowSqlSessionTemplate")
public class AtomikosDataSourceConfigRainbow {

	@Bean(name = "rainbowDataSource")
	public DataSource rainbowDataSource(DataSourceRainbow ds) throws SQLException {
		MysqlXADataSource mysqlxadatasource = new MysqlXADataSource();
		mysqlxadatasource.setUrl(ds.getUrl());
		mysqlxadatasource.setPassword(ds.getPassword());
		mysqlxadatasource.setUser(ds.getUsername());
		mysqlxadatasource.setPinGlobalTxToPhysicalConnection(true);
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlxadatasource);
		xaDataSource.setUniqueResourceName("rainbowDataSource");
		return xaDataSource;
	}

	@Bean(name = "rainbowSqlSessionFactory")
	public SqlSessionFactory rainbowSqlSessionFactory(@Qualifier("rainbowDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setVfs(SpringBootVFS.class);//设置SpringBootVFS
        bean.setTypeAliasesPackage("com.interest.model");
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/rainbow/*.xml"));
		return bean.getObject();
	}

	@Bean("rainbowSqlSessionTemplate")
	public SqlSessionTemplate rainbowsqlsessiontemplate(
			@Qualifier("rainbowSqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}

}
