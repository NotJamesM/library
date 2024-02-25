package com.github.notjamesm.library.acceptance.business;

import com.github.notjamesm.library.acceptance.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static com.github.notjamesm.library.helper.BookJsonBuilder.aBook;
import static com.github.notjamesm.library.helper.CustomResultMatchers.bodyAsJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class BookControllerTest extends AcceptanceTest {

    @Test
    public void lookupBookByIdReturnsBook() throws Exception {
        givenDatabaseContainsABook();

        mvc.perform(get("/api/v1/book/%s".formatted(bookId)).accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(bodyAsJson(aBook()
                        .withId(bookId)
                        .withTitle(A_BOOK_TITLE)
                        .withAuthor(A_BOOK_AUTHOR)));
    }

    @Test
    void bookCreation() throws Exception {
        mvc.perform(post("/api/v1/book").contentType(APPLICATION_JSON).content("""
                        {"author":"Kenneth Grahame", "title":"The Wind in the Willows"}"""))
                .andExpect(status().isCreated())
                .andExpect(bodyAsJson(aBook()
                        .withId(testDatabase::getBookId)
                        .withTitle(A_BOOK_TITLE)
                        .withAuthor(A_BOOK_AUTHOR)));

        assertThat(testDatabase.containsBook(A_BOOK_TITLE, A_BOOK_AUTHOR)).isTrue();
    }

    private void givenDatabaseContainsABook() {
        bookId = testDatabase.addBook(A_BOOK_TITLE, A_BOOK_AUTHOR).longValue();
    }

    private long bookId;

}
