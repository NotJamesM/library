package com.github.notjamesm.library.domain;

import static com.github.notjamesm.library.domain.ProblemType.LOOKUP_PROBLEM;

public record Problem(ProblemType problemType, String problemDescription) {

    public static Problem lookupProblem(String problemDescription) {
        return new Problem(LOOKUP_PROBLEM, problemDescription);
    }

    public static final String BOOK_NOT_FOUND_PROBLEM_FORMAT = "Book id '%d' could not be found.";
}
