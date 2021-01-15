package com.palvair;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

class HttpClientImprovementsTest {

    @Test
    public void should_return_response_from_server() throws IOException, InterruptedException {
        final HttpResponse<String> response = new HttpClientImprovements().getResponse("http://www.google.com");

        assertThat(response).isNotNull()
                .extracting(HttpResponse::statusCode)
                .isEqualTo(200);
    }
}