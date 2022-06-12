package com.example.rest

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RESTPUTAPITest {

    // REST API PUT call
    static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/students?Address=Mumbai&Id=3"))
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();

        println("request:" + request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        println(response.statusCode())
        println(response.body())
    }
}
