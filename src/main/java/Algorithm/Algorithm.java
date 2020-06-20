package Algorithm;

import MovieOperation.MovieObject;
import MovieOperation.MovieParser;
import GUI.MovieTableModel;
import UserOperation.ParserException;

import java.util.ArrayList;
import java.util.LinkedList;

public class Algorithm {

    public static MovieTableModel search(String keyword) {
        if (keyword.isEmpty() || keyword.isBlank())
            return new MovieTableModel();

        ArrayList<MovieObject> searchResult = new ArrayList<>();

        try {
            LinkedList<MovieObject> movieObjects = (new MovieParser()).parseAll();
            while (!movieObjects.isEmpty()) {
                MovieObject movieObject = movieObjects.pop();
                if (movieObject.getDirector().toLowerCase().equals(keyword.toLowerCase()) ||
                        movieObject.getTitle().toLowerCase().equals(keyword.toLowerCase()))
                    searchResult.add(movieObject);
            }

        } catch (ParserException ex) {
            ex.printStackTrace();
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
}
