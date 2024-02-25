package com.github.notjamesm.library.usecases;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CreateBookUseCase {

    private final BookRepository bookRepository;
    private final Logger applicationLogger;

    public CreateBookUseCase(BookRepository bookRepository, Logger applicationLogger) {
        this.bookRepository = bookRepository;
        this.applicationLogger = applicationLogger;
    }

    public Book createBook(Book book) {
        return bookRepository.addBook(book);
    }
}
