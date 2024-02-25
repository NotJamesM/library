package com.github.notjamesm.library.acceptance.business;

import com.github.notjamesm.library.acceptance.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static com.github.notjamesm.library.helper.CustomResultMatchers.bodyAsJson;
import static com.github.notjamesm.library.helper.ProblemBodyBuilder.anErrorResponse;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class BookControllerSadPathTest extends AcceptanceTest {

    @Test
    public void lookupBookByIdReturnsBook() throws Exception {
        givenDatabaseDoesNotContainABook();

        mvc.perform(get("/api/v1/book/5").accept(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(bodyAsJson(anErrorResponse()
                        .withProblemType("LOOKUP_PROBLEM")
                        .withProblemDescription("Book id '5' could not be found.")));
    }

    private void givenDatabaseDoesNotContainABook() { }

}
