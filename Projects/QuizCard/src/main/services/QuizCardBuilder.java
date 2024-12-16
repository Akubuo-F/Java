package main.services;

public class QuizCardBuilder {

    private static QuizCard quizCard = new QuizCard();

    public QuizCardBuilder() {}

    public QuizCardBuilder newQuizCard () {
        quizCard = new QuizCard();
        return this;
    }

    public QuizCardBuilder setQuestion(String question) {
        quizCard.setQuestion(question);
        return this;
    }

    public QuizCardBuilder setAnswer(String answer) {
        quizCard.setAnswer(answer);
        return this;
    }

    public QuizCard build() {
        return quizCard;
    }
}
