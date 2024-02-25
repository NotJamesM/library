package com.github.notjamesm.library.infastructure.entrypoint.controller.exception;

import com.github.notjamesm.library.domain.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    private final ProblemStatusCodeMapper problemStatusCodeMapper;

    public ControllerExceptionHandler(ProblemStatusCodeMapper problemStatusCodeMapper) {
        this.problemStatusCodeMapper = problemStatusCodeMapper;
    }

    @ExceptionHandler(ProblemException.class)
    public ResponseEntity<Problem> handleException(ProblemException exception) {
        var status = problemStatusCodeMapper.map(exception.getProblem().problemType());
        return ResponseEntity.status(status).body(exception.getProblem());
    }

}
