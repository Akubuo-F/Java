package tests.services;

import main.services.QuizCard;
import main.services.QuizCardBuilder;
import main.services.QuizCardManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizCardManagerTest {
    public static void main(String[] args) throws IOException {
        Map<String, String> questionsAndAnswers = new HashMap<>();
        questionsAndAnswers.put(
                "Which University is featured in the film \"Good Will Hunting?",
                "M.I.T"
        );
        questionsAndAnswers.put(
                "What is the chemical formula of water?",
                "H20"
        );
        List<QuizCard> quizCards = new ArrayList<>();
        for (Map.Entry<String, String> entry : questionsAndAnswers.entrySet()) {
            QuizCard quizCard = new QuizCardBuilder()
                    .newQuizCard()
                    .setQuestion(entry.getKey())
                    .setAnswer(entry.getValue())
                    .build();
            quizCards.add(quizCard);
        }

        String serialFilePath = "serialized/tests/quizCardManagerTest.ser";
        QuizCardManager quizCardManager = new QuizCardManager(serialFilePath);
        quizCardManager.saveAll(quizCards);
        List<QuizCard> loaded = quizCardManager.loadAll();
        for (QuizCard quizCard : loaded) {
            String formatted = "Question: " + quizCard.getQuestion() + "\n" + "Answer: "
                    + quizCard.getAnswer() + "\n";
            System.out.println(formatted);
        }
    }
}
