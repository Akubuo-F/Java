package main.services;

import java.io.Serial;
import java.io.Serializable;
import java.security.Key;
import java.util.Map;

public class QuizCard implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String question;
    private String answer;

    QuizCard() {}

    QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
