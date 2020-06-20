package UserOperation;

import java.util.LinkedList;

/**
 * Stores all of the UserController Class instances. In other words this class stores an unique instance of a user
 * controller for all users.
 */
public class UserAllController {
    private LinkedList<UserController> userControllers;

    UserAllController() {
        UserParser userParser = new UserParser();

        try {
            init(userParser.parseKeys());
        } catch (ParserException ex) {
            ex.printStackTrace();
        }
    }

    private void init(LinkedList<String> usernames) {
        userControllers = new LinkedList<>();

        while (!usernames.isEmpty()) {
            userControllers.add(new UserController(usernames.pop()));
        }
    }

    public LinkedList<UserController> getUserControllers() {return userControllers;}
}
