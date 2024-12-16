package main.api.endpoints;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import main.services.QuizCard;
import main.services.QuizCardManager;
import spark.Spark;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class QuizCardEndPoint {
    private final QuizCardManager quizCardManager;

    public QuizCardEndPoint(QuizCardManager quizCardManager) {
        this.quizCardManager = quizCardManager;
    }

    public void run() {
        Gson gson = new Gson();

        get("/api.quizcard", ((request, response) -> {
            String secrete = request.headers("authorization");
            if (!Authenticator.authenticate(secrete)) {
                response.status(401);
                return "Unauthorized";
            }

            List<QuizCard> quizCards = quizCardManager.loadAll();
            String jsonString = gson.toJson(quizCards);

            response.status(200);
            response.type("application/json");
            return jsonString;
        }));

        post("/api.quizcard", ((request, response) -> {
            String secret = request.headers("Authorization");
            if (!Authenticator.authenticate(secret)) {
                response.status(401);
                return "Unauthorized";
            }

            QuizCard[] quizCards = gson.fromJson(request.body(), QuizCard[].class);
            try {
                quizCardManager.saveAll(Arrays.asList(quizCards));
            } catch (IOException e) {
                response.status(401);
                return "Failed";
            }

            response.status(201);
            return "Success";
        }));
    }

    public void shutDown() {
        Spark.stop();
    }
}
