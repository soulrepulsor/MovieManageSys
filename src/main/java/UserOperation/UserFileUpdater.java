package UserOperation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class UserFileUpdater {
    private final String PASSWORD = "password";
    private final String EMAIL = "email";
    private final String FIRST_NAME = "fname";
    private final String LAST_NAME = "lname";
    private final String WATCHED = "watched";

    private LinkedList<UserObject> userObjects;
    private UserFile file;

    UserFileUpdater() {
        file = new UserFile();
        try {
            userObjects = new UserParser().parseAll();
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * update the UserObject's information to file
     * @param userObject user's UserObject
     */
    void informationUpate(UserObject userObject) {
        for (UserObject object : userObjects) {
            if (object.getUsername().equals(userObject.getUsername())) {
                object.setPassword(userObject.getPassword());
                object.setEmail(userObject.getEmail());
                object.setFirstName(userObject.getFirstName());
                object.setLastName(userObject.getLastName());
                object.setWatchedMovies(new WatchedMoviesObject(userObject.getWatchedMovies()));
                writeToFile();
                return;
            }
        }
    }

    /**
     * Write the information to the file
     */
    private void writeToFile() {
        JSONObject result = new JSONObject();
        for (UserObject object : userObjects) {
            try {
                result.put(object.getUsername(), toJSONObject(object));
            } catch (JSONException ex) {
                ex.printStackTrace();
            }
        }

        file.insertAll(result);
    }

    /**
     * convert UserObject to JSONObject
     * @param userObject inputted UserObject
     * @return user information in a Json Object representation
     */
    private JSONObject toJSONObject(UserObject userObject) {
        JSONObject innerObject = new JSONObject();

        try {
            innerObject.put(PASSWORD, userObject.getPassword());
            innerObject.put(EMAIL, userObject.getEmail());
            innerObject.put(FIRST_NAME, userObject.getFirstName());
            innerObject.put(LAST_NAME, userObject.getLastName());
            innerObject.put(WATCHED, new JSONArray(userObject.getWatchedMovies()));
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
        return innerObject;
    }
}
