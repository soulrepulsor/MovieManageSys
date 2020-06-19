package MovieOperation;

import UserOperation.ParserException;

import java.util.LinkedList;

public class MovieController {
    private MovieObject movieObject;

    MovieController(String id) {
        MovieParser movieParser = new MovieParser();
        try {
            movieObject = movieParser.parseSingle(id);
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }

    public int getId() {
        return movieObject.getId();
    }

    public String getTitle() {
        return movieObject.getTitle();
    }

    public String getDirector() {
        return movieObject.getDirector();
    }

    public String getReleased() {
        return movieObject.getReleased();
    }

    public float getScore() {
        return movieObject.getScore();
    }

    public int getNumRating() {
        return movieObject.getNumRating();
    }

    public LinkedList<String> getGenreObject() {
        return movieObject.getGenreObject();
    }
}
