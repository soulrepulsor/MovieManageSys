package UserOperation;

public class Authentication {
    private String username;
    private String password;

    private UserParser userParser;

    public Authentication(String username, String password) {
        userParser = new UserParser();
        this.username = username;
        this.password = password;
    }

    public void authenticate() throws AuthenticationException {
        if (username.isEmpty() || password.isEmpty())
            throw new AuthenticationException("Username or password is empty!");

        AuthenticationException authenticationException =
                new AuthenticationException("Username or password does not match!");

        try {
            UserObject userObject = userParser.parseSingle(username);

            if (!userObject.getPassword().equals(password))
                throw authenticationException;
            return;
        } catch (ParserException ex) {
            ex.printStackTrace();
        }

        throw authenticationException;
    }

    public boolean doesUserExist() {
        try {
            UserObject userObject = userParser.parseSingle(username);
        } catch (ParserException ex) {
            return false;
        }
        return true;
    }

}
