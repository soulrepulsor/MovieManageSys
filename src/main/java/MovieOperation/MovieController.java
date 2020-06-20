package MovieOperation;

import UserOperation.ParserException;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class functions like a middleware between the GUI and the MovieObject class. It functions exactly like MovieObject class but
 * hides the Movie Object away from the GUI.
 */
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

    public ArrayList<String> getDirector() {
        return movieObject.getDirector();
    }

    public String getReleased() {
        return movieObject.getReleased();
    }

    public float getScore() {
        return movieObject.getScore();
    }

    public LinkedList<String> getGenreObject() {
        return movieObject.getGenreObject();
    }

    public String getImg() {
        return movieObject.getImg();
    }

    public String getDuration() {
        return movieObject.getDuration();
    }
}
