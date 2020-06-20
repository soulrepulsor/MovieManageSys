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

    /**
     * Authenticate if the inputted information matches any of the stored user record
     * @throws AuthenticationException throws when the user/password is incorrect or the
     * required entered field is empty
     */
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

    /**
     * Check if the user exists
     * @return true if the user exists and vice versa
     */
    public boolean doesUserExist() {
        try {
            UserObject userObject = userParser.parseSingle(username);
        } catch (ParserException ex) {
            return false;
        }
        return true;
    }

}
