package MovieOperation;

import UserOperation.ParserException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class MovieParser {

    private MovieFile rawFile;

    private final String TITLE = "title";
    private final String DIRECTOR = "director";
    private final String DATE = "released";
    private final String SCORE = "score";
    private final String GENRE = "genre";
    private final String IMG = "img";
    private final String DURATION = "duration";

    MovieParser() {
        rawFile = new MovieFile();
    }

    /**
     * Parse all of the movie's keys
     * @return list of movie's keys
     * @throws ParserException file doesn't exist or the key is invalid
     */
    LinkedList<String> parseKeys() throws ParserException {
        if (rawFile.isEmpty())
            throw new ParserException("file doesn't exist or key is invalid");
        LinkedList<String> result = new LinkedList<>();
        Iterator<String> keys = rawFile.getFile().keys();

        while (keys.hasNext())
            result.add(keys.next());
        return result;
    }

    /**
     * Parse all of the movie's information
     * @return list of movie's information in the representation of UserObject
     * @throws ParserException file not found
     */
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
                                parseDirector(details),
                                parseMovieDetail(DATE, details),
                                Float.parseFloat(parseMovieDetail(SCORE, details)),
                                parseMovieDetail(DURATION, details),
                                parseGenre(details),
                                parseMovieDetail(IMG, details)
                        )
                );
            } catch (JSONException | NumberFormatException ex) {
                throw new ParserException(ex.getMessage());
            }
        }
        return movieObjects;
    }

    /**
     * Parse a single movie's information
     * @param key movie's specific key
     * @return parsed movie information in the representation of UserObject
     * @throws ParserException file doesn't exist or key is invalid
     */
    MovieObject parseSingle(String key) throws ParserException {
        if (rawFile.isEmpty() || !rawFile.getFile().has(key)) {
            throw new ParserException("file doesn't exist or key is invalid");
        }

        try {
            JSONObject movieFile = rawFile.getFile();
            JSONObject details = movieFile.getJSONObject(key);
            return new MovieObject(
                    Integer.parseInt(key), parseMovieDetail(TITLE, details),
                    parseDirector(details),
                    parseMovieDetail(DATE, details),
                    Float.parseFloat(parseMovieDetail(SCORE, details)),
                    parseMovieDetail(DURATION, details),
                    parseGenre(details),
                    parseMovieDetail(IMG, details)
            );
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        throw new ParserException("unknown error");
    }

    /**
     * Parse movie's stored information
     * @param keyword the key of movie's stored information
     * @param object the Json Object that stores the movie's information
     * @return the details of a specific movie information
     */
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

    /**
     * parse the genres of a movie
     * @param jsonObject the Json object that stores the movie's genres
     * @return a GenreObject that stores the the movie's genres
     */
    private GenreObject parseGenre(JSONObject jsonObject) {
        try {
            return new GenreObject(jsonArrayToList(jsonObject.getJSONArray(GENRE)));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * parse the directory of a movie
     * @param jsonObject the Json object that stores the movie's directory
     * @return a ScoreObject that stores the the movie's directory
     */
    private ArrayList<String> parseDirector(JSONObject jsonObject) {
        try {
            return new ArrayList<>(jsonArrayToList(jsonObject.getJSONArray(DIRECTOR)));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Convert JsonArray to LinkedList of String
     * @param jsonArray jsonArray
     * @return List of String in a LinkedList representation
     */
    private LinkedList<String> jsonArrayToList(JSONArray jsonArray) {
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
