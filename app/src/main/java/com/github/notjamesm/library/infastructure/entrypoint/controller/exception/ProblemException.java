package com.github.notjamesm.library.infastructure.entrypoint.controller.exception;

import com.github.notjamesm.library.domain.Problem;

public class ProblemException extends RuntimeException {
    private final Problem problem;

    public ProblemException(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }
}
