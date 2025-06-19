package com.pluralsight.NorthwindTradersAPI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    // We will build the BasicDataSource and store it here.
    private BasicDataSource basicDataSource;

    // This method defines the DataSource bean.
    // Spring will call this and register the DataSource in the context.
    @Bean
    public DataSource dataSource(@Value("${datasource.url}") String url) {

        String username = System.getProperty("dbUsername");
        String password = System.getProperty("dbPassword");

        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
}
