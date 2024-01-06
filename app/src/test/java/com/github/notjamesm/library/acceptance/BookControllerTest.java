package com.github.notjamesm.library.acceptance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.notjamesm.library.helper.BookJsonBuilder.aBook;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void lookupBookByIdReturnsBook() throws Exception {
        mvc.perform(get("/api/v1/book/123").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(aBook()
                        .withId("1")
                        .withTitle("someTitle")
                        .withAuthor("someAuthor")
                        .toJson()
                ));
    }

}
