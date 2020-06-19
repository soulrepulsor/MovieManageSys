package MovieOperation;

public class MovieControllerManager {

    public static MovieController getMovieController(int id) {
        return new MovieController(String.valueOf(id));
    }
}
