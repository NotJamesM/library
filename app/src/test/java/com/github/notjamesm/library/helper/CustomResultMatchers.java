package com.github.notjamesm.library.helper;

import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class CustomResultMatchers {

    public static ResultMatcher bodyAsJson(BookJsonBuilder bookJsonBuilder) {
        return content().json(bookJsonBuilder.toJson());
    }
}
