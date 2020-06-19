package GUI;

public class GUI {
    private int status;
    private Object object;


    GUI() {
        this.status = -1;
        this.object = null;
    }

    int getStatus() {
        return status;
    }

    void setStatus(int status) {
        this.status = status;
    }

    Object getObject() {
        return object;
    }

    void setObject(Object object) {
        this.object = object;
    }
}
