package com.palvair.java11;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientImprovements {

    public HttpResponse<String> getResponse(final String url) throws IOException, InterruptedException {
        final HttpClient httpClient = HttpClient.newBuilder()
                .build();
        final HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
