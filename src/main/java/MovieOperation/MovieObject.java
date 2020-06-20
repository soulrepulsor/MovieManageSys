package MovieOperation;

import java.util.ArrayList;
import java.util.LinkedList;

class MovieObject {
    private int id;
    private String img;
    private String title;
    private ArrayList<String> director;
    private String released;
    private float score;
    private GenreObject genreObject;
    private String duration;

    MovieObject(int id, String title, ArrayList<String> director, String released, float score, String duration, GenreObject genreObject, String img) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.released = released;
        this.score = score;
        this.genreObject = genreObject;
        this.duration = duration + " min";
        this.img = img;
    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration + " min";
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    ArrayList<String> getDirector() {
        return director;
    }

    void setDirector(ArrayList<String> director) {
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

    LinkedList<String> getGenreObject() {
        return genreObject.getGenre();
    }

    void setGenreObject(GenreObject genreObject) {
        this.genreObject = genreObject;
    }
}
