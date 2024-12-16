package tests.api;

import com.google.gson.Gson;
import main.api.QuizCardAPI;
import main.api.endpoints.QuizCardEndPoint;
import main.services.QuizCard;
import main.services.QuizCardBuilder;
import main.services.QuizCardManager;

public class QuizCardAPITest {
    public static void main(String[] args) {
        String fileName1 = "serialized/tests/quizCardManagerTest.ser";
        String fileName2 = "serialized/client/test.ser";
        QuizCardManager quizCardManager = new QuizCardManager(fileName2);
        QuizCardEndPoint apiEndPoint = new QuizCardEndPoint(quizCardManager);
        apiEndPoint.run();

        QuizCardAPI quizCardAPI = new QuizCardAPI("authorized");
        String jsonString = quizCardAPI.getQuizCards();
        Gson gson = new Gson();
        QuizCard[] quizCards = gson.fromJson(jsonString, QuizCard[].class);
        for (QuizCard quizCard : quizCards) {
            System.out.println(quizCard.getQuestion());
            System.out.println(quizCard.getAnswer());
            System.out.println();
        }


        QuizCardBuilder quizCardBuilder = new QuizCardBuilder();
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
        String jsonString2 = gson.toJson(quizCards2);

        //quizCardAPI.addQuizCards(jsonString2);

        apiEndPoint.shutDown();
    }
}
