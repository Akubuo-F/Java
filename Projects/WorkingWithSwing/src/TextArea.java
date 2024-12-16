import javax.swing.*;
import java.awt.*;

public class TextArea {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("TextArea");
        Panel panel = new Panel();
        panel.setSize(new Dimension(350, 200));

        JTextArea textArea = new JTextArea(10, 20);
        //textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        panel.add(scrollPane);

        textArea.setText("Not all who are lost are wandering");
        textArea.append("\nbutton clicked");

        mainFrame.add(panel);
        mainFrame.makeVisible();
    }
}
