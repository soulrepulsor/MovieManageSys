package GUI;

import Algorithm.Algorithm;
import MovieOperation.MovieController;
import UserOperation.UserController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class Movie extends BaseGUI {
    private MovieController movieController;
    private JPanel jPanel;
    private JComboBox<String> watchedOption;

    Movie(UserController userController, JFrame frame, MovieController movieController) {
        super(frame, userController);
        this.jPanel = super.getjPanel();
        this.movieController = movieController;
        initContent();
    }

    private void initContent() {
        String genreListing = movieController.getGenreObject().toString();
        try {
            genreListing = genreListing.substring(1, genreListing.length() - 1);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            genreListing = "N\\A";
        }

        String[] labels = {
                "Title:", movieController.getTitle(),
                "Director:", movieController.getDirector(),
                "Released Date:", movieController.getReleased(),
                "Score:", String.valueOf(movieController.getScore()),
                "Genre:", genreListing,
                "Watched:"
        };

        JPanel panel = new JPanel(new SpringLayout());

        for (String s : labels) {
            JLabel label = new JLabel(s);
            label.setFont(new Font("Serif", Font.PLAIN, 18));
            panel.add(label);
        }

        watchedOption = new JComboBox<>(new String[]{"Watched", "Not Watched"});
        watchedOption.setPrototypeDisplayValue("Not Watched ");
        watchedOption.setMaximumSize(watchedOption.getPreferredSize());
        watchedOption.addActionListener(this::actionPerformed);

        if (super.getUserController().getWatchedMovies().contains(movieController.getId()))
            watchedOption.setSelectedIndex(0);
        else
            watchedOption.setSelectedIndex(1);

        panel.add(watchedOption);

        SpringUtilities.makeCompactGrid(panel, labels.length / 2 + 1, 2, 0, 0, 50, 10);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(this::setSaveButton);

        JPanel gridContainer = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        gridContainer.add(panel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 1;
        gridContainer.add(saveButton, c);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5, 5));

        content.add(new JPanel(), BorderLayout.WEST);
        content.add(new JPanel(), BorderLayout.SOUTH);

        MovieTableModel movieTableModel = new MovieTableModel(Algorithm.recommendation(movieController));
        JTable jTable = new JTable(movieTableModel);
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
        scrollPane.setBorder(new TitledBorder("Recommendation"));

        content.add(gridContainer, BorderLayout.NORTH);
        content.add(scrollPane, BorderLayout.CENTER);

        jPanel.add(content, BorderLayout.CENTER);

    }

    @Override
    void setMainButton(ActionEvent e) {
        new MainGUI(0, super.getUserController(), super.getFrame());
    }

    @Override
    void setUserButton(ActionEvent e) {
        new MainGUI(1, super.getUserController(), super.getFrame());
    }

    private void setSaveButton(ActionEvent e) {
        super.getUserController().updateToFile();
    }

    private void actionPerformed(ActionEvent e) {
        LinkedList<Integer> linkedList = super.getUserController().getWatchedMovies();
        int id = movieController.getId();
        int selected = watchedOption.getSelectedIndex();
        if (selected == 0 && !linkedList.contains(id)) {
            linkedList.add(id);
            super.getUserController().setWatchedMovies(linkedList);
        } else if (selected == 1 && linkedList.contains(id)) {
            linkedList.remove(Integer.valueOf(id));
        }
    }

    private void rowDoubleClicked(int id) {
        new MainGUI(2, super.getUserController(), super.getFrame(), id);
    }
}
