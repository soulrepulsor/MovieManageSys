package GUI;

import MovieOperation.MovieController;
import UserOperation.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Movie extends BaseGUI {
    private MovieController movieController;
    private JPanel jPanel;

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
                "Genre:", genreListing
        };

        JPanel panel = new JPanel(new SpringLayout());

        for (String s : labels) {
            JLabel label = new JLabel(s);
            label.setFont(new Font("Serif", Font.PLAIN, 18));
            panel.add(label);
        }
        SpringUtilities.makeCompactGrid(panel, labels.length / 2, 2, 0, 0, 50, 10);

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5,5));

        content.add(panel, BorderLayout.CENTER);

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
}
