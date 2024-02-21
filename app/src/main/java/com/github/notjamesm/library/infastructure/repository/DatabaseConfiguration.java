package com.github.notjamesm.library.infastructure.repository;

import com.github.notjamesm.library.domain.Book;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.DataClassRowMapper;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource getDataSource() {
        final DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        dataSourceBuilder.url(System.getenv("DATABASE_URL"));
        dataSourceBuilder.username(System.getenv("DATABASE_USERNAME"));
        dataSourceBuilder.password(System.getenv("DATABASE_PASSWORD"));
        return dataSourceBuilder.build();
    }

    @Bean
    public DataClassRowMapper<Book> bookRowMapper() {
         return new DataClassRowMapper<>(Book.class);
    }
}
