package GUI;

import MovieOperation.MovieController;
import MovieOperation.MovieObject;
import UserOperation.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

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

        JPanel content = new JPanel();
        content.setLayout(new BorderLayout(5,5));

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel title = new JLabel(movieController.getTitle());
        title.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        titlePanel.add(titleLabel);
        titlePanel.add(title);

        JLabel directorLabel = new JLabel("Director:");
        directorLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel director = new JLabel(movieController.getDirector());
        director.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel directorPanel = new JPanel();
        directorPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        directorPanel.add(directorLabel);
        directorPanel.add(director);

        JLabel releasedLabel = new JLabel("Released Date:");
        releasedLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel released = new JLabel(movieController.getReleased());
        released.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel releasedPanel = new JPanel();
        releasedPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        releasedPanel.add(releasedLabel);
        releasedPanel.add(released);

        JLabel scoreLabel = new JLabel("Score:");
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel score = new JLabel(String.valueOf(movieController.getScore()));
        score.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        scorePanel.add(scoreLabel);
        scorePanel.add(score);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel genre = new JLabel(genreListing);
        genre.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel genrePanel = new JPanel();
        genrePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 1));
        genrePanel.add(genreLabel);
        genrePanel.add(genre);

        JPanel movieInfo = new JPanel();
        movieInfo.setLayout(new GridLayout(5, 1));
        movieInfo.add(titlePanel);
        movieInfo.add(directorPanel);
        movieInfo.add(releasedPanel);
        movieInfo.add(scorePanel);
        movieInfo.add(genrePanel);

        content.add(movieInfo, BorderLayout.CENTER);
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
