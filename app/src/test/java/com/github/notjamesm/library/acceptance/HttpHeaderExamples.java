package com.github.notjamesm.library.acceptance;

import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;

public interface HttpHeaderExamples {

    MediaType TEXT_PLAIN_UTF8 = new MediaType(MediaType.TEXT_PLAIN, StandardCharsets.UTF_8);
}
