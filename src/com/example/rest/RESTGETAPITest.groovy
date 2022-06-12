package com.example.rest

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RESTGETAPITest {

    // REST API GET call
    static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
//                .uri(new URI("https://cat-fact.herokuapp.com/facts/"))
                .uri(new URI("http://localhost:8080/students"))
                .GET()
                .build();

        println("request:"+request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        println(response.statusCode())
        println(response.body())

    }

}
