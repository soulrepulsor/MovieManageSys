package UserOperation;

import java.util.LinkedList;

/**
 * This class functions like a middleware between the GUI and the User class. It functions exactly like User class but
 * hides the User Object away from the GUI.
 */
public class UserController {
    private UserObject userObject;

    UserController(String username) {
        UserParser userParser = new UserParser();
        try {
            userObject = userParser.parseSingle(username);
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }

    public void updateToFile() {
        new UserFileUpdater().informationUpate(userObject);
    }

    public String getUsername() { return userObject.getUsername();}

    public void setUsername(String username) {
        userObject.setUsername(username);
    }

    public String getPassword() {
        return userObject.getPassword();
    }

    public void setPassword(String password) {
        userObject.setPassword(password);
    }

    public String getEmail() {
        return userObject.getEmail();
    }

    public void setEmail(String email) {
        userObject.setEmail(email);
    }

    public String getFirstName() {
        return userObject.getFirstName();
    }

    public void setFirstName(String firstName) {
        userObject.setFirstName(firstName);
    }

    public String getLastName() {
        return userObject.getLastName();
    }

    public void setLastName(String lastName) {
        userObject.setLastName(lastName);
    }

    public LinkedList<Integer> getWatchedMovies() {
        return userObject.getWatchedMovies();
    }

    public void setWatchedMovies(LinkedList<Integer> watchedMovies) {
        userObject.setWatchedMovies(new WatchedMoviesObject(watchedMovies));
    }
}
