package org.catplayer.java.module.system.automatic;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class StdHttpClient {

    public static void googleIndex() throws IOException, InterruptedException {

        try (var httpClient = HttpClient.newHttpClient()) {

            var httpRequest = HttpRequest
                .newBuilder()
                .uri(URI.create("https://www.google.com"))
                .GET()
                .build();

            var responsePageText = httpClient.send(httpRequest, responseInfo -> {
                System.out.println("response status: " + responseInfo.statusCode());
                System.out.println("response headers:");
                System.out.println(responseInfo.headers());
                return HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);
            });

            System.out.println("response page: \n" + responsePageText);
        }
    }

}
