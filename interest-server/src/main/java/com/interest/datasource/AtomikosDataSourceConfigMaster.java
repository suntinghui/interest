package com.interest.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.mysql.cj.jdbc.MysqlXADataSource;

@Configuration
@MapperScan(basePackages = "com.interest.dao.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class AtomikosDataSourceConfigMaster {

	@Primary
	@Bean(name = "masterDataSource")
	public DataSource masterDataSource(DataSourceMaster ds) throws SQLException {
		MysqlXADataSource mysqlxadatasource = new MysqlXADataSource();
		mysqlxadatasource.setUrl(ds.getUrl());
		mysqlxadatasource.setPassword(ds.getPassword());
		mysqlxadatasource.setUser(ds.getUsername());
		mysqlxadatasource.setPinGlobalTxToPhysicalConnection(true);
		
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlxadatasource);
		xaDataSource.setUniqueResourceName("masterDataSource");
		return xaDataSource;
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource datasource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		// https://blog.csdn.net/qq_30616169/article/details/83184808
		bean.setVfs(SpringBootVFS.class);//设置SpringBootVFS
        bean.setTypeAliasesPackage("com.interest.model");
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/master/*.xml"));
		return bean.getObject();
	}

	@Bean("masterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate mastersqlsessiontemplate(
			@Qualifier("masterSqlSessionFactory") SqlSessionFactory sessionfactory) {
		return new SqlSessionTemplate(sessionfactory);
	}

}
