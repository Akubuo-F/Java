import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CheckBox {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame("CheckBox");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));

        JCheckBox check = new JCheckBox("Goes to 11");
        check.setBorderPainted(false);
        check.setBorder(BorderFactory.createEmptyBorder());
        check.setMargin(new Insets(0,0,0,0));
        panel.add(check);

        mainFrame.add(panel);
        mainFrame.makeVisible();
    }
}
