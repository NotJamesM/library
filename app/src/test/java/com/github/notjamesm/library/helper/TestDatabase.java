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

    public Long getBookId() {
        return jdbcTemplate.queryForObject("SELECT book_id AS id FROM books", Long.class);
    }

    public boolean containsBook(String title, String author) {
        final Long count = jdbcTemplate.queryForObject(
                "SELECT COUNT(book_id) FROM books WHERE title='%s' AND author='%s'".formatted(title, author), Long.class);
        return count == 1;
    }
}
