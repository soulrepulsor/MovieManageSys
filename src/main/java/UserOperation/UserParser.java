package UserOperation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

public class UserParser {
    private final String PASSWORD = "password";
    private final String EMAIL = "email";
    private final String FIRST_NAME = "fname";
    private final String LAST_NAME = "lname";
    private final String WATCHED = "watched";

    private UserFile rawFile;

    UserParser() {rawFile = new UserFile();}

    LinkedList<String> parseKeys() throws ParserException {
        if (rawFile.isEmpty())
            throw new ParserException("file doesn't exist or key is invalid");

        LinkedList<String> result = new LinkedList<>();
        Iterator<String> keys = rawFile.getFile().keys();

        while (keys.hasNext())
            result.add(keys.next());
        return result;
    }

    LinkedList<UserObject> parseAll() throws ParserException{
        if (rawFile.isEmpty()) {
            throw new ParserException("file not found");
        }

        JSONObject userFile = rawFile.getFile();
        LinkedList<UserObject> userObjects = new LinkedList<>();
        Iterator<String> keys = userFile.keys();

        while (keys.hasNext()) {
            try {
                String key = keys.next();
                JSONObject details = userFile.getJSONObject(key);

                userObjects.add(
                        new UserObject(
                                key,
                                parseUserDetail(PASSWORD, details),
                                parseUserDetail(EMAIL, details),
                                parseUserDetail(FIRST_NAME, details),
                                parseUserDetail(LAST_NAME, details),
                                parseWatched(details)
                        )
                );
            } catch (JSONException ex) {
                throw new ParserException(ex.getMessage());
            }
        }
        return userObjects;
    }

    UserObject parseSingle(String key) throws ParserException {
        if (rawFile.isEmpty() || !rawFile.getFile().has(key)) {
            throw new ParserException("file doesn't exist or key is invalid");
        }

        try {
            JSONObject userFile = rawFile.getFile();
            JSONObject innerObject = userFile.getJSONObject(key);
            return new UserObject(
                    key,
                    parseUserDetail(PASSWORD, innerObject),
                    parseUserDetail(EMAIL, innerObject),
                    parseUserDetail(FIRST_NAME, innerObject),
                    parseUserDetail(LAST_NAME, innerObject),
                    parseWatched(innerObject)
            );
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        throw new ParserException("unknown error");
    }

    private String parseUserDetail(String keyword, JSONObject object) {
        if (object.has(keyword)) {
            try {
                return object.getString(keyword);
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private WatchedMoviesObject parseWatched(JSONObject object) {
        try {
            return new WatchedMoviesObject(
                    jsonArrayToWatchedMovie(object.getJSONArray(WATCHED)));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private LinkedList<Integer> jsonArrayToWatchedMovie(JSONArray jsonArray) {
        LinkedList<Integer> result = new LinkedList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++)
                result.add(jsonArray.getInt(i));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
