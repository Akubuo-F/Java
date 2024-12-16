package main.client;

import com.google.gson.Gson;
import main.api.QuizCardAPI;
import main.api.endpoints.QuizCardEndPoint;
import main.services.QuizCard;
import main.services.QuizCardBuilder;
import main.services.QuizCardManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizCardBuilderUI {
    private final List<Map<String, String>> cardList = new ArrayList<>();
    private JTextArea question;
    private JTextArea answer;
    private JFrame frame;

    public void run() {
        // build and display the UI
        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        question = createTextArea(bigFont);
        JScrollPane questionScroller = createScroller(question);
        answer = createTextArea(bigFont);
        JScrollPane answerScroller = createScroller(answer);

        mainPanel.add(createCenteredComponent(new JLabel("Question: ")));
        mainPanel.add(questionScroller);
        mainPanel.add(createCenteredComponent(new JLabel("Answer: ")));
        mainPanel.add(answerScroller);

        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(e -> nextCard());
        JPanel centeredNextButton = createCenteredComponent(nextButton);
        centeredNextButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        mainPanel.add(createCenteredComponent(centeredNextButton));

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        frame.setSize(500, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
        fileMenu.add(createMenuItem("New", this::clearAll));
        fileMenu.add(createMenuItem("Save", this::saveCard));
        return fileMenu;
    }

    private JMenuItem createMenuItem(String text, Runnable actionToBePerformed) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(e -> actionToBePerformed.run());
        return menuItem;
    }

    private JPanel createCenteredComponent(Component componentToCenter) {
        JPanel labelPanel = new JPanel();
        var horizontalGlue = Box.createHorizontalGlue();
        labelPanel.add(horizontalGlue);
        labelPanel.add(componentToCenter);
        labelPanel.add(horizontalGlue);
        return labelPanel;
    }

    private JScrollPane createScroller(JTextArea textArea) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    private JTextArea createTextArea(Font font) {
        JTextArea textArea = new JTextArea(6, 20);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(font);
        return textArea;
    }

    private void nextCard() {
        Map<String, String> map = new HashMap<>();
        String questionText = question.getText();
        String answerText = answer.getText();
        if (!(questionText.isEmpty() || answerText.isEmpty())) {
            map.put("question", questionText);
            map.put("answer", answerText);
            cardList.add(map);
            clearTextAreas();
        }
    }

    private void saveCard() {
        // bring up the file dialog
        // let the user, name and save the list of cards
        // sends cards over to server to be saved
        nextCard();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(".ser", ".ser"));
        fileChooser.showSaveDialog(frame);
        File file = fileChooser.getSelectedFile();
        String fileName = file.getName();
        if (!fileName.endsWith(".ser")) {
            fileName = fileName.split("\\.")[0] + ".ser";
        }
        fileName = "serialized/client/" + fileName;
        QuizCardEndPoint quizCardEndPoint = new QuizCardEndPoint(new QuizCardManager(fileName));
        quizCardEndPoint.run();
        QuizCardAPI quizCardAPI = new QuizCardAPI("authorized");
        List<QuizCard> quizCards = cardList.stream()
                .map(val -> new QuizCardBuilder()
                        .newQuizCard()
                        .setQuestion(val.get("question"))
                        .setAnswer(val.get("answer"))
                        .build()
                ).toList();
        String jSonString = new Gson().toJson(quizCards);
        quizCardAPI.addQuizCards(jSonString);
        quizCardEndPoint.shutDown();
    }

    private void clearTextAreas() {
        question.setText("");
        answer.setText("");
    }

    private void clearAll() {
        clearTextAreas();
        cardList.clear();
    }
}
