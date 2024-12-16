import javax.swing.*;
import java.awt.*;


public class SimpleGui {
    public static void main(String[] args) {

        JFrame window = new JFrame("Simple Gui");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        BoxLayout vbox = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
        contentPane.setLayout(vbox);
        window.setContentPane(contentPane);

        JButton button = new JButton("click me");
        button.addActionListener(actionEvent -> {
            button.setText("button was clicked!");
            System.out.println("Hello World");
        });
        contentPane.add(button);

        window.setSize(new Dimension(400, 400));
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
