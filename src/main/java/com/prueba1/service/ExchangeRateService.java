
package com.prueba1.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExchangeRateService {                                   //esta es la clase que se encarga de conectarse a la API de Frankfurter y obtener el tipo de cambio actual entre EUR y USD

    private static final String API_URL =
            "https://api.frankfurter.dev/v2/rate/eur/usd";           //esta es la url de la API Frankfurter

    private final HttpClient client;
    private final ObjectMapper mapper;

    public ExchangeRateService() {
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        this.mapper = new ObjectMapper();
    }

    public ExchangeRate getExchangeRate()
            throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        if (response.statusCode() != 200) {
            throw new IOException(
                    "Error obtaining exchange rate: "
                    + response.statusCode()
            );
        }

        JsonNode json = mapper.readTree(response.body());

        double rate = json.get("rate").asDouble();
        LocalDate date = LocalDate.parse(
                json.get("date").asText()
        );

        return new ExchangeRate(rate, date);
    }

    public record ExchangeRate(double rate, LocalDate date) {
    }
}