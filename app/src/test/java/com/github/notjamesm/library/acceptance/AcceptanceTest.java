package com.github.notjamesm.library.acceptance;

import com.github.notjamesm.library.helper.TestDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class AcceptanceTest implements HttpHeaderExamples {

    @Autowired
    protected MockMvc mvc;
    protected final TestDatabase testDatabase = new TestDatabase();

    @BeforeEach
    void setUp() {
        testDatabase.cleanDatabase();
    }
}
