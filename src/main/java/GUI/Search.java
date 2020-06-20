package GUI;

import Algorithm.Algorithm;
import UserOperation.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This class creates a panel that when it renders, it shows the necessary components of a search menu.
 * Extends the BaseGUI class so it doesn't need to re initializes the menu screen, as well as rewiring the events.
 */
public class Search extends BaseGUI {
    private JPanel jPanel;
    private JTextField searchTextfield;
    private JTable jTable;

    public Search(UserController userController, JFrame frame) {
        super(frame, userController);
        jPanel = super.getjPanel();
        initSearchGui();
    }

    private void initSearchGui() {
        MovieTableModel movieTableModel = new MovieTableModel();

        JPanel searchPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Search:");
        searchTextfield = new JTextField("", 20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this::setSearchButton);
        searchPanel.add(searchLabel);
        searchPanel.add(searchTextfield);
        searchPanel.add(searchButton);

        jTable = new JTable(movieTableModel);
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();

                    int row = target.getSelectedRow();
                    rowDoubleClicked((Integer) target.getValueAt(row, -1));
                }
            }
        });

        jTable.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(jTable);

        JPanel searchContainer = new JPanel();

        searchContainer.setLayout(new BorderLayout());
        searchContainer.add(searchPanel, BorderLayout.NORTH);
        searchContainer.add(scrollPane, BorderLayout.CENTER);

        jPanel.add(searchContainer, BorderLayout.CENTER);
    }

    @Override
    void setUserButton(ActionEvent e) {
        new MainGUI(1, super.getUserController(), super.getFrame());
    }

    private void setSearchButton(ActionEvent e) {
        String keyword = searchTextfield.getText().trim();
        jTable.setModel(Algorithm.search(keyword));
        jTable.setAutoCreateRowSorter(true);
    }

    private void rowDoubleClicked(int id) {
        new MainGUI(2, super.getUserController(), super.getFrame(), id);
    }

    JPanel getjPanel() {
        return jPanel;
    }
}
