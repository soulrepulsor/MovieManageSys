package Algorithm;

import GUI.MovieTableModel;
import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;

import java.util.*;

public class Algorithm {

    /**
     * Searches the movie directory linearly and returns any matches
     *
     * @param keyword searches keyword
     * @return searched result in a TableModel representation
     */
    public static MovieTableModel search(String keyword) {
        if (keyword.isEmpty() || keyword.isBlank())
            return new MovieTableModel();

        ArrayList<MovieController> searchResult = new ArrayList<>();

        LinkedList<MovieController> movieObjects =
                MovieControllerManager.getMovieAllController().getMovieControllers();
        while (!movieObjects.isEmpty()) {
            MovieController movieObject = movieObjects.pop();

            List<String> title = Arrays.asList(movieObject.getTitle().toLowerCase().split("[^A-Za-z0-9]"));

            if (title.contains(keyword.toLowerCase()))
                searchResult.add(movieObject);

            for (String director : movieObject.getDirector()) {
                if (director.trim().toLowerCase().equals(keyword.toLowerCase()))
                    searchResult.add(movieObject);
            }
        }

        return new MovieTableModel(searchResult);
    }

    /**
     * checks if the inputted information on the sign up form is valid
     * @param username username
     * @param usernameConfirm confirm username
     * @param password password
     * @param passwordConfirm confirm password
     * @param email email
     * @param emailConfirm confirm email
     * @param firstName first name
     * @param lastName last name
     * @throws Exception throws when if one of the field's format is not followed properly
     */
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

    /**
     * Recommends the user which movies to watch next. This is only used when the user is browsing each movie's info page
     * @param movieController the viewed movie's controller
     * @return list of movies that is recommended to the user
     */
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
