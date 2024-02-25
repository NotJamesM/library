package com.github.notjamesm.library.domain;

import java.util.Optional;

public interface BookRepository {

    Optional<Book> getBookById(long id);

    Book addBook(Book book);
}
