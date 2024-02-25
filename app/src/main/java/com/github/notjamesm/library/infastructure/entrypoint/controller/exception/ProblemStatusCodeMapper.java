package com.github.notjamesm.library.infastructure.entrypoint.controller.exception;

import com.github.notjamesm.library.domain.ProblemType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Component
public class ProblemStatusCodeMapper {

    public HttpStatus map(ProblemType problemType) {
        return switch (problemType) {
            case LOOKUP_PROBLEM -> NOT_FOUND;
        };
    }
}