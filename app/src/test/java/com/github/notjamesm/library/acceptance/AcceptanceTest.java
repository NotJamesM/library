package com.github.notjamesm.library.acceptance;

import com.github.notjamesm.library.helper.TestDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AcceptanceTest implements HttpHeaderExamples, BookExamples {

    @Autowired
    protected MockMvc mvc;
    protected final TestDatabase testDatabase = new TestDatabase();

    @BeforeEach
    void setUp() {
        testDatabase.cleanDatabase();
    }
}
