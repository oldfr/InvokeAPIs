package com.example.soap

import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SOAPAPITest {

    // SOAP API POST call
    static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://www.dataaccess.com/webservicesserver/NumberConversion.wso"))
                .POST(HttpRequest.BodyPublishers.ofString("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "<soap:Body>\n" +
                        "   <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\n" +
                        "       <ubiNum>516</ubiNum>\n" +
                        "   </NumberToWords>\n" +
                        "</soap:Body>\n" +
                        "</soap:Envelope>"))
                .header("Content-Type", "text/xml; charset=utf-8")
                .build();
        println("request:"+request);
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString())
        println(response.statusCode())
        println(response.body())
    }

}
