import static java.util.Objects.requireNonNull;

public class Username {

    private static final int MAX_USERNAME_LENGTH = 100;


    private final String username;

    public Username(String username) {
        requireNonNull(username, "username not provided");
        checkUsernameLength(username);
        this.username = username;
    }

    public static Username of(final String userName) {
        return new Username(userName);
    }

    private void checkUsernameLength(String username) {
        if (username.length() > MAX_USERNAME_LENGTH) {
            throw new UserNameTooLongException(username);
        }
    }
}