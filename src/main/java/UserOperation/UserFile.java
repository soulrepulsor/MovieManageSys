package UserOperation;

import FileOperation.FileSkeleton;
import org.json.JSONObject;

public class UserFile {
    private FileSkeleton fileSkeleton;

    UserFile() {
        fileSkeleton = new FileSkeleton("USER");
    }

    void insertAll(JSONObject jsonObject) {fileSkeleton.insertAll(jsonObject);}

    boolean isEmpty() {return fileSkeleton.isEmpty();}

    JSONObject getFile() {return fileSkeleton.getAll();}
}
