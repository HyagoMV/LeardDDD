public class User {

    private UUID userId;
    private Username userName;
    private Email email;
    private boolean isBlocked;
    private boolean isActive;

    private User(UUID userId, Username userName, Email email, boolean isBlocked, boolean isActive) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.isBlocked = isBlocked;
        this.isActive = isActive;
    }

    public static User create(UUID userId, Username userName, Email email) {
        var isBlocked = false;
        var isActive = false;
        return new User(userId, userName, email, isBlocked, isActive);
    }

    public void block() {
        if (!canBeBlocked())
          throw new IllegalStateExceptioncom("User can not be blocked");
        this.isBlocked = true;
    }

    public void activate() {
        if (!canBeActivated())
            throw new IllegalStateExceptioncom("User is already activated");
        this.isActive = true;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public boolean isActive() {
        return isActive;
    }

    public UUID getUserId() {
        return userId;
    }

    public Username getUserName() {
        return userName;
    }

    private boolean canBeActivated() {
        return !isActive;
    }

    private boolean canBeBlocked() {
        return !isBlocked;
    }
}