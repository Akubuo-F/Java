package tests.api.endpoints;

import com.google.gson.Gson;
import main.api.endpoints.QuizCardEndPoint;
import main.services.QuizCard;
import main.services.QuizCardBuilder;
import main.services.QuizCardManager;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuizCardEndPointTest {
    public static void main(String[] args) {
        QuizCardBuilder quizCardBuilder = new QuizCardBuilder();

        String serialFilePath = "serialized/tests/quizCardManagerTest.ser";
        QuizCardManager quizCardManager = new QuizCardManager(serialFilePath);

        QuizCardEndPoint endpoint = new QuizCardEndPoint(quizCardManager);
        endpoint.run();
        try {
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:4567/api.quizcard"))
                    .header("Authorization", "authorized")
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Status body: " + response.body());

            Gson gson = new Gson();
            QuizCard[] quizCards = gson.fromJson(response.body(), QuizCard[].class);
            for (QuizCard quizCard : quizCards) {
                System.out.println("Loaded Question: " + quizCard.getQuestion());
                System.out.println("Loaded Answer: " + quizCard.getAnswer());
            }

            QuizCard quizCard1 = quizCardBuilder
                    .newQuizCard()
                    .setQuestion("What is the capital of France?")
                    .setAnswer("Paris")
                    .build();
            QuizCard quizCard2 = quizCardBuilder
                    .newQuizCard()
                    .setQuestion("What is 2 + 2?")
                    .setAnswer("4")
                    .build();
            QuizCard[] quizCards2 = new QuizCard[] {quizCard1, quizCard2};
            String jsonString = gson.toJson(quizCards2);
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(new URI("http://localhost:4567/api.quizcard"))
                    .header("Authorization", "authorized")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            HttpClient client2 = HttpClient.newHttpClient();
            HttpResponse<String> response2 = client2.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status code: " + response2.statusCode());
            System.out.println("Status body: " + response2.body());

        } catch (URISyntaxException | IOException | InterruptedException | IllegalStateException e) {
            System.err.println("Failed to Communicate with API");
            System.err.println("Error details: " + e.getMessage());
        } finally {
            endpoint.shutDown();
        }
    }
}
