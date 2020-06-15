package GUI;

import UserOperation.Authentication;
import UserOperation.AuthenticationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Login {
    private JPanel jPanel;
    private JButton btn;
    private JTextField usernameTextfield;
    private JTextField passwordTextfield;
    private JPanel panelBottom;

    public Login() {
        jPanel = new JPanel();
        init();
    }

    private void init() {
        btn = new JButton("Authenticate");
        btn.addActionListener(this::btnOnClicked);
        usernameTextfield = new JTextField("", 20);
        passwordTextfield = new JTextField("", 20);
        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout());
        panelTop.add(usernameTextfield);
        panelTop.add(passwordTextfield);
        panelTop.add(btn);

        panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout());

        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.add(panelTop);
        jPanel.add(panelBottom);

    }

    public void btnOnClicked(ActionEvent e) {
        Authentication authentication = new Authentication(
                usernameTextfield.getText(), passwordTextfield.getText());

        try {
            authentication.authenticate();
        } catch (AuthenticationException ex){
            ex.printStackTrace();
        }
    }


    public JPanel getjPanel() {
        return jPanel;
    }
}
