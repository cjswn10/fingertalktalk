package com.fingertalktalk.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@MapperScan(value="com.fingertalktalk.persistence.")
@Configuration
public class DatabaseConfig {
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource firstDataSource(){
        return DataSourceBuilder.create().build();
    }
}