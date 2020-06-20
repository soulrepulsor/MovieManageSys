package FileOperation;

import Resources.Dummy;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.Iterator;

public class FileSkeleton {
    private JSONObject jsonObject;
    private String fileName;
    private FileReader fileReader;

    public FileSkeleton(String fileName) {
        jsonObject = new JSONObject();
        this.fileName = fileName;
    }

    /**
     * check if the file is empty
     * @return true if the file is empty and vice versa
     */
    public boolean isEmpty() {
        File file = new File(Dummy.class.getResource(fileName).getFile());
        return !file.exists();
    }

    /**
     * transforms jsonObject's content to string then write it to a file
     * @param object input JsonObject that wants all of its content to write to a file
     */
    public void insertAll(JSONObject object) {
        File file = new File(Dummy.class.getResource(fileName).getFile());
        read(file);
        Iterator<String> keys = jsonObject.keys();

        if (jsonObject.length() <= 0) {
            jsonObject = object;
            save();
            return;
        }

        while (keys.hasNext()) {
            String key = keys.next();
            try {
                insert(key, object.get(key));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * insert a specific part of the JsonObject into the file
     * @param key the key of where the content is stored
     * @param value the actual content that wants to be saved into the file
     */
    public void insert(String key, Object value) {
        File file = new File(Dummy.class.getResource(fileName).getFile());
        read(file);
        try {
            jsonObject.put(key, value);
            save();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Write to file
     */
    private void save() {
        File file = new File(Dummy.class.getResource(fileName).getFile());
        if (!file.exists()) {
            try {
                boolean handler = file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(jsonObject.toString(4));
            bufferedWriter.close();
        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Read the file
     * @param file the file object that want's to be read
     */
    private void read(File file) {
        try {
            FileReader fileReader = new FileReader(file.getAbsolutePath());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            StringBuilder result = new StringBuilder();
            while (line != null) {
                result.append(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            if (result.toString().trim().length() > 9)
                jsonObject = new JSONObject(result.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Get all of the contents of a file in a JSON structured object
     * @return JsonObject that contains all of the file's content
     */
    public JSONObject getAll() {
        read(new File(Dummy.class.getResource(fileName).getFile()));
        return this.jsonObject;
    }

}
