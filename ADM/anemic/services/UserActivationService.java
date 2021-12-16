package anemic.services;
import java.util.UUID;

import anemic.exceptions.UserAlreadyActivatedException;
import anemic.exceptions.UserNotFoundException;
import anemic.model.User;
import anemic.repository.UserRepository;

/*
  Serviço responsável pela ativação do usuário. 
  Um usuário só pode ser ativado uma vez!
*/
public class UserActivationService {

    private final UserRepository userRepository;

    public UserActivationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void activateUser(UUID userId) {
        var user = userRepository.getById(userId).orElseThrow(UserNotFoundException::new);
        validateIfUserIsActive(user);
        user.setActive(true);
        userRepository.save(user);
    }

    private void validateIfUserIsActive(User user) {
        if (user.isActive()) {
            throw new UserAlreadyActivatedException(user);
        }
    }

}