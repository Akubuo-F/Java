import javax.swing.*;
import java.awt.*;

public class TextField {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("JTextField");
        JPanel panel = new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(350, 200));

        JLabel dogFirstName = new JLabel("Dog's first name:");
        panel.add(dogFirstName);
        JTextField field = new JTextField(20);
        panel.add(field);

        mainFrame.setPanel(panel);
        mainFrame.makeVisible();
    }
}
