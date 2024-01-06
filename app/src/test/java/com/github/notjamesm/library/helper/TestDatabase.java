package com.github.notjamesm.library.helper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Map;

public class TestDatabase {

    private final JdbcTemplate jdbcTemplate;

    public TestDatabase() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "password"
        );
        jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
    }

    public void cleanDatabase() {
        jdbcTemplate.execute("TRUNCATE books");
    }

    public Number addBook(String title, String author) {
        return new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("books")
                .usingColumns("title", "author")
                .usingGeneratedKeyColumns("book_id")
                .executeAndReturnKey(Map.of("title", title, "author", author));
    }
}
