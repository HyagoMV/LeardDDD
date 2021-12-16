package anemic.exceptions;
import anemic.model.User;

public class UserAlreadyActivatedException extends RuntimeException {

    public UserAlreadyActivatedException(User user) {
    }
    
}
