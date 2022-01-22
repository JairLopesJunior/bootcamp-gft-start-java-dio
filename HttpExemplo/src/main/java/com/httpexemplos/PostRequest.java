package com.httpexemplos;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    private static final String URL_POST = "http://httpbin.org/forms/post";
    private static final String FILE_JSON = "/home/jm/IdeaProjects/HttpExample/pedido.json";

    public static void main(String[] args) throws FileNotFoundException {

        // Cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
