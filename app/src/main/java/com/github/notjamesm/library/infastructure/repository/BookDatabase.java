package com.github.notjamesm.library.infastructure.repository;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDatabase implements BookRepository {

    @Autowired
    private DatabaseConfiguration databaseConfiguration;

    @Override
    public Book getBookByIdOrBlowUp(long id) {
        return null;
    }
}
