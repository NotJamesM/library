package com.github.notjamesm.library.infastructure.entrypoint.controller.exception;

import com.github.notjamesm.library.domain.ProblemType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.HttpStatus;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.http.HttpStatus.NOT_FOUND;

class ProblemStatusCodeMapperTest {

    @ParameterizedTest
    @MethodSource(value = "problemTypeSource")
    public void shouldMapProblemTypeToStatusCode(ProblemType problemType, HttpStatus httpStatus) {
        assertThat(problemStatusCodeMapper.map(problemType)).isEqualTo(httpStatus);
    }

    private static Stream<Arguments> problemTypeSource() {
        return Stream.of(
                arguments(ProblemType.LOOKUP_PROBLEM, NOT_FOUND)
        );
    }

    private final ProblemStatusCodeMapper problemStatusCodeMapper = new ProblemStatusCodeMapper();
}