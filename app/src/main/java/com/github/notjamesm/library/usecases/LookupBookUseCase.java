package com.github.notjamesm.library.usecases;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.BookRepository;
import com.github.notjamesm.library.domain.Problem;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.github.notjamesm.library.domain.Problem.BOOK_NOT_FOUND_PROBLEM_FORMAT;
import static com.github.notjamesm.library.domain.Problem.lookupProblem;
import static io.vavr.control.Either.left;

@Component
public class LookupBookUseCase {

    private final BookRepository bookRepository;

    public LookupBookUseCase(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Either<Problem, Book> lookupBookById(Long id) {
        final Optional<Book> book = bookRepository.getBookById(id);

        return book.<Either<Problem, Book>>map(Either::right)
                .orElseGet(() -> left(lookupProblem(BOOK_NOT_FOUND_PROBLEM_FORMAT.formatted(id))));
    }
}
