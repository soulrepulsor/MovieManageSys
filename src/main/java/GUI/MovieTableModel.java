package GUI;

import MovieOperation.MovieObject;
import MovieOperation.MovieParser;
import UserOperation.ParserException;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.LinkedList;

public class MovieTableModel extends AbstractTableModel {
    private String[] columnNames = {"Title", "Director"};
    private ArrayList<MovieObject> movieObjects;

    public MovieTableModel() {
        MovieParser movieParser = new MovieParser();
        try {
            this.movieObjects = new ArrayList<>(movieParser.parseAll());
        } catch (ParserException ex) {
            ex.printStackTrace();
            this.movieObjects = new ArrayList<>();
        }
    }

    public MovieTableModel(ArrayList<MovieObject> movieObjects) {
        this.movieObjects = movieObjects;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        int size;
        if (movieObjects == null)
            size = 0;
        else
            size = movieObjects.size();
        return size;
    }

    public Object getValueAt(int row, int col) {
        Object result = null;
        if (col == 0) {
            result = movieObjects.get(row).getTitle();
        }
        else if (col == 1) {
            result = movieObjects.get(row).getDirector();
        }
        else if (col == -1) {
            result = movieObjects.get(row).getId();
        }

        return result;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

}
