package com.github.notjamesm.library.usecases;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import com.github.notjamesm.library.domain.LookupProblem;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import static io.vavr.control.Either.right;

@Component
public class LookupBookUseCase {

    private final BookRepository bookRepository;

    public LookupBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Either<LookupProblem, Book> lookupBookById(Long id) {
        return right(bookRepository.getBookByIdOrBlowUp(id));
    }
}
