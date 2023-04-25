package com.example.rest

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RESTDELETEAPITest {

    // REST API DELETE call
    static void main(String[] args) {
        // calling API that deletes the student record with id=2
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/students?Id=2"))
                .DELETE()
                .build();

        println("request:" + request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        println(response.statusCode())
        println(response.body())
    }
}
