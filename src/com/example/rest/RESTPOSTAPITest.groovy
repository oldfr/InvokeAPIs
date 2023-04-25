package com.example.rest

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class RESTPOSTAPITest {

    // SOAP API POST call
    static void main(String[] args) {
        // calling API that creates a new student record
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/students"))
                .POST(HttpRequest.BodyPublishers.ofString("{\n" +
                        "    \"studentName\":\"Vivek\",\n" +
                        "    \"studentAge\":\"27\",\n" +
                        "    \"address\":\"Gurgaon\"\n" +
                        "\n" +
                        "}"))
                .header("Content-Type","application/json")
                .build();

        println("request:"+request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        println(response.statusCode())
        println(response.body())
    }
}
