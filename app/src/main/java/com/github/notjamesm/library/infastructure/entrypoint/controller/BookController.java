package com.github.notjamesm.library.infastructure.entrypoint.controller;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.Problem;
import com.github.notjamesm.library.infastructure.entrypoint.controller.exception.ProblemException;
import com.github.notjamesm.library.usecases.CreateBookUseCase;
import com.github.notjamesm.library.usecases.LookupBookUseCase;
import io.vavr.control.Either;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.github.notjamesm.library.domain.Book.book;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BookController {

    private LookupBookUseCase lookupBookUseCase;
    private CreateBookUseCase createBookUseCase;

    public BookController(LookupBookUseCase lookupBookUseCase, CreateBookUseCase createBookUseCase) {
        this.lookupBookUseCase = lookupBookUseCase;
        this.createBookUseCase = createBookUseCase;
    }

    @GetMapping(value = "/api/v1/book/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> lookUpById(@PathVariable("id") Long id) {
        final Either<Problem, Book> book = lookupBookUseCase.lookupBookById(id);

        if (book.isLeft()) {
            throw new ProblemException(book.getLeft());
        }

        return ResponseEntity.ok(book.get());
    }

    @PostMapping(value = "/api/v1/book", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> createBook(@RequestBody() AddBookRequest request) {
        final Book book = createBookUseCase.createBook(book(request.title(), request.author()));
        return new ResponseEntity<>(book, CREATED);
    }
}
