package MovieOperation;

import java.util.LinkedList;

class MovieObject {
    private int id;
    private String title;
    private String director;
    private String released;
    private float score;
    private int numRating;
    private GenreObject genreObject;

    MovieObject(int id, String title, String director, String released, float score, int numRating, GenreObject genreObject) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.released = released;
        this.score = score;
        this.numRating = numRating;
        this.genreObject = genreObject;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String director) {
        this.director = director;
    }

    String getReleased() {
        return released;
    }

    void setReleased(String released) {
        this.released = released;
    }

    float getScore() {
        return score;
    }

    void setScore(float score) {
        this.score = score;
    }

    int getNumRating() {
        return numRating;
    }

    void setNumRating(int numRating) {
        this.numRating = numRating;
    }

    LinkedList<String> getGenreObject() {
        return genreObject.getGenre();
    }

    void setGenreObject(GenreObject genreObject) {
        this.genreObject = genreObject;
    }
}
