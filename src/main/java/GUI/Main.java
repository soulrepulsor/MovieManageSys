package GUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login login = new Login();
        Search search = new Search();
        frame.setPreferredSize(new Dimension(1280, 720));

        frame.add(search.getjPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
