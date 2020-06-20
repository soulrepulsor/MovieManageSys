package UserOperation;

public class UserControllerManager {

    public UserControllerManager() {}

    /**
     * Return specific user's unique controller
     * @param username username
     * @return given username's user unique controller
     */
    public static UserController getUserController(String username) {
        return new UserController(username);
    }

    /**
     * Return a list of all users' unique controller
     * @return list of all users' unique controller
     */
    public static UserAllController getUserAllController() {
        return new UserAllController();
    }
}
