package MovieOperation;

import FileOperation.FileSkeleton;
import org.json.JSONObject;

public class MovieFile {
    private FileSkeleton fileSkeleton;

    MovieFile() {
        fileSkeleton = new FileSkeleton("MOVIE");
    }

    void insertAll(JSONObject jsonObject) {fileSkeleton.insertAll(jsonObject);}

    boolean isEmpty() {
        return fileSkeleton.isEmpty();
    }

    JSONObject getFile() {
        return fileSkeleton.getAll();
    }
}
