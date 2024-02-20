package com.github.notjamesm.library.acceptance.business;

import com.github.notjamesm.library.acceptance.AcceptanceTest;
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
class BookControllerTest extends AcceptanceTest {

    @Autowired
    private MockMvc mvc;
    private long bookId;

    @Test
    public void lookupBookByIdReturnsBook() throws Exception {
        givenDatabaseContainsBook();

        mvc.perform(get("/api/v1/book/%s".formatted(bookId)).accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(aBook()
                        .withId(bookId)
                        .withTitle("someTitle")
                        .withAuthor("someAuthor")
                        .toJson()
                ));
    }

    private void givenDatabaseContainsBook() {
        bookId = testDatabase.addBook("someTitle", "someAuthor").longValue();
    }

}
