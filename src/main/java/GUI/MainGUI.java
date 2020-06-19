package GUI;

import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;
import UserOperation.UserController;
import UserOperation.UserControllerManager;

import javax.swing.*;
import java.awt.*;

public class MainGUI {
    private JPanel jPanel;
    private JFrame frame;
    private UserController userController;
    private MovieController movieController;

    MainGUI(int status, String username, JFrame frame) {
        userController = UserControllerManager.getUserController(username);
        this.frame = frame;
        init(status);
        run();
    }

    MainGUI(int status, UserController userController, JFrame frame) {
        this.userController = userController;
        this.frame = frame;
        init(status);
        run();
    }

    MainGUI(int status, UserController userController, JFrame frame, int movieId) {
        movieController = MovieControllerManager.getMovieController(movieId);
        this.userController = userController;
        this.frame = frame;
        init(status);
        run();
    }

    private void refreshFrame() {
        this.frame.getContentPane().removeAll();
    }

    private void init(int status) {
        refreshFrame();
        jPanel = new JPanel();
        switch (status) {
            case 0:
                frame.setTitle("Search");
                jPanel = (new Search(userController, frame)).getjPanel();
                break;
            case 1:
                frame.setTitle("User");
                jPanel = (new User(userController, frame)).getjPanel();
                break;
            case 2:
                frame.setTitle("Movie Description");
                jPanel = (new Movie(userController, frame, movieController)).getjPanel();
                break;
            default:
                System.exit(0);
        }
    }

    private void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jPanel);
        frame.pack();
        frame.setVisible(true);
    }

}
