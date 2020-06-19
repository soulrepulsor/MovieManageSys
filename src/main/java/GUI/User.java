package GUI;

import MovieOperation.MovieObject;
import MovieOperation.MovieParser;
import UserOperation.ParserException;
import UserOperation.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class User extends BaseGUI {
    private JPanel jPanel;

    public User(UserController userController, JFrame frame) {
        super(frame, userController);
        this.jPanel = super.getjPanel();

        initContent();
    }

    private void initContent() {

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JLabel username = new JLabel(super.getUserController().getUsername());
        username.setFont(new Font("Serif", Font.PLAIN, 25));
        usernamePanel.add(usernameLabel);
        usernamePanel.add(username);

        JPanel fnamePanel = new JPanel();
        fnamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        JLabel firstnameLabel = new JLabel("First Name:");
        firstnameLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JLabel firstname = new JLabel(super.getUserController().getFirstName());
        firstname.setFont(new Font("Serif", Font.PLAIN, 25));
        fnamePanel.add(firstnameLabel);
        fnamePanel.add(firstname);

        JPanel lnamePanel = new JPanel();
        lnamePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10,1));
        JLabel lastnameLabel = new JLabel("Last Name:");
        lastnameLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        JLabel lastname = new JLabel(super.getUserController().getLastName());
        lastname.setFont(new Font("Serif", Font.PLAIN, 25));
        lnamePanel.add(lastnameLabel);
        lnamePanel.add(lastname);

        JPanel userinfoPanel = new JPanel();
        userinfoPanel.setLayout(new GridLayout(3,1));
        userinfoPanel.add(usernamePanel);
        userinfoPanel.add(fnamePanel);
        userinfoPanel.add(lnamePanel);

        content.add(userinfoPanel, BorderLayout.NORTH);

        MovieTableModel movieTableModel = new MovieTableModel(
                initTable(super.getUserController().getWatchedMovies()));
        JTable jTable = new JTable(movieTableModel);
        jTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(jTable);

        content.add(scrollPane, BorderLayout.CENTER);

        jPanel.add(content, BorderLayout.CENTER);

    }

    private ArrayList<MovieObject> initTable(LinkedList<Integer> keys) {
        ArrayList<MovieObject> movieObjects = new ArrayList<>();
        MovieParser movieParser = new MovieParser();
        for (Integer key : keys) {
            try {
                System.out.println(key.toString());
                movieObjects.add(movieParser.parseSingle(key.toString()));
            } catch (ParserException ex) {
                ex.printStackTrace();
                return null;
            }
        }
        return movieObjects;
    }

    @Override
    void setMainButton(ActionEvent e) {
        new MainGUI(0, super.getUserController(), super.getFrame());
    }

}
