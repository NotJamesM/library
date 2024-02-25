package com.github.notjamesm.library.infastructure.entrypoint.controller.exception;

import com.github.notjamesm.library.domain.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ProblemException.class)
    public ResponseEntity<Problem> handleException(ProblemException exception) {
        return ResponseEntity.status(getStatusForProblem(exception.getProblem())).body(exception.getProblem());
    }

    private static int getStatusForProblem(Problem problem) {
        return switch (problem.problemType()) {
            case LOOKUP_PROBLEM -> 404;
        };
    }
}
