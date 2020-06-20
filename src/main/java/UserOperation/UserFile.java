package UserOperation;

import FileOperation.FileSkeleton;
import org.json.JSONObject;

public class UserFile {
    private FileSkeleton fileSkeleton;

    UserFile() {
        fileSkeleton = new FileSkeleton("USER");
    }

    /**
     * Insert all of the user's information into the file
     * @param jsonObject user's information in a Json Object representation
     */
    void insertAll(JSONObject jsonObject) {fileSkeleton.insertAll(jsonObject);}

    /**
     * Check if the user file is empty
     * @return true if the file is empty and vice versa
     */
    boolean isEmpty() {return fileSkeleton.isEmpty();}

    /**
     * Get the UserFile
     * @return return UserFile
     */
    JSONObject getFile() {return fileSkeleton.getAll();}
}
