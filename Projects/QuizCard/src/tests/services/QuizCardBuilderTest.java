package tests.services;

import main.services.QuizCard;

public class QuizCardBuilderTest {
    public static void main(String[] args) {
        QuizCard quizcard = new main.services.QuizCardBuilder()
                .newQuizCard()
                .setQuestion("Which university is featured in the film \"Good Will Hunting")
                .setAnswer("M.I.T")
                .build();
        System.out.println("Question: " + quizcard.getQuestion());
        System.out.println("Answer: " + quizcard.getAnswer());
    }
}
