package UserOperation;

import java.util.LinkedList;

/**
 * Each watched movies information that is labelled according to its JSON format
 */
class WatchedMoviesObject {
    private LinkedList<Integer> watchedMovies;

    WatchedMoviesObject(LinkedList<Integer> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public LinkedList<Integer> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(LinkedList<Integer> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
