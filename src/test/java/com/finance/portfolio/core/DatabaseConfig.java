package com.finance.portfolio.core;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Value("spring.datasource.url")
    public String url;

    @Value("spring.datasource.username")
    public String username;

    @Value("spring.datasource.password")
    public String password;

    @Bean
    public Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
