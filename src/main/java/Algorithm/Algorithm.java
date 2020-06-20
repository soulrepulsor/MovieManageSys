package Algorithm;

import GUI.MovieTableModel;
import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;

import java.util.ArrayList;
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

    public static ArrayList<MovieController> recommendation(LinkedList<String> genreList) {
        return null;
    }
}
