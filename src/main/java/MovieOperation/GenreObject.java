package MovieOperation;

import java.util.LinkedList;

/**
 * Each genre's information that is labelled according to its JSON format
 */
class GenreObject {
    private LinkedList<String> genre;

    GenreObject(LinkedList<String> genre) {
        this.genre = genre;
    }

    public LinkedList<String> getGenre() {
        return genre;
    }

    public void setGenre(LinkedList<String> genre) {
        this.genre = genre;
    }
}
