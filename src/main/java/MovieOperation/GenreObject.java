package MovieOperation;

import java.util.LinkedList;

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
