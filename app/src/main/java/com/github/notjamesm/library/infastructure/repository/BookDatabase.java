package com.github.notjamesm.library.infastructure.repository;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BookDatabase implements BookRepository {

    public static final String BOOK_LOOKUP_BY_ID_TEMPLATE = "SELECT book_id AS id, title, author FROM books WHERE book_id = %s";

    private final DataSource dataSource;
    private final DataClassRowMapper<Book> bookRowMapper;

    public BookDatabase(DataSource dataSource, DataClassRowMapper<Book> bookRowMapper) {
        this.dataSource = dataSource;
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public Book getBookByIdOrBlowUp(long id) {
        final List<Book> books = new JdbcTemplate(dataSource)
                .query(BOOK_LOOKUP_BY_ID_TEMPLATE.formatted(id), bookRowMapper);
        return books.getFirst();
    }
}
