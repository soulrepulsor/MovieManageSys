package GUI;

import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;
import UserOperation.UserController;
import UserOperation.UserControllerManager;

import javax.swing.*;

public class MainGUI {
    private JPanel jPanel;
    private JFrame frame;
    private UserController userController;
    private MovieController movieController;

    MainGUI(int status, String username, JFrame frame) {
        userController = UserControllerManager.getUserController(username);
        this.frame = frame;
        init(status);
    }

    MainGUI(int status, UserController userController, JFrame frame) {
        this.userController = userController;
        this.frame = frame;
        init(status);
    }

    MainGUI(int status, UserController userController, JFrame frame, int movieId) {
        movieController = MovieControllerManager.getMovieController(movieId);
        this.userController = userController;
        this.frame = frame;
        init(status);
    }

    MainGUI(int status, JFrame frame) {
        this.frame = (frame == null) ? new JFrame() : frame;
        init(status);
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
            case 3:
                frame.setTitle("Login");
                jPanel = (new Login(frame).getjPanel());
                break;
            case 4:
                frame.setTitle("Sign Up");
                jPanel = (new Signup(frame).getjPanel());
                break;
            default:
                System.exit(0);
        }

        run();
    }

    private void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jPanel);
        frame.pack();
        frame.setVisible(true);
    }

}
