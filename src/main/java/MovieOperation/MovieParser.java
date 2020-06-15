package MovieOperation;

import UserOperation.ParserException;
import UserOperation.UserAllController;
import UserOperation.UserController;
import UserOperation.UserControllerManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class MovieParser {

    private MovieFile rawFile;

    private final String TITLE = "title";
    private final String DIRECTOR = "director";
    private final String DATE = "released";
    private final String SCORE = "score";
    private final String TOTALRATER = "numRating";
    private final String GENRE = "genre";

    MovieParser() {
        rawFile = new MovieFile();
    }

    LinkedList<MovieObject> parseAll() throws ParserException {
        if (rawFile.isEmpty()) {
            throw new ParserException("file not found");
        }

        JSONObject movieFile = rawFile.getFile();
        LinkedList<MovieObject> movieObjects = new LinkedList<>();
        Iterator<String> keys = movieFile.keys();

        while (keys.hasNext()) {
            try {
                String key = keys.next();
                JSONObject details = movieFile.getJSONObject(key);

                movieObjects.add(
                        new MovieObject(
                            Integer.parseInt(key), parseMovieDetail(TITLE, details),
                                parseMovieDetail(DIRECTOR, details),
                                parseMovieDetail(DATE, details),
                                Float.parseFloat(parseMovieDetail(SCORE, details)),
                                Integer.parseInt(parseMovieDetail(TOTALRATER, details)),
                                parseGenre(details)
                        )
                );
            } catch (JSONException | NumberFormatException ex) {
                throw new ParserException(ex.getMessage());
            }
        }
        return movieObjects;
    }

    private String parseMovieDetail(String keyword, JSONObject object) {
        if (object.has(keyword)) {
            try {
                return object.getString(keyword);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private GenreObject parseGenre(JSONObject jsonObject) {
        try {
            return new GenreObject(jsonArrayToGenre(jsonObject.getJSONArray(GENRE)));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private LinkedList<String> jsonArrayToGenre(JSONArray jsonArray) {
        LinkedList<String> result = new LinkedList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++)
                result.add(jsonArray.getString(i));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return result;
    }



}
