package anemic.exceptions;
import anemic.model.User;

public class UserAlreadyBlockedException extends RuntimeException {

    public UserAlreadyBlockedException(User user) {
    }
    
}
