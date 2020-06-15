package UserOperation;

import java.util.LinkedList;

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
