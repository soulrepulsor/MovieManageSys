package UserOperation;

import FileOperation.FileSkeleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserCreation {
    public static void InitializeNewUser(
            String username, String password, String email,
            String fname, String lname) throws Exception {

        if (username.trim().isEmpty() || password.trim().isEmpty() ||
                email.trim().isEmpty() || fname.trim().isEmpty() || lname.trim().isEmpty())
            throw  new Exception("ONE OF THE FIELD IS MISSING!!!");

        FileSkeleton fs = new FileSkeleton("USER");
        JSONObject details = new JSONObject();
        try {
            details.put("password", password.trim());
            details.put("email", email.trim());
            details.put("fname", fname.trim());
            details.put("lname", lname.trim());
            details.put("watched", new JSONArray());
            fs.insert(username.trim(), details);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

}
