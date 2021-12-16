package anemic.services;
import anemic.exceptions.UserAlreadyBlockedException;
import anemic.exceptions.UserNotFoundException;
import anemic.model.User;
import anemic.repository.UserRepository;

/*
 serviço responsável por bloquear usuários. 
 Tal como acontece com a ativação - um usuário só pode ser bloqueado uma vez. Não é possível bloquear um usuário bloqueado anteriormente.
*/
public class UserBlockerService {

    private final UserRepository userRepository;


    public UserBlockerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void block(User user) {
        userRepository.getById(user.getUserId()).orElseThrow(UserNotFoundException::new);

        validateIfUserIsNotBlocked(user);
        user.setBlocked(true);

        userRepository.save(user);
    }

    private void validateIfUserIsNotBlocked(User user) {
        if (user.isBlocked()) {
            throw new UserAlreadyBlockedException(user);
        }
    }
}