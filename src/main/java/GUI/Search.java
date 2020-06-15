package GUI;

import MovieOperation.MovieTableModel;
import UserOperation.Authentication;
import UserOperation.AuthenticationException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Search {
    private JPanel jPanel;
    private JButton btn;
    private JTextField usernameTextfield;
    private JTextField passwordTextfield;
    private JPanel panelBottom;

    public Search() {
        jPanel = new JPanel();
        init();
    }

    private void init() {
        MovieTableModel movieTableModel = new MovieTableModel();

        JTable jTable = new JTable(movieTableModel);
        jTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(jTable);
        scrollPane.setPreferredSize(new Dimension(380,280));

        jPanel.setLayout(new FlowLayout());
        jPanel.add(scrollPane);
    }


    public JPanel getjPanel() {
        return jPanel;
    }
}
