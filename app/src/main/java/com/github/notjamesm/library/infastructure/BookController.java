package com.github.notjamesm.library.infastructure;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.LookupProblem;
import com.github.notjamesm.library.usecases.LookupBookUseCase;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class BookController {

    @Autowired
    private LookupBookUseCase lookupBookUseCase;

    @GetMapping(value = "/api/v1/book/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Book lookUpById(@PathVariable("id") String id) {
        final Either<LookupProblem, Book> lookup = lookupBookUseCase.lookupBookById(id);

        return lookup.get();
    }
}
