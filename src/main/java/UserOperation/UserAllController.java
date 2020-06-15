package UserOperation;

import java.util.LinkedList;

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
