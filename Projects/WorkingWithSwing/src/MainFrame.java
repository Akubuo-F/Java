import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame(String title) {
        setTitle(title);
    }

    public void setPanel(JPanel panel) {
        this.setContentPane(panel);
    }

    public void makeVisible() {
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
