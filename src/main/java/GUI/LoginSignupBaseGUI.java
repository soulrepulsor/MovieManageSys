package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * This class serves as the base configuration class for the login and Sign Up screen
 */
abstract class LoginSignupBaseGUI {
    private JPanel jPanel;
    private JFrame frame;

    LoginSignupBaseGUI(JFrame frame) {
        this.jPanel = new JPanel();
        this.jPanel.setLayout(new BorderLayout(5,1));
        this.jPanel.setPreferredSize(new Dimension(300, 400));
        this.frame = frame;
        this.frame.setResizable(false);
    }

    JPanel getjPanel() {
        return jPanel;
    }

    JFrame getFrame() {return frame;}
}
