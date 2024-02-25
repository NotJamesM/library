package com.github.notjamesm.library.helper;

import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class CustomResultMatchers {

    public static ResultMatcher bodyAsJson(JsonBuilder jsonBuilder) {
        return content().json(jsonBuilder.toJson());
    }
}
