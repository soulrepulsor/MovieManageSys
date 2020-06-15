package MovieOperation;

import java.util.LinkedList;

public class MovieObject {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getNumRating() {
        return numRating;
    }

    public void setNumRating(int numRating) {
        this.numRating = numRating;
    }

    public LinkedList<String> getGenreObject() {
        return genreObject.getGenre();
    }

    public void setGenreObject(GenreObject genreObject) {
        this.genreObject = genreObject;
    }
}
