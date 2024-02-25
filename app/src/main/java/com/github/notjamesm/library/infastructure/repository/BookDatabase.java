package com.github.notjamesm.library.infastructure.repository;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookDatabase implements BookRepository {

    private final BookJpaRepository repository;

    public BookDatabase(BookJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book getBookByIdOrBlowUp(long id) {
        BookEntity bookEntity = repository.findBookEntityById(id);
        return new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor());
    }
}
