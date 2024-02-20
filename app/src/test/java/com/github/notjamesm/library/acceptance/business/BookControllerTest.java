package com.github.notjamesm.library.acceptance.business;

import com.github.notjamesm.library.acceptance.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static com.github.notjamesm.library.helper.BookJsonBuilder.aBook;
import static com.github.notjamesm.library.helper.CustomResultMatchers.bodyAsJson;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest extends AcceptanceTest {

    @Test
    public void lookupBookByIdReturnsBook() throws Exception {
        givenDatabaseContainsBook();

        mvc.perform(get("/api/v1/book/%s".formatted(bookId)).accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(bodyAsJson(aBook()
                        .withId(bookId)
                        .withTitle("someTitle")
                        .withAuthor("someAuthor")));
    }

    private void givenDatabaseContainsBook() {
        bookId = testDatabase.addBook("someTitle", "someAuthor").longValue();
    }

    private long bookId;

}
