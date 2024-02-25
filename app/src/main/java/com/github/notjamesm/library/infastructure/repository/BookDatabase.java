package com.github.notjamesm.library.infastructure.repository;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import com.github.notjamesm.library.infastructure.repository.jpa.BookEntity;
import com.github.notjamesm.library.infastructure.repository.jpa.BookJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDatabase implements BookRepository {

    private final BookJpaRepository repository;

    public BookDatabase(BookJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Book> getBookById(long id) {
        final BookEntity bookEntity = repository.findBookEntityById(id);

        if (bookEntity != null) {
            return Optional.of(new Book(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getAuthor()));
        } else {
            return Optional.empty();
        }
    }
}
