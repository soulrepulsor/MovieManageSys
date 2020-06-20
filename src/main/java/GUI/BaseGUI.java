package GUI;

import UserOperation.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class BaseGUI {
    private JFrame frame;
    private JPanel jPanel;
    private UserController userController;

    BaseGUI(JFrame frame, UserController userController) {
        this.frame = frame;
        this.frame.setResizable(true);
        jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(800, 600));
        jPanel.setLayout(new BorderLayout(5, 5));
        jPanel.add(new JPanel(), BorderLayout.EAST);
        jPanel.add(new JPanel(), BorderLayout.SOUTH);
        this.userController = userController;
        initSideGUI();
    }

    JPanel getjPanel() {
        return jPanel;
    }

    JFrame getFrame() {
        return frame;
    }

    public UserController getUserController() {
        return userController;
    }

    private void initSideGUI() {
        JPanel side = new JPanel();
        side.setLayout(new GridLayout(0, 1, 5, 5));
        JButton mainButton = new JButton("Search");
        JButton userButton = new JButton("User Info");
        JButton logoutButton = new JButton("Logout");
        side.add(mainButton);
        side.add(userButton);
        side.add(logoutButton);

        mainButton.addActionListener(this::setMainButton);
        userButton.addActionListener(this::setUserButton);
        logoutButton.addActionListener(this::setLogoutButton);

        jPanel.add(side, BorderLayout.WEST);
    }

    void setMainButton(ActionEvent e){}
    void setUserButton(ActionEvent e){}

    void setLogoutButton(ActionEvent e) {
        new MainGUI(3, (UserController) null, frame);
    }

}
