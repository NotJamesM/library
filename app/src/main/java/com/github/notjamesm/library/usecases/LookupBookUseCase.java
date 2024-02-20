package com.github.notjamesm.library.usecases;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import com.github.notjamesm.library.domain.LookupProblem;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.vavr.control.Either.right;
import static java.lang.Long.parseLong;

@Component
public class LookupBookUseCase {

    @Autowired
    private BookRepository bookRepository;

    public Either<LookupProblem, Book> lookupBookById(String id) {
        return right(bookRepository.getBookByIdOrBlowUp(parseLong(id)));
    }
}
