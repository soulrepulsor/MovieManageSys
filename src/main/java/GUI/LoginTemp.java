package GUI;

import UserOperation.Authentication;
import UserOperation.AuthenticationException;
import UserOperation.UserCreation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginTemp {
    private JPanel jPanel;
    private JButton loginButton;
    private JTextField usernameTextfield;
    private JPasswordField passwordTextfield;
    private CardLayout cardLayout;

    private JTextField rusernameTextfield;
    private JPasswordField rpasswordTextfield;

    private JFrame frame;

    public LoginTemp() {
        jPanel = new JPanel();
        cardLayout = new CardLayout();
        jPanel.setLayout(cardLayout);
        jPanel.setPreferredSize(new Dimension(300, 400));

        linit();
        sinit();
    }
    void run() {
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(jPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private void linit() {

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JPanel alignment = new JPanel();
        alignment.setLayout(new FlowLayout(FlowLayout.CENTER));
        alignment.add(loginLabel);

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this::setSignupButton);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this::setLoginButton);

        JLabel usernameLabel = new JLabel("Username:");
        usernameTextfield = new JTextField("", 20);
        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextfield);

        JLabel passwordLabel = new JLabel("Password:");
        passwordTextfield = new JPasswordField("", 20);
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextfield);

        JPanel container = new JPanel();
        container.setLayout(new GridLayout(4,1));
        container.add(usernamePanel);
        container.add(passwordPanel);
        container.add(loginButton);
        container.add(signupButton);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BorderLayout(5,1));
        panelTop.add(alignment, BorderLayout.NORTH);
        panelTop.add(container, BorderLayout.CENTER);

        jPanel.add("login", panelTop);
    }

    private void sinit() {
        JButton signupButton = new JButton();
        signupButton = new JButton("Register");
        signupButton.addActionListener(this::setRegisterButton);


        rusernameTextfield = new JTextField();
        rpasswordTextfield = new JPasswordField();

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        rusernameTextfield = new JTextField("", 20);
        rpasswordTextfield = new JPasswordField("", 20);
        panel.add(rusernameTextfield);
        panel.add(rpasswordTextfield);
        panel.add(signupButton);
        jPanel.add("Signup", panel);
    }

    public void setLoginButton(ActionEvent e) {
        String username = usernameTextfield.getText();
        String password = String.valueOf(passwordTextfield.getPassword());
        Authentication authentication = new Authentication(username, password);

        try {
            authentication.authenticate();
            frame.setVisible(false);
            frame.dispose();
            new MainGUI(0, username, frame);
            System.out.println("done");
        } catch (AuthenticationException ex){
            ex.printStackTrace();
        }
    }

    public void setSignupButton(ActionEvent e) {
        cardLayout.next(jPanel);
    }

    public void setRegisterButton(ActionEvent e) {
        try {
            UserCreation.InitializeNewUser(rusernameTextfield.getText(),
                    String.valueOf(rpasswordTextfield.getPassword()),
                    "something@something.com",
                    "John",
                    "Levesque");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        cardLayout.next(jPanel);
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
