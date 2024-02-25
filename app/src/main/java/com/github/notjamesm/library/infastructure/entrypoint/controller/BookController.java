package com.github.notjamesm.library.infastructure.entrypoint.controller;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.Problem;
import com.github.notjamesm.library.infastructure.entrypoint.controller.exception.ProblemException;
import com.github.notjamesm.library.usecases.LookupBookUseCase;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BookController {

    @Autowired
    private LookupBookUseCase lookupBookUseCase;

    @GetMapping(value = "/api/v1/book/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> lookUpById(@PathVariable("id") Long id) {
        final Either<Problem, Book> book = lookupBookUseCase.lookupBookById(id);

        if (book.isLeft()) {
            throw new ProblemException(book.getLeft());
        }

        return ResponseEntity.ok(book.get());
    }
}
