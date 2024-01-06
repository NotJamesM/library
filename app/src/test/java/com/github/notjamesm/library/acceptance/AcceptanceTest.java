package com.github.notjamesm.library.acceptance;

import com.github.notjamesm.library.helper.TestDatabase;
import org.junit.jupiter.api.BeforeEach;

public class AcceptanceTest {

    protected final TestDatabase testDatabase = new TestDatabase();

    @BeforeEach
    void setUp() {
        testDatabase.cleanDatabase();
    }
}
