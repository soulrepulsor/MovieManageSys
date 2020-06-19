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

    public void setWatchedMovies(WatchedMoviesObject watchedMovies) {
        userObject.setWatchedMovies(watchedMovies);
    }
}
