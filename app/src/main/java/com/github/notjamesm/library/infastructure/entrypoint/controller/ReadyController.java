package com.github.notjamesm.library.infastructure.entrypoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@RestController
public class ReadyController {

    @GetMapping(path = "/ready", produces = TEXT_PLAIN)
    public String ready() {
        return "OK";
    }
}
