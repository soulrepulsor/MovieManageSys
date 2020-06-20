package MovieOperation;

import UserOperation.ParserException;

import java.util.ArrayList;
import java.util.LinkedList;

public class MovieAllController {
    private LinkedList<MovieController> movieControllers;

    MovieAllController() {
        MovieParser movieParser = new MovieParser();
        try {
            init(movieParser.parseKeys());
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }

    private void init(LinkedList<String> ids) {
        movieControllers = new LinkedList<>();
        while(!ids.isEmpty())
            movieControllers.add(new MovieController(ids.pop()));
    }

    public LinkedList<MovieController> getMovieControllers() {
        return movieControllers;
    }
}
