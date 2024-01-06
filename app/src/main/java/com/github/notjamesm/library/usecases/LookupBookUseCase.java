package com.github.notjamesm.library.usecases;

import com.github.notjamesm.library.domain.Book;
import com.github.notjamesm.library.domain.LookupProblem;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class LookupBookUseCase {

    public Either<LookupProblem, Book> lookupBookById(String id) {
        throw new RuntimeException("impl me");
    }
}
