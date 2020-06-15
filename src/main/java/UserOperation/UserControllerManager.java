package UserOperation;

public class UserControllerManager {

    public UserControllerManager() {}

    public static UserController getUserController(String username) {
        return new UserController(username);
    }

    public static UserAllController getUserAllController() {
        return new UserAllController();
    }
}
