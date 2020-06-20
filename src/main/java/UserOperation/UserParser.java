package UserOperation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.LinkedList;

class UserParser {
    private final String PASSWORD = "password";
    private final String EMAIL = "email";
    private final String FIRST_NAME = "fname";
    private final String LAST_NAME = "lname";
    private final String WATCHED = "watched";

    private UserFile rawFile;

    UserParser() {rawFile = new UserFile();}

    /**
     * Parse all of the user's keys
     * @return list of user's keys
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
     * Parse all of the user's information
     * @return list of user's information in the representation of UserObject
     * @throws ParserException file not found
     */
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

    /**
     * Parse a single user's information
     * @param key user's specific key
     * @return parsed user information in the representation of UserObject
     * @throws ParserException file doesn't exist or key is invalid
     */
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

    /**
     * Parse user's stored information
     * @param keyword the key of user's stored information
     * @param object the Json Object that stores the user's information
     * @return the details of a specific user information
     */
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

    /**
     * parse the watched movies of an user
     * @param object the Json object that stores the user's watched history
     * @return a WatchedMoviesObject that stores the the user's watched history
     */
    private WatchedMoviesObject parseWatched(JSONObject object) {
        try {
            return new WatchedMoviesObject(
                    jsonArrayToWatchedMovie(object.getJSONArray(WATCHED)));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Convert JsonArray to LinkedList of Integers
     * @param jsonArray jsonArray
     * @return List of Integers in a LinkedList representation
     */
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
