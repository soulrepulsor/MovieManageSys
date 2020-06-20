package Algorithm;

import GUI.MovieTableModel;
import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Algorithm {

    public static MovieTableModel search(String keyword) {
        if (keyword.isEmpty() || keyword.isBlank())
            return new MovieTableModel();

        ArrayList<MovieController> searchResult = new ArrayList<>();

        LinkedList<MovieController> movieObjects =
                MovieControllerManager.getMovieAllController().getMovieControllers();
        while (!movieObjects.isEmpty()) {
            MovieController movieObject = movieObjects.pop();
            if (movieObject.getDirector().toLowerCase().equals(keyword.toLowerCase()) ||
                    movieObject.getTitle().toLowerCase().equals(keyword.toLowerCase()))
                searchResult.add(movieObject);
        }

        return new MovieTableModel(searchResult);
    }

    public static void registerFormCheck(
            String username, String usernameConfirm,
            String password, String passwordConfirm,
            String email, String emailConfirm,
            String firstName, String lastName) throws Exception {

        if (email.isEmpty() || emailConfirm.isEmpty() || firstName.isEmpty() || lastName.isEmpty())
            throw new Exception("Missing Field!");
        else if (!username.equals(usernameConfirm))
            throw new Exception("Username doesn't match");
        else if (!password.equals(passwordConfirm))
            throw new Exception("Password doesn't match");
        else if (!email.equals(emailConfirm))
            throw new Exception("Email doesn't match");
    }

    public static ArrayList<MovieController> recommendation(MovieController movieController) {
        LinkedList<MovieController> movieControllers =
                MovieControllerManager.getMovieAllController().getMovieControllers();

        ArrayList<MovieController> match = new ArrayList<>();

        for (MovieController controller : movieControllers) {
            int count = 0;
            if (controller.getId() != movieController.getId()) {
                for (String genre : movieController.getGenreObject()) {
                    if (controller.getGenreObject().contains(genre))
                        count++;
                    if (count >= 2)
                        match.add(controller);
                    break;
                }
            }
        }

        if (match.size() <= 10)
            return match;

        Collections.shuffle(match);
        match.subList(0, 10);

        return match;
    }
}
