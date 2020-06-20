package MovieOperation;

import UserOperation.ParserException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

class MovieParser {

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

    LinkedList<String> parseKeys() throws ParserException {
        if (rawFile.isEmpty())
            throw new ParserException("file doesn't exist or key is invalid");
        LinkedList<String> result = new LinkedList<>();
        Iterator<String> keys = rawFile.getFile().keys();

        while (keys.hasNext())
            result.add(keys.next());
        return result;
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

    MovieObject parseSingle(String key) throws ParserException {
        if (rawFile.isEmpty() || !rawFile.getFile().has(key)) {
            throw new ParserException("file doesn't exist or key is invalid");
        }

        try {
            JSONObject movieFile = rawFile.getFile();
            JSONObject innerObject = movieFile.getJSONObject(key);
            return new MovieObject(
                    Integer.parseInt(key), parseMovieDetail(TITLE, innerObject),
                    parseMovieDetail(DIRECTOR, innerObject),
                    parseMovieDetail(DATE, innerObject),
                    Float.parseFloat(parseMovieDetail(SCORE, innerObject)),
                    Integer.parseInt(parseMovieDetail(TOTALRATER, innerObject)),
                    parseGenre(innerObject)
            );
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        throw new ParserException("unknown error");
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
