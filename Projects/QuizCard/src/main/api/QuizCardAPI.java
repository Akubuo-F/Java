package main.api;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuizCardAPI {
    private final String secret;

    public QuizCardAPI(String secret) {
        this.secret = secret;
    }

    public String getQuizCards() {
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(new URI("Http://localhost:4567/api.quizcard"))
                    .header("Authorization", secret)
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Status Code: " + response.statusCode());
                return response.body();
            } else {
                System.err.println(
                        "Failed to add quiz cards." + "\n" + "Status Code: " + response.statusCode() +
                            "Message: " + response.body()
                );
                return null;
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.err.println("Failed to Communicate with API");
            System.err.println("Error Details: " + e.getMessage());
            return null;
        }
    }

    public void addQuizCards(String jsonString) {
        try {
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .uri(new URI("Http://localhost:4567/api.quizcard"))
                    .header("Authorization", secret)
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 401) {
                System.err.println(
                        "Failed to add quiz cards." + "\n" + "Status Code: " + response.statusCode() +
                            "Message: " + response.body()
                );
            } else {
                System.out.println("Status Code: " + response.statusCode());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            System.err.println("Failed to Communicate with API");
            System.err.println("Error Details: " + e.getMessage());
        }
    }
}
