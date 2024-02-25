package com.github.notjamesm.library.helper;

public class ProblemBodyBuilder implements JsonBuilder {

    private String problemType;
    private String problemDescription;

    public static ProblemBodyBuilder anErrorResponse() {
        return new ProblemBodyBuilder();
    }

    @Override
    public String toJson() {
        return ERROR_TEMPLATE.formatted(problemType, problemDescription);
    }

    public ProblemBodyBuilder withProblemType(String problemType) {
        this.problemType = problemType;
        return this;
    }

    public ProblemBodyBuilder withProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
        return this;
    }

    private final static String ERROR_TEMPLATE = """
            {
              "problemType": %s,
              "problemDescription": "%s"
            }""";
}
