package UserOperation;

import java.util.LinkedList;

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

    void setUsername(String username) {
        userObject.setUsername(username);
    }

    String getPassword() {
        return userObject.getPassword();
    }

    void setPassword(String password) {
        userObject.setPassword(password);
    }

    String getEmail() {
        return userObject.getEmail();
    }

    void setEmail(String email) {
        userObject.setEmail(email);
    }

    String getFirstName() {
        return userObject.getFirstName();
    }

    void setFirstName(String firstName) {
        userObject.setFirstName(firstName);
    }

    String getLastName() {
        return userObject.getLastName();
    }

    void setLastName(String lastName) {
        userObject.setLastName(lastName);
    }

    LinkedList<Integer> getWatchedMovies() {
        return userObject.getWatchedMovies();
    }

    void setWatchedMovies(WatchedMoviesObject watchedMovies) {
        userObject.setWatchedMovies(watchedMovies);
    }
}
