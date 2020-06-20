package GUI;

import Algorithm.Algorithm;
import UserOperation.Authentication;
import UserOperation.UserCreation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class Signup extends LoginSignupBaseGUI {
    private JTextField usernameTextfield;
    private JTextField usernameConfirm;
    private JPasswordField passwordTextfield;
    private JPasswordField passwordConfirm;
    private JTextField emailTextfield;
    private JTextField emailConfirm;
    private JTextField firstTextfield;
    private JTextField lastTextfield;

    Signup(JFrame frame) {
        super(frame);
        init();
    }

    private void init() {
        JLabel registerLabel = new JLabel("Register");
        registerLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JPanel alignment = new JPanel();
        alignment.setLayout(new FlowLayout(FlowLayout.CENTER));
        alignment.add(registerLabel);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(this::setRegisterButton);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(this::setLoginButton);

        JLabel firstLabel = new JLabel("First Name:");
        firstTextfield = new JTextField("", 20);

        JLabel lastLabel = new JLabel("Last Name:");
        lastTextfield = new JTextField("", 20);

        JLabel usernameLabel = new JLabel("Username:");
        usernameTextfield = new JTextField("", 20);
        JLabel usernameConfirmLabel = new JLabel("Confirm Username:");
        usernameConfirm = new JTextField("", 20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordTextfield = new JPasswordField("", 20);

        JLabel passwordConfirmLabel = new JLabel("Confirm Password:");
        passwordConfirm = new JPasswordField("", 20);

        JLabel emailLabel = new JLabel("Email:");
        emailTextfield = new JTextField("", 20);

        JLabel emailConfirmLabel = new JLabel("Confirm Email:");
        emailConfirm = new JTextField("", 20);

        LinkedList<Component> components = new LinkedList<>();
        components.add(firstLabel);
        components.add(firstTextfield);
        components.add(lastLabel);
        components.add(lastTextfield);
        components.add(usernameLabel);
        components.add(usernameTextfield);
        components.add(usernameConfirmLabel);
        components.add(usernameConfirm);
        components.add(passwordLabel);
        components.add(passwordTextfield);
        components.add(passwordConfirmLabel);
        components.add(passwordConfirm);
        components.add(emailLabel);
        components.add(emailTextfield);
        components.add(emailConfirmLabel);
        components.add(emailConfirm);

        JPanel panel = initPanel(components);
        SpringUtilities.makeCompactGrid(panel, 8, 2, 0, 0, 10, 10);

        JPanel buttonPanel = new JPanel(new GridLayout(2,1,0,5));
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        JPanel container = new JPanel();
        container.setLayout(new BorderLayout(5,1));
        container.add(panel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        super.getjPanel().add(new JPanel(), BorderLayout.WEST);
        super.getjPanel().add(new JPanel(), BorderLayout.EAST);
        super.getjPanel().add(new JPanel(), BorderLayout.SOUTH);
        super.getjPanel().add(alignment, BorderLayout.NORTH);
        super.getjPanel().add(container, BorderLayout.CENTER);

    }

    private JPanel initPanel(LinkedList<Component> objects) {
        JPanel panel = new JPanel(new SpringLayout());
        while (!objects.isEmpty()) {
            panel.add(objects.pop());
        }
        return panel;
    }

    private void setRegisterButton(ActionEvent e) {
        String username = usernameTextfield.getText().trim();
        String password = String.valueOf(passwordTextfield.getPassword()).trim();
        String email = emailTextfield.getText().trim();
        String firstName = firstTextfield.getText().trim();
        String lastName = lastTextfield.getText().trim();

        Authentication authentication =
                new Authentication(username, password);

        try {
            Algorithm.registerFormCheck(
                    username,
                    usernameConfirm.getText().trim(),
                    password,
                    String.valueOf(passwordConfirm.getPassword()).trim(),
                    email,
                    emailConfirm.getText().trim(),
                    firstName,
                    lastName
            );

        } catch (Exception ex) {
            JOptionPane.showOptionDialog(null, ex.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE, null, null, null);
            return;
        }

        if (!authentication.doesUserExist()) {
            try {
                UserCreation.InitializeNewUser(
                        username,
                        password,
                        email,
                        firstName,
                        lastName
                );
                JOptionPane.showOptionDialog(null, "Register successfully!!!", "Success!", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                new MainGUI(3, super.getFrame());
            } catch (Exception ex) {
                JOptionPane.showOptionDialog(null, ex.getMessage(), "Warning!", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.WARNING_MESSAGE, null, null, null);
            }
        }


    }


    private void setLoginButton(ActionEvent e) {
        new MainGUI(3, super.getFrame());
    }
}
