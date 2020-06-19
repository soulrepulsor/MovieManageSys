package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login login = new Login();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        MainGUI mainGUI = new MainGUI();
//        frame.setPreferredSize(new Dimension(1280, 720));
//u
//        frame.add(mainGUI.getjPanel());
//        frame.pack();
//        frame.setVisible(true);
        login.run();
    }
}
