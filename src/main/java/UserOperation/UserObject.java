package UserOperation;

import java.util.ArrayList;
import java.util.LinkedList;

public class UserObject {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private WatchedMoviesObject watchedMovies;

    UserObject(String username, String password, String email, String firstName, String lastName, WatchedMoviesObject watchedMovies) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.watchedMovies = watchedMovies;
    }

    String getUsername() {
        return username;
    }

    void setUsername(String username) {
        this.username = username;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    LinkedList<Integer> getWatchedMovies() {
        return watchedMovies.getWatchedMovies();
    }

    void setWatchedMovies(WatchedMoviesObject watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
