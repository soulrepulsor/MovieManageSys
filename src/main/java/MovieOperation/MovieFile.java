package MovieOperation;

import FileOperation.FileSkeleton;
import org.json.JSONObject;

public class MovieFile {
    private FileSkeleton fileSkeleton;

    MovieFile() {
        fileSkeleton = new FileSkeleton("MOVIE");
    }

    /**
     * Insert all of the movie's information into the file
     * @param jsonObject movie's information in a Json Object representation
     */
    void insertAll(JSONObject jsonObject) {fileSkeleton.insertAll(jsonObject);}

    /**
     * Check if the movie file is empty
     * @return true if the file is empty and vice versa
     */
    boolean isEmpty() {
        return fileSkeleton.isEmpty();
    }

    /**
     * Get the MovieFile
     * @return return MovieFile
     */
    JSONObject getFile() {
        return fileSkeleton.getAll();
    }
}
