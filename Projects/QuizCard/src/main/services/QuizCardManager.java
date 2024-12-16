package main.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuizCardManager {
    private final String serialFilePath;

    public QuizCardManager(String serialFilePath) throws IllegalArgumentException {
        if (!serialFilePath.endsWith(".ser")) {
            throw new IllegalArgumentException("serialFilePath must end with .ser extension");
        }
        this.serialFilePath = serialFilePath;
    }

    public void saveAll (List<QuizCard> quizCards) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(serialFilePath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (QuizCard quizCard : quizCards) {
                objectOutputStream.writeObject(quizCard);
            }
        } catch (IOException e) {
            System.err.println("Failed to save QuizCards");
            System.err.println("Error details: " + e.getMessage());
            throw e;
        }

    }

    public List<QuizCard> loadAll () {
        List<QuizCard> quizCards = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(serialFilePath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            while (true) {
                try {
                    QuizCard quizCard = (QuizCard) objectInputStream.readObject();
                    quizCards.add(quizCard);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load QuizCards");
            System.err.println("Error details: " + e.getMessage());
            e.printStackTrace();
        }
        return quizCards;
    }
}
