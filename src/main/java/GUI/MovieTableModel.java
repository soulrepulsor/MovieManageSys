package GUI;

import MovieOperation.MovieController;
import MovieOperation.MovieControllerManager;
import UserOperation.ParserException;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This is a custom class which allows the movie's info to be displayed easily in terms of a JTable, by passing the
 * movie controllers.
 */
public class MovieTableModel extends AbstractTableModel {
    private String[] columnNames = {"Title", "Director"};
    private ArrayList<MovieController> movieObjects;

    public MovieTableModel() {
        this.movieObjects =
                new ArrayList<>(MovieControllerManager.getMovieAllController().getMovieControllers());
    }

    public MovieTableModel(ArrayList<MovieController> movieObjects) {
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
            String directorListing = movieObjects.get(row).getDirector().toString();
            try {
                directorListing = directorListing.substring(1, directorListing.length() - 1);
            } catch (NullPointerException ex) {
                ex.printStackTrace();
                directorListing = "N\\A";
            }
            result = directorListing;
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
