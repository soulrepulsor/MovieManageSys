package MovieOperation;

public class MovieControllerManager {

    /**
     * Return specific movie's unique controller
     * @param id id
     * @return given the id, returns its corresponding movie controller
     */
    public static MovieController getMovieController(int id) {
        return new MovieController(String.valueOf(id));
    }

    /**
     * Return a list of all movies' unique controller
     * @return list of all movies' unique controller
     */
    public static MovieAllController getMovieAllController() {
        return new MovieAllController();
    }
}
