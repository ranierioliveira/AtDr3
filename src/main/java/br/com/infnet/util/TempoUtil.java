package br.com.infnet.util;

import br.com.infnet.model.Tempo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TempoUtil {

    public Tempo getClima(double latitude, double longitude) {
        String uri = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=c8a2acd9c47f75445174eccfbfc90aec";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI(uri))
                    .version(HttpClient.Version.HTTP_2)
                    .build();
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println(response.body());
            if(response.statusCode() == 404){
                throw new br.com.infnet.exception.ResourceNotFoundException(response.body());
            }

            ObjectMapper objectMapper = new ObjectMapper();
            Tempo tempo = objectMapper.readValue(response.body(), Tempo.class);
            return tempo;
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
