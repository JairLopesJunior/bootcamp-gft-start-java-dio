package com.httpexemplos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetRequest {

    //private static final String URL_GET = "https://jsonplaceholder.typecode.com/posts";
    private static final String URL_GET = "http://httpbin.org/get";

    public static void main(String[] args) throws IOException, InterruptedException {
        // Cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();

        // Enviando uma solicitação
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Imprimir o conteudo recebido
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
