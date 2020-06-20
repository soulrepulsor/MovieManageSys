package GUI;

import UserOperation.Authentication;
import UserOperation.AuthenticationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login extends LoginSignupBaseGUI{
    private JTextField usernameTextfield;
    private JPasswordField passwordTextfield;

    Login(JFrame frame) {
        super(frame);
        init();
    }

    private void init() {
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JPanel alignment = new JPanel();
        alignment.setLayout(new FlowLayout(FlowLayout.CENTER));
        alignment.add(loginLabel);

        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(this::setSignupButton);

        JButton loginButton = new JButton("Login");
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

        super.getjPanel().add(alignment, BorderLayout.NORTH);
        super.getjPanel().add(container, BorderLayout.CENTER);
    }

    public void setLoginButton(ActionEvent e) {
        String username = usernameTextfield.getText().trim();
        String password = String.valueOf(passwordTextfield.getPassword()).trim();
        Authentication authentication = new Authentication(username, password);

        try {
            authentication.authenticate();
            new MainGUI(0, username, super.getFrame());
        } catch (AuthenticationException ex){
            JOptionPane.showOptionDialog(null, ex.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, null, null);
        }
    }

    public void setSignupButton(ActionEvent e) {
        new MainGUI(4, super.getFrame());
//        cardLayout.next(mainPanel);
    }
}
